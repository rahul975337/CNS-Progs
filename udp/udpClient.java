package udp;

import java.util.*;
import java.net.*;

public class udpClient {
    public static void main(String[] agrs) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket skt = new DatagramSocket();
        InetAddress host = InetAddress.getByName("localhost");
        int s_port = 38880;
        while (true) {
            System.out.println("Client: ");
            String msg = sc.nextLine();
            byte bufferSend[] = msg.getBytes();
            DatagramPacket sent = new DatagramPacket(bufferSend, bufferSend.length, host, s_port);
            skt.send(sent);
            byte bufferRecv[] = new byte[1024];
            DatagramPacket recv = new DatagramPacket(bufferRecv, bufferRecv.length);
            skt.receive(recv);
            String m = new String(recv.getData());
            System.out.println("Server " + m);
        }

    }
}