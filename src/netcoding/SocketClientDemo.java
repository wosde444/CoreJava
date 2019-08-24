package netcoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientDemo {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 8888);
        OutputStream out = client.getOutputStream();
        out.write("imagetest.jpg".getBytes());
        out.flush();
        File f = new File("C:/Users/han/Desktop/dir1/image2.jpg");
        FileInputStream fi = new FileInputStream(f);
        byte[] fileByte = new byte[1024];
        int len;
        while ((len = fi.read(fileByte)) != -1) {
            out.write(fileByte, 0, len);
        }
        client.shutdownOutput();
        InputStream in = client.getInputStream();
        byte[] b = new byte[1024];
        int num = in.read(b);
        String str = new String(b, 0, num);
        System.out.println("reply from server:" + str);
        client.close();
    }
}
