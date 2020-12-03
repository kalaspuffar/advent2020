package org.ea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public int min;
    public int max;
    public String character;
    public String password;

    public Password(String s) {
        Matcher m = Pattern.compile("(\\d+)-(\\d+) (\\S): (\\S+)").matcher(s);

        if (m.find()) {
            min = Integer.valueOf(m.group(1));
            max = Integer.valueOf(m.group(2));
            character = m.group(3);
            password = m.group(4);
        }
    }

    public boolean isValidSled() {
        Matcher m = Pattern.compile(character).matcher(password);

        int matches = 0;
        while(m.find()) matches++;
        return min <= matches && max >= matches;
    }

    public boolean isValidToboggan() {
        if (password.length() < min || (password.length() < max)) {
            return false;
        }
        String first;
        String second;

        first = new String(new char[] { password.charAt(min - 1) });
        second = new String(new char[] { password.charAt(max - 1) });

        return character.equals(first) ^ character.equals(second);
    }
}

