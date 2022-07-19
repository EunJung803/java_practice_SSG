import java.util.List;

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
