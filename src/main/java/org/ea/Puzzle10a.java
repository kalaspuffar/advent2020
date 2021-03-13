package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle10a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle10a.txt"));

            int[] diff = new int[10];

            List<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                numbers.add(Integer.parseInt(line));
            }

            numbers.sort(Integer::compare);

            Arrays.fill(diff, 0);

            diff[numbers.get(0)]++;
            for (int i = 0; i < numbers.size() - 1; i++) {
                diff[numbers.get(i + 1) - numbers.get(i)]++;
            }
            diff[3]++;

            System.out.println(diff[1] * diff[3]);

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
