package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle3a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle3a.txt"));

            List<String> inputs = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                inputs.add(line);
            }

            Forest forest = new Forest(inputs);

            int trees = 0;
            do {
                trees += forest.hasTree() ? 1 : 0;
            } while (forest.move(3, 1));
            System.out.println(trees);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
