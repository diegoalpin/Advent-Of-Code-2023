package com.diego.adventofcode2023.Utils;

import java.util.HashMap;
import java.util.Map;

public class Day1Util {

    public static Integer getDigits(String line) {
        int left = 0;
        int right = line.length();

        int firstDigit = 10;
        int secondDigit = 10;
        for(int i = 0; i<line.length();i++){
            
            if(Character.isDigit(line.charAt(i)) && firstDigit>9){
                firstDigit = Character.getNumericValue(line.charAt(i));
                // System.out.println("char is "+line.charAt(i)+"  first digit changed: "+firstDigit);
            }
            if(Character.isDigit(line.charAt(right-i-1))&&secondDigit>9){
                secondDigit = Character.getNumericValue(line.charAt(right-i-1));
                // System.out.println("char is "+line.charAt(right-i-1)+"  second digit changed: "+secondDigit);
            }
            if(firstDigit<10 && secondDigit<10){
                return firstDigit*10 + secondDigit;
            }
            // System.out.println("i is "+i+" digit is " +firstDigit +" - "+secondDigit);
        }
        return 0;
    }

    public static String parseWordToNum(String line) {
        Map<String,String> stringToNum = new HashMap<>();
        stringToNum.put("one", "1one");
        
        String newLine=line;
        newLine = newLine.replaceAll("one", "on1e")
        .replaceAll("two", "tw2o")
        .replaceAll("three", "thr3ee")
        .replaceAll("four", "fo4ur")
        .replaceAll("five", "fi5ve")
        .replaceAll("six", "si6x")
        .replaceAll("seven", "sev7en")
        .replaceAll("eight", "eig8ht")
        .replaceAll("nine", "ni9ne");

        return newLine;
    }


}
