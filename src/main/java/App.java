import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // 명령을 입력받을 스캐너 선언
    private Scanner sc;
    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {

        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:      // break outer 하면 여기로 돌아오도록 라벨 설정
        while(true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            // 명령을 앞으로 Path에 담을 것
            Rq rq = new Rq(command);
            String Path = rq.getPath();

            switch (Path) {
                case "수정":
                    wiseSayingController.modify(rq);
                    break;

                case "삭제":
                    wiseSayingController.delete(rq);
                    break ;

                case "목록":
                    wiseSayingController.viewList(rq);
                    break ;

                case "등록":
                    wiseSayingController.add(rq);
                    break ;

                case "종료":
                    break outer;    // switch문을 빠져나가며 outer 지점으로 돌아간다.
            }
        }
    }
}
