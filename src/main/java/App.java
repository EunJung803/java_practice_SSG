import java.util.Scanner;

public class App {

    public void run() {

        System.out.println("== 명언 SSG ==");

        // 명령을 입력받을 스캐너 선언
        Scanner sc = new Scanner(System.in);

        outer:      // break outer 하면 여기로 돌아오도록 라벨 설정
        while(true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            switch (command) {
                case "종료":
                    break outer;    // switch문을 빠져나가며 outer 지점으로 돌아간다.
            }
        }
    }
}
