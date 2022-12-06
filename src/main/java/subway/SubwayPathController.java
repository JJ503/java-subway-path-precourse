package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SubwayPathController {
    private final Scanner scanner;
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    SubwayPathController(Scanner scanner) {
        this.scanner = scanner;
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
    }


}
