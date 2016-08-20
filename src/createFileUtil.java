import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 8/20/2016.
 */
public class createFileUtil {
    public static void main(String[] args) {

        createFile("secondFile.txt");
    }

    /*Create a file, doesn't specify the path*/
    public static boolean createFile(String createdFileName) {
        File file = new File(createdFileName);
        if (file.exists()) {
            System.out.println("File: " + file.getName() + " already exist, no need to create. File Path: "+file.getAbsolutePath());
            return false;
        }
        try {
            if (file.createNewFile()) {
                System.out.println("File: "+file.getName()+" create successfullly!! File path: "+file.getAbsolutePath());
                return true;
            }
            else{
                System.out.println("Fail to create file "+file.getName());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
