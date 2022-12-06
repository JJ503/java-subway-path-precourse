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
        while (true) {
            MainMenu menu = validateMainMenu(selectMenu());
            System.out.println(menu);
        }
    }

    private String selectMenu() {
        outputView.printMainMenu();
        return inputView.readSelectMenu(scanner);
    }

    private MainMenu validateMainMenu(String selectMenu) {
        if (isEmpty(selectMenu)) {
            ExceptionMessage.INPUT_NONE.throwException();
        }

        MainMenu selectMainMenu = isExistMenu(selectMenu);
        if (selectMainMenu == null) {
            ExceptionMessage.INPUT_WRONG_MAIN_MENU.throwException();
        }

        return selectMainMenu;
    }

    private boolean isEmpty(String selectMenu) {
        return selectMenu.isEmpty();
    }

    private MainMenu isExistMenu(String selectMenu) {
        return MainMenu.getMenu(selectMenu);
    }
}
