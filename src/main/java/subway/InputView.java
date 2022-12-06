package subway;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_SELECT_MENU = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "\n## 출발역을 입력하세요.";
    private static final String INPUT_ARRIVAL_STATION = "\n## 도착역을 입력하세요.";

    public String readSelectMenu(Scanner scanner) {
        System.out.println(INPUT_SELECT_MENU);
        return scanner.nextLine();
    }

    public String readStartStation(Scanner scanner) {
        System.out.println(INPUT_START_STATION);
        return scanner.nextLine();
    }

    public String readArrivalStation(Scanner scanner) {
        System.out.println(INPUT_ARRIVAL_STATION);
        return scanner.nextLine();
    }
}
