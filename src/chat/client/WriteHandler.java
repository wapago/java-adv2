package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable{
    private final DataOutputStream output;
    private final Client client;
    public boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        try {
            while (true) {
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);
                System.out.println(toSend);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("readHandler 종료");
    }
}
