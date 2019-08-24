package IO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File dir1 = new File("C:/Users/han/Desktop/dir1");
        if (!dir1.exists()) {
            dir1.mkdir();
        }

        File dir2 = new File(dir1, "dir2");
        if (!dir2.exists()) {
            dir2.mkdir();
        }

        File file_out_1 = new File(dir1, "test.txt");
        if (!file_out_1.exists()) {
            file_out_1.createNewFile();
        }


        File file1 = new File(dir2, "test.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }

        File file2 = new File(dir2, "test2.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        }

        System.out.print("please enter the name of the file which you want to delete:");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        if (deleteFile(dir1, filename) == 1) {
            System.out.println("delete succeed!");
        }
    }

    private static int deleteFile(File dir, String fileName) {

        List<File> filesList = findByName(dir, fileName);
        if (!filesList.isEmpty()) {
            for (int i = 0;i<filesList.size();i++){
                filesList.get(i).delete();
            }
            return 1;
        } else {
            return 0;
        }
    }

    private static List<File> findByName(File dir, String fileName) {
        File[] filesInDir = dir.listFiles();
        List<File> filesList= new ArrayList<>();
        for (File f : filesInDir) {
            if (f.isDirectory()) {
                filesList =  findByName(f, fileName);
            }
            if (f.getName().equals(fileName)) {
                filesList.add(f);
            }
        }
        return filesList;
    }
}
