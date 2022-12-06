package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean isNotExistStation(List<String> stations) {
        return sections.stream().noneMatch(section -> section.getStations().containsAll(stations));
    }

    public static List<Integer> getTotalWeight(List<String> stations) {
        int totalDistance = 0;
        int totalTime = 0;
        for (int i = 0; i < stations.size() - 1; i++) {
            Section section = getSection(Arrays.asList(stations.get(i), stations.get(i + 1)));
            totalDistance += section.getDistance();
            totalTime += section.getTime();
        }

        return Arrays.asList(totalDistance, totalTime);
    }

    private static Section getSection(List<String> stations) {
        return sections.stream().filter(section -> section.getStations().containsAll(stations))
                .findAny().get();
    }

    public static void deleteAll() {
        sections.clear();
    }
}
