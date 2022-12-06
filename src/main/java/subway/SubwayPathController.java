package subway;

import subway.domain.*;

import java.util.Arrays;
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
            addStationIfNotExist(station);
        }
    }

    private void addStationIfNotExist(String station) {
        if (StationRepository.isNotExistStation(station)) {
            StationRepository.addStation(new Station(station));
            findShortestPath.addVertex(station);
        }
    }

    private void initEdgeWeight(SubwayInformation subwayInformation) {
        for (int i = 0; i < subwayInformation.getTimes().size(); i++) {
            String station1 = subwayInformation.getStations().get(i);
            String station2 = subwayInformation.getStations().get(i + 1);
            int time = subwayInformation.getTimes().get(i);
            int distance = subwayInformation.getDistances().get(i);

            findShortestPath.addEdgeWeight(station1, station2, distance, time);
            SectionRepository.addSection(new Section(Arrays.asList(station1, station2), time, distance));
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
            selectPathMethod();
            return true;
        }

        return false;
    }

    private String selectMainMenu() {
        outputView.printMainMenu();
        return inputView.readSelectMenu(scanner);
    }

    private void selectPathMethod() {
        boolean menuState = false;

        while (!menuState) {
            menuState = selectPathMenuResult();
        }
    }

    private boolean selectPathMenuResult() {
        PathMenu pathMenu = validatePathMenu(selectPathMenu());
        if (pathMenu.equals(PathMenu.PATH_MENU3)) {
            return true;
        }

        List<String> paths = selectFindStation(pathMenu);
        List<Integer> weights = SectionRepository.getTotalWeight(paths);
        outputView.printPathResult(paths, weights);
        return false;
    }

    private List<String> selectFindStation(PathMenu pathMenu) {
        String startStation = validateStation(inputView.readStartStation(scanner));
        String arrivalStation = validateStation(inputView.readArrivalStation(scanner));
        return getResultPerMenu(pathMenu, startStation, arrivalStation);
    }

    private String validateStation(String station) {
        if (isEmpty(station)) {
            ExceptionMessage.INPUT_NONE.throwException();
        }
        if (StationRepository.isNotExistStation(station)) {
            ExceptionMessage.INPUT_NOT_EXIST_STATION.throwException();
        }

        return station;
    }

    private List<String> getResultPerMenu(PathMenu pathMenu, String startStation, String arrivalStation) {
        if (pathMenu.equals(PathMenu.PATH_MENU1)) {
            return findShortestPath.getShortestPathByDistance(startStation, arrivalStation);
        }
        if (pathMenu.equals(PathMenu.PATH_MENU2)) {
            return findShortestPath.getShortestPathByTime(startStation, arrivalStation);
        }

        return null;
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
