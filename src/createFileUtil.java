import sun.org.mozilla.javascript.internal.ast.WhileLoop;

import java.io.*;

/**
 * Created by Administrator on 8/20/2016.
 */
public class createFileUtil {
    public static void main(String[] args) {
        String dirName = "c:/javaDir";
        createDir(dirName);
        String fileName = "javaTestFile.txt";
        String createFileName = dirName + "/" + fileName;
        createFile(createFileName);
        getFileInfo(createFileName);
        WriteStringToFileByPrintStream(createFileName);
        WriteStringToFileByFileWriter(createFileName);
        WriteStringToFileByPrintWriter(createFileName);
//        WrtieStringToFileByRandomAccessFile(createFileName);

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
        System.out.println("File length: " + file.length());
    }

    public static void WriteStringToFileByPrintStream(String filePath) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            String writeString = "2. Print Stream\n";
            String writeString2="This String is write by Print Stream.\n";
            PrintStream ps = new PrintStream(new FileOutputStream(f));
            ps.println(writeString);
//            ps.append("This is append By Print Stream\n");
            ps.println("This is append By Print Stream\n");
            ps.println(writeString2);
            ps.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void WriteStringToFileByFileWriter(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("3. File Writeer");
            bw.newLine();
            bw.append("This is add by File Writer");
            bw.newLine();
            bw.append("Add text by append function");
            bw.newLine();
            bw.append("BufferedWriter can not use \\n to new line, it need .newLine() function");
            bw.newLine();
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void WriteStringToFileByPrintWriter(String filePath) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filePath, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.append("\n");
        pw.append("\n4.Print Writer ");
        pw.append("\nWrite String to file by print writer.");
        pw.append("\nPrint writer will send the string to FileWriter");
        pw.append("\nand then File Writer write string to file");
        pw.append("\n this is apend");
        pw.close();
    }

    public static void WrtieStringToFileByRandomAccessFile(String filePath) {
        try {
            RandomAccessFile raf=new RandomAccessFile(filePath,"rw");
            raf.writeBytes("\n1. Random Access File");
            raf.writeBytes("\nThe string is write by random access file class");
            raf.writeBytes("\nPlease note that, when you finished, you need to add close");
            raf.writeBytes("\n");
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
