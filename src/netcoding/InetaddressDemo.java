package netcoding;

import java.net.InetAddress;

public class InetaddressDemo {
    public static void main(String[]args)throws Exception{
        InetAddress address_1= InetAddress.getByName("www.baidu.com");
        
        System.out.println(address_1);
        System.out.println(address_1.getAddress());
        System.out.println(address_1.getHostAddress());
        System.out.println(address_1.getHostName());

        InetAddress address_2 = InetAddress.getLocalHost();
        System.out.println(address_2.getHostName());
        System.out.println(address_2.getHostAddress());

    }
}
