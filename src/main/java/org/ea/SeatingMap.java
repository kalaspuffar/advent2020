package org.ea;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeatingMap {
    private List<String> map = new ArrayList<>();

    public void addLine(String s) {
        map.add(s);
    }

    private int checkAdjacentRow(String row, int x, boolean sameRow) {
        int numOfAdjacent = 0;
        if(x > 0) {
            numOfAdjacent += row.charAt(x - 1) == '#' ? 1 : 0;
        }
        if(!sameRow) {
            numOfAdjacent += row.charAt(x) == '#' ? 1 : 0;
        }
        if(x + 1 < row.length()) {
            numOfAdjacent += row.charAt(x + 1) == '#' ? 1 : 0;
        }
        return numOfAdjacent;
    }

    public int getNumberOfAdjacent(int x, int y) {
        int numOfAdjacent = 0;
        if(y > 0) {
            numOfAdjacent += checkAdjacentRow(map.get(y - 1), x, false);
        }
        numOfAdjacent += checkAdjacentRow(map.get(y), x, true);
        if(y + 1 < map.size()) {
            numOfAdjacent += checkAdjacentRow(map.get(y + 1), x, false);
        }
        return numOfAdjacent;
    }

    private int FLOOR = -1;
    private int OUTSIZE_OF_BOARD = -2;

    private int checkDirection(int x, int y, int xadd, int yadd) {
        if (y + yadd < 0) return OUTSIZE_OF_BOARD;
        if (y + yadd > map.size() - 1) return OUTSIZE_OF_BOARD;
        String row = map.get(y + yadd);
        if (x + xadd < 0) return OUTSIZE_OF_BOARD;
        if (x + xadd > row.length() - 1) return OUTSIZE_OF_BOARD;
        switch (row.charAt(x + xadd)) {
            case '#':
                return 1;
            case 'L':
                return 0;
            default:
                return FLOOR;
        }
    }

    public int getDirectionCount(int x, int y, int xadd, int yadd) {
        int countAdjacent = 0;

        int dirCheck = FLOOR;
        int i = 1;
        while(dirCheck == FLOOR) {
            dirCheck = checkDirection(x, y, i * xadd, i * yadd);
            i++;
        }
        if(dirCheck != OUTSIZE_OF_BOARD) {
            countAdjacent += dirCheck;
        }

        return countAdjacent;
    }

    public int getStarAdjacent(int x, int y) {
        int countAdjacent = 0;
        countAdjacent += getDirectionCount(x, y, 1, 0);
        countAdjacent += getDirectionCount(x, y, 0, 1);
        countAdjacent += getDirectionCount(x, y, 1, 1);

        countAdjacent += getDirectionCount(x, y, -1, 0);
        countAdjacent += getDirectionCount(x, y, 0, -1);
        countAdjacent += getDirectionCount(x, y, -1, -1);

        countAdjacent += getDirectionCount(x, y, 1, -1);
        countAdjacent += getDirectionCount(x, y, -1, 1);
        return countAdjacent;
    }

    public int getMaxX() {
        return map.get(0).length();
    }

    public int getMaxY() {
        return map.size();
    }

    public char getCharacter(int x, int y) {
        return map.get(y).charAt(x);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SeatingMap that = (SeatingMap) o;

        for(int i = 0; i < that.map.size(); i++) {
            if (!that.map.get(i).equals(map.get(i))) {
                return false;
            }
        }
        return true;
    }

    private int occupiedLine(String s) {
        int occupied = 0;
        for(char c : s.toCharArray()) {
            occupied += c == '#' ? 1 : 0;
        }
        return occupied;
    }

    public int countOccupied() {
        int occupied = 0;
        for (String s : map) {
            occupied += occupiedLine(s);
        }
        return occupied;
    }
}
