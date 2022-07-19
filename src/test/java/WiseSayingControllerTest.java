import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiseSayingControllerTest {
    @Test
    public void 등록_test() {
        String rs = AppTestRunner.run("""
                등록
                명언1
                작가1
                종료
                """);
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }
    @Test
    public void 등록_id출력_test() {
        String rs = AppTestRunner.run("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                종료
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));
    }
    @Test
    public void 목록_test() {
        String rs = AppTestRunner.run("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                목록
                종료
                """);
        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("----------------------"));
        assertTrue(rs.contains("2 / 작가2 / 명언2"));
        assertTrue(rs.contains("1 / 작가1 / 명언1"));
    }

    @Test
    public void 삭제_test() {
        String rs = AppTestRunner.run("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                삭제?id=1
                목록
                삭제?id=1
                종료
                """);

        assertTrue(rs.contains("1번 명언이 삭제되었습니다."));
        assertTrue(rs.contains("2 / 작가2 / 명언2"));
        assertFalse(rs.contains("1 / 작가1 / 명언1"));
        assertTrue(rs.contains("1번 명언은 존재하지 않습니다."));
    }

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

}
