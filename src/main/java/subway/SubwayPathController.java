package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SubwayPathController {
    private final Scanner scanner;
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    SubwayPathController(Scanner scanner) {
        this.scanner = scanner;
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
    }

    public void startSearchSubwayPath() {
        boolean menuState = true;

        while (menuState) {
            menuState = selectMenuResult();
        }
    }

    private boolean selectMenuResult() {
        MainMenu mainMenu = validateMainMenu(selectMainMenu());
        if (mainMenu.equals(MainMenu.MAIN_MENU1)) {

        }

        return false;
    }

    private String selectMainMenu() {
        outputView.printMainMenu();
        return inputView.readSelectMenu(scanner);
    }

    private void selectPathMethod() {
        boolean menuState = true;

        while (menuState) {

        }
    }

    private boolean selectPathMenuResult() {
        PathMenu pathMenu = validatePathMenu(selectPathMenu());
        if (pathMenu.equals(PathMenu.PATH_MENU1)) {

        }
        if (pathMenu.equals(PathMenu.PATH_MENU2)) {

        }

        return false;
    }

    private String selectPathMenu() {
        outputView.printPathMenu();
        return inputView.readSelectMenu(scanner);
    }

    private MainMenu validateMainMenu(String selectMenu) {
        if (isEmpty(selectMenu)) {
            ExceptionMessage.INPUT_NONE.throwException();
        }

        MainMenu selectMainMenu = MainMenu.getMenu(selectMenu);
        if (selectMainMenu == null) {
            ExceptionMessage.INPUT_WRONG_MAIN_MENU.throwException();
        }

        return selectMainMenu;
    }

    private boolean isEmpty(String selectMenu) {
        return selectMenu.isEmpty();
    }

    private PathMenu validatePathMenu(String selectMenu) {
        if (isEmpty(selectMenu)) {
            ExceptionMessage.INPUT_NONE.throwException();
        }

        PathMenu selectPathMenu = PathMenu.getMenu(selectMenu);
        if (selectPathMenu == null) {
            ExceptionMessage.INPUT_WRONG_PATH_MENU.throwException();
        }

        return selectPathMenu;
    }
}
