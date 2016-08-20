import sun.org.mozilla.javascript.internal.ast.WhileLoop;

import java.io.*;

/**
 * Created by Administrator on 8/20/2016.
 */
public class createFileUtil {
    public static void main(String[] args) {
        String dirName = "c:/javaDir";
        createDir(dirName);
        String fileName = "javatestfile.txt";
        String createFileName = dirName + "/" + fileName;
        createFile(createFileName);
        getFileInfo(createFileName);
        WriteStringToFileByPrintStream(createFileName);
        WriteStringToFileByFileWriter(createFileName);

    }

    /*Create a file, doesn't specify the path*/
    public static boolean createFile(String createdFileName) {
        File file = new File(createdFileName);
        if (file.exists()) {
            System.out.println("File: " + file.getName() + " already exist, no need to create. File Path: " + file.getAbsolutePath());
            return false;
        }
        try {
            if (file.createNewFile()) {
                System.out.println("File: " + file.getName() + " create successfullly!! File path: " + file.getAbsolutePath());
                return true;
            } else {
                System.out.println("Fail to create file " + file.getName());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("The directory " + dir.getName() + " already exist, no need to create");
            return false;
        }
        if (dir.mkdir()) {
            System.out.println("create directory successfully, the path is " + dir.getAbsolutePath());
            return true;
        } else {
            System.out.println("fail to create directory");
            return false;
        }
    }

    public static void getFileInfo(String fileName) {
        File file = new File(fileName);
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File lengh: " + file.length());
    }

    public static void WriteStringToFileByPrintStream(String filePath) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            String writeString = "This is a test, you can add log, or anything you want to write!Thanks";
            PrintStream ps= new PrintStream(new FileOutputStream(f));
            ps.println(writeString);
            ps.append("This is append string+q");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void WriteStringToFileByFileWriter(String filePath){
        try {
            FileWriter fw=new FileWriter(filePath,true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("\r\nabc+cndsd\r\n");
            bw.append("\r\nThis is bufferwiter append!!!\r\n");
            bw.append("\nThis setence is for next line!!\n");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
