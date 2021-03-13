package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;

public class Puzzle10b {

    public static Set<int[]> nextList(
            Set<int[]> lists,
            List<Integer> numbers,
            int current
    ) {
        Set<int[]> newLists = new HashSet<>();
        for (int[] list : lists) {
            int[] newList = new int[list.length + 1];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            if (
                numbers.get(current) - newList[list.length - 1] < 4 &&
                numbers.get(current) - newList[list.length - 1] > 0
            ) {
                newList[list.length] = numbers.get(current);
                newLists.add(Arrays.copyOf(newList, newList.length));
            }
            if (
                numbers.get(current + 1) - newList[list.length - 1] < 4 &&
                numbers.get(current + 1) - newList[list.length - 1] > 0
            ) {
                newList[list.length] = numbers.get(current + 1);
                newLists.add(Arrays.copyOf(newList, newList.length));
            }
            if (
                numbers.get(current + 2) - newList[list.length - 1] < 4 &&
                numbers.get(current + 2) - newList[list.length - 1] > 0
            ) {
                newList[list.length] = numbers.get(current + 2);
                newLists.add(Arrays.copyOf(newList, newList.length));
            }
        }
        return newLists;
    }

    public static int howManyPerValue(List<Integer> list, int val) {
        int numberOfWays = 0;
        for(Integer i : list) {
            numberOfWays += (i == val + 1) ? 1 : 0;
            numberOfWays += (i == val + 2) ? 1 : 0;
            numberOfWays += (i == val + 3) ? 1 : 0;
        }
        return numberOfWays == 0 ? 1 : numberOfWays;
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle10test.txt"));

            List<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                numbers.add(Integer.parseInt(line));
            }

            numbers.sort(Integer::compare);


            Set<int[]> lists = new HashSet<>();
            lists.add(new int[] {0});
            for (int i = 0; i < numbers.size() - 2; i++) {
                lists = nextList(lists, numbers, i);
            }

            System.out.println(lists.size());

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
