package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIODemo1 {
    public static void main(String[] args) throws IOException{
        File dir1 = new File("C:/Users/han/Desktop/dir1");

        File file_out_1 = new File(dir1, "test.txt");
        if (!file_out_1.exists()) {
            file_out_1.createNewFile();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file_out_1);
            writer.write("您好~，我是说中文的！i am speak English!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try{
                    writer.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }

        FileReader reader = null;
        char[] readerBuffer = new char[1024];
        try{
            reader = new FileReader(file_out_1);
            reader.read(readerBuffer);
        }catch (IOException e1){
            e1.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }
        String str = new String(readerBuffer);
        System.out.println(str);
    }
}
