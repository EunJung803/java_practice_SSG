import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {

        System.out.println("== 명언 SSG ==");

        // 명령을 입력받을 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // id 저장할 변수 선언
        int id = 0;

        // WiseSaying 객체를 담는 리스트 선언
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        outer:      // break outer 하면 여기로 돌아오도록 라벨 설정
        while(true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            switch (command) {

                case "목록":
                    System.out.println("번호 / 작가 / 명언\n" +
                            "----------------------");
                    for (int i=wiseSayingList.size()-1; i>=0; i--) {
                        WiseSaying wiseSayingList_element = wiseSayingList.get(i);  // i번째에 있는 WiseSaying element

                        // 그 element에서 id, quote, author을 출력하여 보여준다.
                        System.out.printf("%d / %s / %s \n",
                                wiseSayingList_element.id, wiseSayingList_element.author, wiseSayingList_element.quote);
                    }

                    break ;

                case "등록":
                    System.out.printf("명언 : ");
                    String quote = sc.nextLine().trim();    // 명언을 담는 String 변수 quote
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();   // 작가명을 담는 String 변수 author

                    id++; // 등록 시 id 증가

                    WiseSaying wiseSaying = new WiseSaying(id, quote, author);  // WiseSaying 객체에 담기
                    wiseSayingList.add(wiseSaying);     // 담은걸 list에 추가

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);

//                    System.out.println(wiseSaying);     // 객체에 잘 담겼는지 확인용

                    break ;

                case "종료":
                    break outer;    // switch문을 빠져나가며 outer 지점으로 돌아간다.
            }
        }
    }
}
