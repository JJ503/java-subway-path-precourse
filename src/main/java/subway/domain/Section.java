package subway.domain;

import java.util.List;

public class Section {
    private List<String> stations;
    private int time;
    private int distance;

    public Section(List<String> stations, int time, int distance) {
        this.stations = stations;
        this.time = time;
        this.distance = distance;
    }

    public List<String> getStations() {
        return stations;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
