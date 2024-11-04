package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        // BufferedOutputStream은 내부에서 단순히 버퍼기능만 제공함. FileOutputStream객체를 생성자에 전달.
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }

        // FileOutputStream까지 연쇄적으로 close된다. 반드시 마지막에 호출한 것을 close해야 한다.
        bos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
