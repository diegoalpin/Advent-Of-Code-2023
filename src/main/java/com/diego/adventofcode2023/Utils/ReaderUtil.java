package com.diego.adventofcode2023.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;

public class ReaderUtil {

    public static BufferedReader readInput(String filename) {
        File input;
        BufferedReader br = null;
        try {
            input = new ClassPathResource(filename).getFile();
            FileInputStream fis = new FileInputStream(input);
            br = new BufferedReader(new InputStreamReader(fis));
            return br;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }
}
