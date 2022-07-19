import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {
    @Test
    public void 저장() {
        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");

        wiseSayingTable.save("나에게 불가능이란 없다", "나폴레옹");
        assertTrue(new File("test_data/wise_saying/1.json").exists());

        wiseSayingTable.save("내 죽음을 적들에게 알리지 마라", "이순신 장군");
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }

//    @Test
//    public void 번호_없이_들어왔을때_자동넘버링_해주기() {
//        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");
//        wiseSayingTable.save("나에게 불가능이란 없다", "나폴레옹");
//
//        assertTrue(new File("test_data/wise_saying/1.json").exists());
//    }
//
//    @Test
//    public void 등록을_하면_명언과_작가를_물어본다() {
//        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");
//        WiseSaying wiseSaying = new WiseSaying(1, "나에게 불가능이란 없다", "나폴레옹");
//        wiseSayingTable.save(wiseSaying);
//
//        assertTrue(new File("test_data/wise_saying/1.json").exists());
//    }
}
