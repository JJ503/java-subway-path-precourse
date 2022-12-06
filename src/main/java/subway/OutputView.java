package subway;

public class OutputView {
    private static final String MAIN_MENU = "## 메인 화면\n1. 경로 조회\nQ. 종료\n";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }
}
