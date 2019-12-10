package sampleCode;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 夏先鹏
 * @date 2019/09/17
 * @time 15:51
 */
public class InetAddressTest {

    public static void main(String[] args) {

        String address = "";
        String hostName = "";
        try {
            java.net.InetAddress addr = java.net.InetAddress.getLocalHost();
            address = addr.getHostAddress();
            hostName = addr.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address);
        System.out.println(hostName);
    }
}
