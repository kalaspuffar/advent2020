package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle3a {

    public static int getTreesForSlope(Forest forest, int x, int y) {
        forest.reset();
        int trees = 0;
        do {
            trees += forest.hasTree() ? 1 : 0;
        } while (forest.move(x, y));

        System.out.println(trees);

        return trees;
    }

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

            long multiplyTrees = 1;

            multiplyTrees *= getTreesForSlope(forest, 1, 1);
            multiplyTrees *= getTreesForSlope(forest, 3, 1);
            multiplyTrees *= getTreesForSlope(forest, 5, 1);
            multiplyTrees *= getTreesForSlope(forest, 7, 1);
            multiplyTrees *= getTreesForSlope(forest, 1, 2);

            System.out.println(multiplyTrees);
            /**
             Right 1, down 1.
             Right 3, down 1. (This is the slope you already checked.)
             Right 5, down 1.
             Right 7, down 1.
             Right 1, down 2.
             */

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
