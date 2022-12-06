package subway;

import subway.domain.*;

import java.util.List;
import java.util.Scanner;

public class SubwayPathController {
    private final Scanner scanner;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private FindShortestPath findShortestPath = new FindShortestPath();

    SubwayPathController(Scanner scanner) {
        this.scanner = scanner;
        initSubwayInformation();
    }

    private void initSubwayInformation() {
        for (SubwayInformation subwayInformation : SubwayInformation.values()) {
            LineRepository.addLine(new Line(subwayInformation.getLine()));
            initSubwayStations(subwayInformation.getStations());
            initEdgeWeight(subwayInformation);
        }
    }

    private void initSubwayStations(List<String> stations) {
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
            findShortestPath.addVertex(station);
        }
    }

    private void initEdgeWeight(SubwayInformation subwayInformation) {
        for (int i = 0; i < subwayInformation.getTimes().size(); i++) {
            findShortestPath.addTimeEdgeWeight(subwayInformation.getStations().get(i),
                    subwayInformation.getStations().get(i + 1), subwayInformation.getTimes().get(i));
            findShortestPath.addDistanceEdgeWeight(subwayInformation.getStations().get(i),
                    subwayInformation.getStations().get(i + 1), subwayInformation.getDistances().get(i));
        }
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
