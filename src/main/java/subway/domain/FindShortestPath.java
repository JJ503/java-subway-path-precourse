package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class FindShortestPath {
    WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addVertex(String station) {
        distanceGraph.addVertex(station);
        timeGraph.addVertex(station);
    }

    public void addEdgeWeight(String station1, String station2, int distanceWeight, int timeWeight) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1, station2), distanceWeight);
        timeGraph.setEdgeWeight(timeGraph.addEdge(station1, station2), timeWeight);
    }

    public List<String> getShortestPathByDistance(String station1, String station2) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(station1, station2).getVertexList();
    }

    public List<String> getShortestPathByTime(String station1, String station2) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(station1, station2).getVertexList();
    }
}
