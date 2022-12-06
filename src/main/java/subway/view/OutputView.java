package subway.view;

import subway.constant.MainMenu;
import subway.constant.PathMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String MAIN_MENU = "\n## 메인 화면";
    private static final String PATH_MENU = "\n## 경로 기준";
    private static final String RESULT = "\n## 조회 결과";
    private static final String INFO_TAG = "[INFO] %s\n";
    private static final String DIVIDE_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리: %dkm";
    private static final String TOTAL_TIME = "총 소요 시간: %d분";

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

    public void printPathResult(List<String> path, List<Integer> weights) {
        List<String> values = weightToStringFormat(weights);
        values = Stream.concat(values.stream(), path.stream())
                .collect(Collectors.toList());

        System.out.println(RESULT);
        for (String value : values) {
            System.out.printf(INFO_TAG, value);
        }
    }

    private List<String> weightToStringFormat(List<Integer> weights) {
        int distance = weights.get(0);
        int time = weights.get(1);

        return Arrays.asList(DIVIDE_LINE, String.format(TOTAL_DISTANCE, distance),
                String.format(TOTAL_TIME, time), DIVIDE_LINE);
    }
}
