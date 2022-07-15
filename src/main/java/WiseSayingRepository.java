import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    // id 저장할 변수 선언
    public static int id;

    // WiseSaying 객체를 담는 리스트 선언
    public static List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        id = 0;
        wiseSayingList = new ArrayList<>();
    }

    public WiseSaying findById(int id) {
        for(WiseSaying wiseSaying_founding : wiseSayingList) {    // 그 id에 해당하는 WiseSaying을 찾는 과정
            if(wiseSaying_founding.id == id) {
                return wiseSaying_founding;
            }
        }

        return null;
    }

    // 삭제
    public void remove(int delete_id) {
        WiseSaying wiseSaying_found = findById(delete_id);
        wiseSayingList.remove(wiseSaying_found);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;  // List return
    }

    // 수정
    public void modify(int modify_id, String quote, String author) {
        WiseSaying wiseSaying_found = findById(modify_id);
        wiseSaying_found.quote = quote;
        wiseSaying_found.author = author;
    }

    // 등록
    public WiseSaying add(String quote, String author) {
        int wiseId = ++id;// id 증사시켜서 wiseId에 저장
        WiseSaying wiseSaying = new WiseSaying(wiseId, quote, author);  // 새로운 WiseSaying 객체 생성 + 데이터 삽입

        wiseSayingList.add(wiseSaying);     // 리스트에 등록하여 저장

        return wiseSaying;
    }
}
