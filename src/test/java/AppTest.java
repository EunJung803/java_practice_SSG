import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void Rq_test2() {
        Rq rq = new Rq("삭제?id=1");

        String path = rq.getPath();

        assertEquals("삭제", path);
    }

    @Test
    public void Rq_test() {
        Rq rq = new Rq("삭제?id=1");

        int id = rq.getIntParam("id", 0);

        assertEquals(1, id);
    }

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
