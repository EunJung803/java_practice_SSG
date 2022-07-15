import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");
        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    void testing() {
        String rs = "1";
        assertEquals("1", rs);
    }
}
