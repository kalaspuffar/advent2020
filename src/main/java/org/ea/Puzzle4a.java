package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Puzzle4a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle4a.txt"));

            List<Passport> passList = new ArrayList<>();

            Passport p = new Passport();

            int validPassport = 0;
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                if(line.isEmpty()) {
                    validPassport += p.validPassport() ? 1 : 0;
                    p = new Passport();
                }
                p.addFields(line);
            }

            validPassport += p.validPassport() ? 1 : 0;

            System.out.println(validPassport);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
