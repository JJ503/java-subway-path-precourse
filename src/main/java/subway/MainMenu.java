package subway;

import java.util.Arrays;

public enum MainMenu {
    MAIN_MENU1("1", "경로 조회"),
    MAIN_MENU2("Q", "종료");

    private final String option;
    private final String menu;

    MainMenu(String option, String menu) {
        this.option = option;
        this.menu = menu;
    }

    public String getMenuMessage() {
        return String.format("%s. %s", option, menu);
    }

    public static MainMenu getMenu(String option) {
        return Arrays.stream(values())
                .filter(value -> value.option.equals(option))
                .findAny()
                .orElse(null);
    }
}
