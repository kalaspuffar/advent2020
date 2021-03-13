package org.ea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Puzzle9a {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle9a.txt"));

            List<String> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                numbers.add(line);
            }

            long[] buffer = new long[numbers.size()];
            int i = 0;
            for (String s : numbers) {
                buffer[i] = Long.parseLong(s);
                i++;
            }

            final int PREAMBLE = 25;

            for (int pos = PREAMBLE; pos < buffer.length; pos++) {
                boolean thereIsAValueThatSumsUpToOurCurrentValue = false;
                testloop:
                for (int val1pos = pos - PREAMBLE; val1pos < pos; val1pos++) {
                    for (int val2pos = pos - PREAMBLE; val2pos < pos; val2pos++) {
                        if (buffer[val1pos] == buffer[val2pos]) continue;
                        if (buffer[val1pos] + buffer[val2pos] == buffer[pos]) {
                            thereIsAValueThatSumsUpToOurCurrentValue = true;
                            break testloop;
                        }
                    }
                }
                if (!thereIsAValueThatSumsUpToOurCurrentValue) {
                    System.out.println(buffer[pos]);
                    break;
                }
            }

            final int VALUE_TO_FIND = 1038347917;

            for (int val1pos = 0; val1pos < buffer.length; val1pos++) {
                int accumilator = 0;
                for (int val2pos = val1pos; val2pos < buffer.length; val2pos++) {
                    accumilator += buffer[val2pos];
                    if (accumilator > VALUE_TO_FIND) break;
                    if (accumilator == VALUE_TO_FIND) {

                        long smallest = Long.MAX_VALUE;
                        long largest = 0;
                        for(int j = val1pos; j < val2pos + 1; j++) {
                            if(smallest > buffer[j]) smallest = buffer[j];
                            if(largest < buffer[j]) largest = buffer[j];
                        }

                        System.out.println(smallest + largest);
                        System.exit(0);
                    }
                }
            }





        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
