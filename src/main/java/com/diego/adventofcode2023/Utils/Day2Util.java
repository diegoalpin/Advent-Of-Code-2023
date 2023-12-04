package com.diego.adventofcode2023.Utils;

import java.util.Arrays;
import java.util.List;

public class Day2Util {

    public static Integer parseSentence(String line) {
        
        final Integer redLimit = 12;
        final Integer greenLimit = 13;
        final Integer blueLimit = 14;
        Integer gameId = Integer.valueOf((line.trim().split(":")[0]).trim().split(" ")[1]);
        List<String> sets = Arrays.asList((line.split(":")[1]).split(";"));
        
        Integer red = 0;
        Integer green = 0;
        Integer blue = 0;

        for(String set: sets){
            set.trim();
            List<String> cubes = Arrays.asList(set.split(","));//["14 green"," 8 blue"," 9 red"]
            for(String cube: cubes){
                cube = cube.trim();
                String color = cube.split(" ")[1];
                Integer amount = Integer.valueOf(cube.split(" ")[0]);

                switch(color){
                    case "red":
                    red = amount;
                    break;

                    case "green":
                    green = amount;
                    break;

                    case "blue":
                    blue = amount;
                    break;
                    
                    default:
                    System.out.println("color error");
                    break;
                }

                // System.out.println(color.trim());
            }
            
            System.out.println(String.format("red is %d, green is %d, blue is %d", red, green,blue));
            if (red > redLimit || blue > blueLimit || green > greenLimit){
                    System.out.println(String.format("FAIL becos red is %d >12, green is %d >13, blue is %d >14", red, green,blue));
                    System.out.println("game Id "+gameId+" impossible");
                    return 0;
                }
        }
        
        System.out.println("game Id returned: "+gameId);
        return gameId;
    }

    public static int parseToPower(String line) {

        Integer gameId = Integer.valueOf((line.trim().split(":")[0]).trim().split(" ")[1]);
        List<String> sets = Arrays.asList((line.split(":")[1]).split(";"));
        Integer red = 0;
        Integer green = 0;
        Integer blue = 0;

        for(String set: sets){
            set.trim();
            List<String> cubes = Arrays.asList(set.split(","));//["14 green"," 8 blue"," 9 red"]
            for(String cube: cubes){
                cube = cube.trim();
                String color = cube.split(" ")[1];
                Integer amount = Integer.valueOf(cube.split(" ")[0]);

                switch(color){
                    case "red":
                    red = Math.max(amount, red);
                    break;

                    case "green":
                    green = Math.max(amount, green);
                    break;

                    case "blue":
                    blue = Math.max(amount, blue);
                    break;
                    
                    default:
                    System.out.println("color error");
                    break;
                }
            }
        }
        return red*green*blue;
    }

}
