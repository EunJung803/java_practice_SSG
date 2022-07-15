import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public void run() {

        System.out.println("== 명언 SSG ==");

        // 명령을 입력받을 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // ArrayList 선언
        ArrayList<String> quoteList = new ArrayList<String>();  // 명언 리스트
        ArrayList<String> authorList = new ArrayList<String>(); // 작가 리스트

        // id 저장할 변수 선언
        int id = 0;

        outer:      // break outer 하면 여기로 돌아오도록 라벨 설정
        while(true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            switch (command) {
                case "등록":
                    System.out.printf("명언 : ");
                    quoteList.add(sc.nextLine().trim());    // 명언 리스트에 명언 추가
                    System.out.printf("작가 : ");
                    authorList.add(sc.nextLine().trim());   // 작가 리스트에 작가 추가

                    id++;

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);

                    break ;

                case "종료":
                    break outer;    // switch문을 빠져나가며 outer 지점으로 돌아간다.
            }
        }
    }
}
