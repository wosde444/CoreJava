package IO;

import java.io.*;

public class FileIODemo2 {
    public static void main(String[] args) {
        File imageIn = new File("C:/Users/han/Desktop/1.jpg");
        File imageOut = new File("C:/Users/han/Desktop/dir1/image1.jpg");
        File imageIn2 = new File("C:/Users/han/Desktop/2.jpg");
        File imageOut2 = new File("C:/Users/han/Desktop/dir1/image2.jpg");
        if (!imageOut.exists()) {
            try {
                imageOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!imageOut2.exists()) {
            try {
                imageOut2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fi = null;
        FileOutputStream fo = null;
        byte[] bu = new byte[1024];
        try {
            fi = new FileInputStream(imageIn2);
            fo = new FileOutputStream(imageOut2);
            while (fi.read(bu) != -1) {
                fo.write(bu);
                fo.flush();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } finally {
                    if (fo != null) {
                        try {
                            fo.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        byte[] buffer = new byte[1024];
        try {
            bi = new BufferedInputStream(new FileInputStream(imageIn));
            bo = new BufferedOutputStream(new FileOutputStream(imageOut));
            while (bi.read(buffer, 0, 1024) != -1) {
                bo.write(buffer);
                bo.flush();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } finally {
                    if (bo != null) {
                        try {
                            bo.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
