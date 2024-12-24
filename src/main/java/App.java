import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private int lastId = 0;
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);


    public void run() {
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
                registerWiseSaying();
            } else if (command.equals("목록")) {
                printWiseSayingList();
            } else if (command.startsWith("삭제?id=")) {
                int deleteId = Integer.parseInt(command.substring(6));
                if (deleteWiseSaying(deleteId)) {
                    System.out.printf("%d번 명언이 삭제되었습니다.", deleteId);
                } else {
                    System.out.printf("%d번 명언은 존재하지 않습니다.", deleteId);
                }
            }
        }
    }

    private boolean deleteWiseSaying(int deleteId) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == deleteId) {
                wiseSayingList.remove(wiseSaying);
                return true;
            }
        }

        return false;
    }

    private void registerWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        add(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);
    }


    private void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    private void add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList.add(wiseSaying);
    }
}