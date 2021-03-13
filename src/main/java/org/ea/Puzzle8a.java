package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Puzzle8a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle8a.txt"));

            Computer computer = new Computer();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                computer.addInstruction(line);
            }

            Set<Integer> visitedInstructions = new HashSet<>();

            for (int i=0; i<200; i++) {
                computer.reset();
                computer.setCurrentOpToTest(i);
                int currentInstruction = computer.getProcessPointer();
                visitedInstructions.clear();
                while (!visitedInstructions.contains(currentInstruction)) {
                    visitedInstructions.add(currentInstruction);
                    computer.runInstruction();
                    currentInstruction = computer.getProcessPointer();
                }
                System.out.println("Looped: " + computer.getAccumilator());
            }

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
