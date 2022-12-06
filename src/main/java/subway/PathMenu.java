package subway;

import java.util.Arrays;

public enum PathMenu {
    PATH_MENU1("1", "최단 거리"),
    PATH_MENU2("2", "최소 시간"),
    PATH_MENU3("B", "돌아가기");

    private final String option;
    private final String menu;

    PathMenu(String option, String menu) {
        this.option = option;
        this.menu = menu;
    }

    public String getMenuMessage() {
        return String.format("%s. %s", option, menu);
    }

    public static PathMenu getMenu(String option) {
        return Arrays.stream(values())
                .filter(value -> value.option.equals(option))
                .findAny()
                .orElse(null);
    }
}
