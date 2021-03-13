package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Puzzle11a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle11a.txt"));

            SeatingMap seatingMap = new SeatingMap();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                seatingMap.addLine(line);
            }

            SeatingMap newMap = null;
            do {
                if(newMap != null) {
                    seatingMap = newMap;
                }
                newMap = new SeatingMap();
                for (int y = 0; y < seatingMap.getMaxY(); y++) {
                    line = "";
                    for (int x = 0; x < seatingMap.getMaxX(); x++) {
                        line += handleStarSeating(seatingMap, x, y);
                    }
                    newMap.addLine(line);
                }
            } while (!seatingMap.equals(newMap));

            System.out.println("Number of occupied seats " + seatingMap.countOccupied());
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }

    private static String handleSeating(SeatingMap seatingMap, int x, int y) {
        switch (seatingMap.getCharacter(x, y)) {
            case 'L':
                return seatingMap.getNumberOfAdjacent(x, y) == 0 ? "#" : "L";
            case '#':
                return seatingMap.getNumberOfAdjacent(x, y) > 3 ? "L" : "#";
            default:
                return ".";
        }
    }

    private static String handleStarSeating(SeatingMap seatingMap, int x, int y) {
        switch (seatingMap.getCharacter(x, y)) {
            case 'L':
                return seatingMap.getStarAdjacent(x, y) == 0 ? "#" : "L";
            case '#':
                return seatingMap.getStarAdjacent(x, y) > 4 ? "L" : "#";
            default:
                return ".";
        }
    }
}
