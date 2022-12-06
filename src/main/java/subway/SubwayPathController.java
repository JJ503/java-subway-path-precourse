package subway;

import subway.domain.Line;
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
            selectMenu();
        }
    }

    private String selectMenu() {
        outputView.printMainMenu();
        return inputView.readSelectMenu(scanner);
    }
}
