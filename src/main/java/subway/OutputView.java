package subway;

public class OutputView {
    private static final String MAIN_MENU = "## 메인 화면\n1. 경로 조회\nQ. 종료\n";
    private static final String PATH_MENU = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printPathMenu() {
        System.out.println(PATH_MENU);
    }
}
