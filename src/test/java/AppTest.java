import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        String input = """
                등록
                명언
                작가
                """.stripIndent();

        InputStream in = new ByteArrayInputStream(input.getBytes());

        Scanner sc = new Scanner(in);
        String cmd1 = sc.nextLine().trim();
        String quote = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd1);
        assertEquals("명언", quote);
        assertEquals("작가", author);
    }

    @Test
    void testing() {
        String rs = "1";
        assertEquals("1", rs);
    }
}
