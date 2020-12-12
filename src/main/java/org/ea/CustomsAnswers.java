package org.ea;

import java.util.HashSet;
import java.util.Set;

public class CustomsAnswers {
    private Set<String> allAnswers = new HashSet<>();

    public void addAnswers(String answers) {
        if (answers.isEmpty()) return;
        for(String s : answers.split("")) {
            allAnswers.add(s);
        }
    }

    public int getNumberOfAnswers() {
        return allAnswers.size();
    }
}
