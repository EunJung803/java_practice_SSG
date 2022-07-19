import java.util.List;

// 서비스는 리포지터리에게 데이터를 넘겨주는 역할
// 이 데이터 이걸로 이렇게 처리해 ~ 하고 넘겨준다.

// 컨트롤러가 받은 주문을 서비스가 받아서 요리할껀데 이 요리를 위해서 재료를 다듬는건 리포지터리에게 시킨다.
// 요리사 == 서비스

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying add(String quote, String author) {
        return wiseSayingRepository.add(quote, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean modify(int id, String quote, String author) {
        return wiseSayingRepository.modify(id, quote, author);
    }

    public boolean remove(int id) {
        return wiseSayingRepository.remove(id);
    }
}
