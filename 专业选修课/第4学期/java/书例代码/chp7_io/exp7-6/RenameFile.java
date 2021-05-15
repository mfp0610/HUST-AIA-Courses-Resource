import java.io.*;
import java.util.Date;

public class RenameFile{
 
 //显示文件基本信息。
  private static void fileData(File f) {
    System.out.println(
      "Absolute path: " + f.getAbsolutePath() +
      "\n Can read: " + f.canRead() +
      "\n Can write: " + f.canWrite() +
      "\n getName: " + f.getName() +
      "\n getParent: " + f.getParent() +
      "\n getPath: " + f.getPath() +
      "\n length: " + f.length() +
      "\n lastModified: " + new Date(f.lastModified()));
    if(f.isFile())
      System.out.println("It's a file");
    else if(f.isDirectory())
      System.out.println("It's a directory");
  }
  
  //将命令行第一个参数是原来的文件名，第二个参数是新文件名。
  public static void main(String[] args) {
  
      File old = new File(args[0]);   
      File rname = new File(args[1]);
    
      System.out.println("The original file's information:");
      fileData(old);
      old.renameTo(rname);
      System.out.println("\n The file information after rename:");
      fileData(rname);  //文件重命名。
      if (!old.exists()){
         System.out.println("\n The original file never exists."); 
      }
  }  
}