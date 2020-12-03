package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle1a {

    public static void findValue(int[] puzzle) {
        for (int i=0; i<puzzle.length; i++) {
            for (int j=i + 1; j<puzzle.length; j++) {
                for (int k=j + 1; k<puzzle.length; k++) {
                    if (puzzle[i] + puzzle[j] + puzzle[k] == 2020) {
                        System.out.println(puzzle[i] * puzzle[j] * puzzle[k]);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //        int[] puzzle = new int[] {1721,979,366,299,675,1456};
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle1a.txt"));

            List<String> inputs = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null) {
                inputs.add(line);
            }

            int[] puzzle = new int[inputs.size()];

            int i = 0;
            for (String s : inputs) {
                puzzle[i] = Integer.valueOf(s);
                i++;
            }

            System.out.println(puzzle.length);
            System.out.println(Arrays.toString(puzzle));

            findValue(puzzle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
