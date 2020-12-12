package org.ea;

import java.util.HashSet;
import java.util.Set;

public class CustomsAnswersUnique {
    private Set<String> allAnswers = null;

    public void addAnswers(String answers) {
        if (answers.isEmpty()) return;
        if (allAnswers == null) {
            allAnswers = new HashSet<>();
            for(String s : answers.split("")) {
                allAnswers.add(s);
            }
            return;
        }

        Set<String> newList = new HashSet<>();
        for(String s : answers.split("")) {
            if (allAnswers.contains(s)) {
                newList.add(s);
            }
        }
        allAnswers = newList;
    }

    public int getNumberOfAnswers() {
        return allAnswers.size();
    }
}
