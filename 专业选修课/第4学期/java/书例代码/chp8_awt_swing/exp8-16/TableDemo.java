import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;

public class TableDemo extends JFrame {
    private boolean DEBUG = true;

    public TableDemo() {
        super("TableDemo");

        MyTableModel myModel = new MyTableModel();
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //表格常常放在滚动面板中。 
        JScrollPane scrollPane = new JScrollPane(table);

        //将滚动面板放在窗口中。
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

	
	/*自定义表格数据模型。其中的方法都是AbstractTableModel中的方法。
	  该类是内部类。*/
    class MyTableModel extends AbstractTableModel {
        
        //定义表格的列名。
        final String[] columnNames = {"姓名", "学号", "专业", "性别", "年龄", "婚否"};
        
        //定义表格中的5行数据。
        final Object[][] data = {
            {"张山", "200101", "男",
             "计算机", new Integer(20), new Boolean(false)},
            {"王大民", "200103", "男",
             "计算机", new Integer(29), new Boolean(true)},
            {"刘均", "200204","女",
             "电子工程", new Integer(21), new Boolean(false)},
            {"李力", "200208","女",
             "自动控制", new Integer(25), new Boolean(true)},
            {"张爱军", "200301","男",
             "机械制造", new Integer(31), new Boolean(false)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        //获取列的数据类型，JTable使用该方法确定数据的显示格式。
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //如果表格是不可编辑的，则不需要实现该方法。
        public boolean isCellEditable(int row, int col) {
			//表格前两列不可编辑。
            if (col < 2) { 
                return false;
            } else {
                return true;
            }
        }

        //改变网格单元的值。
        public void setValueAt(Object value, int row, int col) {
        	
        	//打印输出修改数据的位置。
        	if (DEBUG) {  
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of " 
                                   + value.getClass() + ")");
            }

            if (data[0][col] instanceof Integer                        
                    && !(value instanceof Integer)) {                  
                   try {
                    data[row][col] = new Integer(value.toString());
                    fireTableCellUpdated(row, col);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(TableDemo.this,
                        "The \"" + getColumnName(col)
                        + "\" column accepts only integer values.");
                }
            } else {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }

          //打印输出修改后表格中的数据。
          if (DEBUG) {  
                System.out.println("New value of data:");
                int numRows = getRowCount();
                int numCols = getColumnCount();

                for (int i=0; i < numRows; i++) {
                	System.out.print("    row " + i + ":");
                	for (int j=0; j < numCols; j++) {
                    	System.out.print("  " + data[i][j]);
                	}
                	System.out.println();
            	}
            	System.out.println("--------------------------");
           }
      }
   }

 
    public static void main(String[] args) {
        TableDemo frame = new TableDemo();
        frame.pack();
        frame.setVisible(true);
    }
}
