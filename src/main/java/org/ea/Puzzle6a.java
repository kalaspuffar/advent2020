package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle6a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle6a.txt"));

            CustomsAnswersUnique p = new CustomsAnswersUnique();

            int validAnswers = 0;
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                if(line.isEmpty()) {
                    validAnswers += p.getNumberOfAnswers();
                    p = new CustomsAnswersUnique();
                }
                p.addAnswers(line);
            }

            validAnswers += p.getNumberOfAnswers();

            System.out.println(validAnswers);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }

}
