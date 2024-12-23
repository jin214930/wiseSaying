import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        System.out.println("명령) 등록");
        System.out.print("명언 : ");
        scanner.nextLine();
        System.out.print("작가 : ");
        scanner.nextLine();
        System.out.println("명령) 종료");
    }
}
