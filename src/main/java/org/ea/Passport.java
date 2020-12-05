package org.ea;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Passport {
    Map<String, String> requiredFields = new HashMap();

    public Passport() {
        requiredFields.put("byr", "(19[2-9][0-9])|(200[0-2])");
        requiredFields.put("iyr", "(201[0-9])|(2020)");
        requiredFields.put("eyr", "(202[0-9])|(2030)");
        requiredFields.put("hgt", "(1[5-8][0-9]cm)|(19[0-3]cm)|(59in)|(6[0-9]in)|(7[0-6]in)");
        requiredFields.put("hcl", "#[0-9a-f]{6}");
        requiredFields.put("ecl", "amb|blu|brn|gry|grn|hzl|oth");
        requiredFields.put("pid", "\\d{9}");
    }

    /*
    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
     */

    public void addFields(String line) {
        String[] sArr = line.split(" ");
        for (String s : sArr) {
            if(!s.contains(":")) continue;
            if(!requiredFields.containsKey(s.split(":")[0])) continue;

            Pattern p = Pattern.compile(requiredFields.get(s.split(":")[0]));
            if (p.matcher(s.split(":")[1]).matches()) {
                requiredFields.remove(s.split(":")[0]);
            }
        }
    }

    public boolean validPassport() {
        return requiredFields.isEmpty();
    }

}