package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            // timeout 시간 설정 가능
            Socket socket = new Socket();   // 1. 빈 객체 생성
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000); // 2. connect()통해서 연결
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end: " + (end - start));
    }
}
