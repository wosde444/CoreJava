package netcoding;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket sc = new ServerSocket(8888);
        Socket socket = sc.accept();
        InputStream in = socket.getInputStream();
        byte[] name = new byte[1024];
        int length = in.read(name);
        String str = new String(name, 0, length);
        System.out.println("from client:" + str);
        File file = new File("C:/Users/han/Desktop/dir1/dir2/"+str);
        FileOutputStream fo = new FileOutputStream(file);
        byte[] fileByte = new byte[1024];
        int len;
        while ((len = in.read(fileByte)) != -1) {
            fo.write(fileByte, 0, len);
        }
        OutputStream out = socket.getOutputStream();
        out.write("you file have been recieved!".getBytes());
        out.flush();
        socket.close();
        sc.close();
    }
}
