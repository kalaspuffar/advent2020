package org.ea;

public class Seating {
    int row = 0;
    int column = 0;

    public Seating(String s) {
        row += s.charAt(0) == 'B' ? 64 : 0;
        row += s.charAt(1) == 'B' ? 32 : 0;
        row += s.charAt(2) == 'B' ? 16 : 0;
        row += s.charAt(3) == 'B' ? 8 : 0;
        row += s.charAt(4) == 'B' ? 4 : 0;
        row += s.charAt(5) == 'B' ? 2 : 0;
        row += s.charAt(6) == 'B' ? 1 : 0;

        column += s.charAt(7) == 'R' ? 4 : 0;
        column += s.charAt(8) == 'R' ? 2 : 0;
        column += s.charAt(9) == 'R' ? 1 : 0;
    }

    public int getID() {
        return row * 8 + column;
    }
}
