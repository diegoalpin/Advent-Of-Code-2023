package com.diego.adventofcode2023.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.diego.adventofcode2023.Utils.Day1Util;
import com.diego.adventofcode2023.Utils.Day2Util;
import com.diego.adventofcode2023.Utils.ReaderUtil;

@Controller
public class Week1Controller1 {
    
    @GetMapping(path = "api/day1")
    public ResponseEntity<String> getSolutionDay1(){
        
        FileInputStream fis;
        
        Integer result=0;
        try {
            File inputDay1 = new ClassPathResource("input-day1.txt").getFile();
            fis = new FileInputStream(inputDay1);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                String parsedLine = Day1Util.parseWordToNum(line);
                result += Day1Util.getDigits(parsedLine);
                System.out.println("line is: "+parsedLine+" addition to " +Day1Util.getDigits(parsedLine)+ " result is :"+result);
                // break;
            }
        } 
        catch(IOException exception){
            exception.printStackTrace();
        }
      
        
        return ResponseEntity.ok().body(result.toString());
    }

    @GetMapping(path="api/day2")
    public ResponseEntity<Integer> getSolutionDay2() throws IOException{
        BufferedReader br = ReaderUtil.readInput("input-day2.txt");
        String line;
        int result=0;
        while((line=br.readLine())!= null){
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("line is "+ line);
            // result += Day2Util.parseSentence(line); //part 1
            result += Day2Util.parseToPower(line); //part 2
            // break;
        }
        
        return ResponseEntity.ok().body(result);
    }
}
