package abc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PostFile {
    public static void main(String[] args) {

        File f =  new File("C:\\Users\\Shrehit Goel\\Desktop\\testimage.jpg");
          String encodstring = encodeFileToBase64Binary(f);
          System.out.println(encodstring);
    }

    private static String encodeFileToBase64Binary(File file){
         String encodedFile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedFile = Base64.getEncoder().encodeToString(bytes);
             fileInputStreamReader.close();
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return encodedFile;
     }
}