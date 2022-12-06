package subway;

import java.util.Arrays;
import java.util.List;

public enum SubwayInformation {
    LINE1("2호선", Arrays.asList("교대역", "강남역", "역삼역"), Arrays.asList(2, 2), Arrays.asList(3, 3)),
    LINE2("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"), Arrays.asList(3, 6, 1),
            Arrays.asList(2, 5, 1)),
    LINE3("3호선", Arrays.asList("강남역", "양재역", "양재시민의숲역"), Arrays.asList(2, 10), Arrays.asList(8, 3));

    private final String line;
    private final List<String> stations;
    private final List<Integer> distances;
    private final List<Integer> times;

    SubwayInformation(String line, List<String> stations, List<Integer> distances, List<Integer> times) {
        this.line = line;
        this.stations = stations;
        this.distances = distances;
        this.times = times;
    }

    public String getLine() {
        return line;
    }

    public List<String> getStations() {
        return stations;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public List<Integer> getTimes() {
        return times;
    }
}
