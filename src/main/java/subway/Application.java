package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayPathController subwayPathController = new SubwayPathController(scanner);
        subwayPathController.startSearchSubwayPath();
    }
}
