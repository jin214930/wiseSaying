import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    int lastId = 0;
    int wiseSayingSize = 0;
    WiseSaying[] wiseSayingList = new WiseSaying[5];

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
                    System.out.printf("%d / %s / %s\n", wiseSayingList[i].id, wiseSayingList[i].author, wiseSayingList[i].content);
                }
            }
        }
    }

    public void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList[wiseSayingSize++] = wiseSaying;
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}