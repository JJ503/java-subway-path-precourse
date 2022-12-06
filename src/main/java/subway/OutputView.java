package subway;

import jdk.jfr.internal.tool.Main;

public class OutputView {
    private static final String MAIN_MENU = "## 메인 화면\n";
    private static final String PATH_MENU = "## 경로 기준\n";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.println(mainMenu.getMenuMessage());
        }
    }

    public void printPathMenu() {
        System.out.println(PATH_MENU);
        for (PathMenu pathMenu : PathMenu.values()) {
            System.out.println(pathMenu.getMenuMessage());
        }
    }
}
