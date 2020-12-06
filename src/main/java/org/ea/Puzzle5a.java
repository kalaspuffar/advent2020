package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle5a {
    public static void main(String[] args) {

        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle5a.txt"));

            int[] seats = new int[2000];

            int largestID = 0;
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                Seating seating = new Seating(line);
                seats[seating.getID()] = 1;
                if (largestID < seating.getID()) {
                    largestID = seating.getID();
                }
            }

            for (int i = 54; i < 878; i++) {
                if (seats[i] == 0) {
                    System.out.println(i);
                }
            }

            System.out.println(largestID);

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
