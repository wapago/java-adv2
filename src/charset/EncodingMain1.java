package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS_949");

    public static void main(String[] args) {
        System.out.println("=== ASCII 영문 처리 ===");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16);
        encoding("A", UTF_16BE);

        System.out.println("====== 한글 지원 ======");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", UTF_8);

        System.out.println("======================");
        String str = "hello";
        byte[] bytes = str.getBytes(UTF_8); // 문자집합을 지정하지 않으면 system default 인코딩함
        System.out.println("bytes = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}