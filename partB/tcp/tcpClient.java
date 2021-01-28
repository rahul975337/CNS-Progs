package partB.tcp;

import java.net.*;
import java.io.*;

public class tcpClient {
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("localhost", 4000);
        System.out.println("Enter the filename");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();
        // SENDING TO SERVER
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);
        // RECEIVING FROM SERVER
        InputStream istream = sock.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        String str;
        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }
        pwrite.close();
        socketRead.close();
        keyRead.close();
    }

}
