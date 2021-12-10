package com.rahka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SonarSweep {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("E:\\Drive\\Personal\\Creativity\\Programming projects\\AOC input files\\sonar sweep input.txt");
        Scanner sc = new Scanner(file);

        int previousDepth = Integer.parseInt(sc.nextLine());

        System.out.println(previousDepth + " (N/A - no previous measurement)");
        int increase = 0;
        int depth = 0;

        while (sc.hasNextLine()) {
            depth = Integer.parseInt(sc.nextLine());
            if (depth > previousDepth) {
                increase++;
                System.out.println(depth + " (increased)");
            } else if (depth < previousDepth) {
                System.out.println(depth + " (decreased)");
            } else {
                System.out.println(depth + " (no change)");
            }
            previousDepth = depth;
        }

        System.out.print("Total number of an increase in measurement: " + increase);
    }
}

