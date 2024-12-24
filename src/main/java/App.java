import java.util.Scanner;

public class App {
    private int lastId = 0;
    private int wiseSayingSize = 0;
    private final WiseSaying[] wiseSayingList = new WiseSaying[5];

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        // 테스트 데이터
        add("현재를 사랑하라.", "작자미상");
        add("과거에 집착하지 마라.", "작자미상");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                add(content, author);
                System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseSayingSize - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getAuthor());
                }
            }
        }
    }

    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList[wiseSayingSize++] = wiseSaying;
    }
}