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
}
