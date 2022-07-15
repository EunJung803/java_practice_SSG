import java.util.Scanner;

public class WiseSayingController {

    // 명령을 입력받을 스캐너 선언
    private static Scanner sc;

    // Repository 선언
    static WiseSayingRepository wiseSaying_Repo;

    public WiseSayingController(Scanner sc) {     //initializing
        this.sc = sc;
        wiseSaying_Repo = new WiseSayingRepository();
    }

    public static void delete(Rq rq) {
        int delete_id = rq.getIntParam("id", 0);    // 사용자가 삭제하고자 하는 명언의 아이디를 담을 변수

        if(delete_id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying_wantDelete = wiseSaying_Repo.findById(delete_id);    // Repository에 있는 findById로 존재하는지 탐색

        if(wiseSaying_wantDelete == null) {     // 존재하지 않는 경우
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", delete_id);
            return;
        }

        // 찾았으면 그 WiseSaying은 삭제 !
        wiseSaying_Repo.wiseSayingList.remove(wiseSaying_wantDelete);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", delete_id);
    }

    public static void viewList(Rq rq) {
        System.out.println("번호 / 작가 / 명언\n" +
                "----------------------");
        for (int i = wiseSaying_Repo.wiseSayingList.size()-1; i>=0; i--) {
            WiseSaying wiseSayingList_element = wiseSaying_Repo.wiseSayingList.get(i);  // i번째에 있는 WiseSaying element

            // 그 element에서 id, quote, author을 출력하여 보여준다.
            System.out.printf("%d / %s / %s \n",
                    wiseSayingList_element.id, wiseSayingList_element.author, wiseSayingList_element.quote);
        }
    }

    public static void modify(Rq rq) {
        int modify_id = rq.getIntParam("id", 0);    // 사용자가 수정하고자 하는 명언의 아이디를 담을 변수

        if(modify_id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying_wantModify = wiseSaying_Repo.findById(modify_id);

        if(wiseSaying_wantModify == null) {     // 존재하지 않는 경우
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", modify_id);
            return;
        }

        // 찾았으면 수정 진행
        System.out.printf("명언(기존) : %s\n", wiseSaying_wantModify.quote);
        System.out.printf("명언 : ");
        wiseSaying_wantModify.quote = sc.nextLine().trim();
        System.out.printf("작가(기존) : %s\n", wiseSaying_wantModify.author);
        System.out.printf("작가 : ");
        wiseSaying_wantModify.author = sc.nextLine().trim();

        System.out.printf("%d번 명언이 수정되었습니다.\n", modify_id);
    }

    public static void add(Rq rq) {
        System.out.printf("명언 : ");
        String quote = sc.nextLine().trim();    // 명언을 담는 String 변수 quote
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();   // 작가명을 담는 String 변수 author

        wiseSaying_Repo.id++; // 등록 시 id 증가

        WiseSaying wiseSaying = new WiseSaying(wiseSaying_Repo.id, quote, author);  // WiseSaying 객체에 담기
        wiseSaying_Repo.wiseSayingList.add(wiseSaying);     // 담은걸 list에 추가

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying_Repo.id);
    }

}
