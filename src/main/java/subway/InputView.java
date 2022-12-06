package subway;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_SELECT_MENU = "## 원하는 기능을 선택하세요.\n";

    public String readSelectMenu(Scanner scanner) {
        System.out.println(INPUT_SELECT_MENU);
        return scanner.nextLine();
    }
}
