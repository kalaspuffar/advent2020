package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle2a {

    public static void main(String[] args) {

        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle2a.txt"));

            List<String> inputs = new ArrayList<>();

            int validPassword = 0;
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                if (new Password(line).isValidToboggan()) {
                    validPassword++;
                }
            }

            System.out.println(validPassword);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}

