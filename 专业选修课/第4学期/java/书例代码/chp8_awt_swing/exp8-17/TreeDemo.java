import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;

public class TreeDemo extends JFrame {

    //树中要显示的数据。
    String[][] data = {{"Books for Java Programmers",
        					"The Java Tutorial: Object-Oriented Programming for the Internet",
        					"The Java Tutorial Continued: The Rest of the JDK",
        					"The JFC Swing Tutorial: A Guide to Constructing GUIs",
        					"The Java Programming Language",
        					"The Java FAQ",
        					"The Java Class Libraries: An Annotated Reference",
        					"Concurrent Programming in Java: Design Principles and Patterns"},
        				{"Books for Java Implementers",
        					"The Java Virtual Machine Specification",
        					"The Java Language Specification"}
        			      };
   
    public TreeDemo() {
        super("TreeDemo");
            						       						         						 
        //创建树的根节点。
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Java Series");
        
        //创建树的两个枝并添加到根节点上。
        for( int i = 0; i<data.length; i++){
			top.add(createBranch(data[i]));
		}

        //创建树，一次只允许选取一个节点。
        final JTree tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //为树注册监听器，监听用户所选取节点的变化。
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                                   tree.getLastSelectedPathComponent();
                if (node == null) return;
                Object nodeInfo = node.getUserObject();              
                System.out.println(nodeInfo.toString());
            }
               
         });

         //创建滚动面板并将树放入其中。 
        JScrollPane treeView = new JScrollPane(tree);

        //将滚动面板加到当前窗口中。
        getContentPane().add(treeView, BorderLayout.CENTER);
    }


    //创建以data[0]对象为根的一个枝。
    DefaultMutableTreeNode createBranch(String[] data){
    	DefaultMutableTreeNode category = new DefaultMutableTreeNode(data[0]); 
        DefaultMutableTreeNode book = null;
        
        for( int i =1; i<data.length; i++){
        	book = new DefaultMutableTreeNode(data[i]); 
    		category.add(book);
    	}
    	
    	return category;
    }
    

    public static void main(String[] args) {
        JFrame frame = new TreeDemo();
 
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });  
 
   		frame.setSize(400,250);
        frame.setVisible(true);
    }
}
