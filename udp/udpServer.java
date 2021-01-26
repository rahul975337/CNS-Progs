package udp;

import java.util.*;
import java.net.*;

public class udpServer {
    public static void main(String[] agrs) throws Exception {

        Scanner sc = new Scanner(System.in);
        DatagramSocket skt = new DatagramSocket(38880);
        System.out.println("SERVER IS READY...");
        while (true) {
            byte bufferRecv[] = new byte[1024];
            DatagramPacket recv = new DatagramPacket(bufferRecv, bufferRecv.length);
            skt.receive(recv);
            String msg = new String(recv.getData());
            System.out.println("Client " + msg);
            System.out.println("Server: ");
            String m = sc.nextLine();
            byte bufferSend[] = m.getBytes();
            DatagramPacket sent = new DatagramPacket(bufferSend, bufferSend.length, recv.getAddress(), recv.getPort());
            skt.send(sent);
        }

    }
}
