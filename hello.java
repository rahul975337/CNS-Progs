import java.io.*;
import java.net.*;

class server {

    public static void main(String[] args) throws Exception {
        ServerSocket serSock = new ServerSocket(4000);
        System.out.println("Server is ready for connection");

        Socket sock = serSock.accept();
        System.out.println("Connection successfull !!!!");

        InputStream iStream = sock.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream));
        String fname = bufferedReader.readLine();
        BufferedReader bReader = new BufferedReader(new FileReader(fname));
        OutputStream oStream = sock.getOutputStream();
        PrintWriter pWriter = new PrintWriter(oStream, true);
        String content;
        while ((content = bReader.readLine()) != null) {
            pWriter.println(content);
        }
        sock.close();
        serSock.close();
        bReader.close();
        bufferedReader.close();
        pWriter.close();
    }
}
