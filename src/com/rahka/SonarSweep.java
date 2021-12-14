package com.rahka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SonarSweep {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("E:\\Drive\\Personal\\Creativity\\Programming projects\\AOC input files\\sonar sweep input.txt");
        Scanner sc = new Scanner(file);

        int increase = 0;
        int decrease = 0;
        int sumIncrease = 0;
        int sum = 0;
        int previousSum = 0;

        LinkedList<Integer> depthList = new LinkedList<>();

        while (sc.hasNextLine()) {

            if (depthList.size() < 3) {
                depthList.add(Integer.parseInt(sc.nextLine()));

                for (int depth : depthList) {
                    sum += depth;
                }

                if (depthList.size() == 3)
                    System.out.println(sum + " (N/A - no previous sum)");

                previousSum = sum;
                sum = 0;

            } else {

                depthList.add(Integer.parseInt(sc.nextLine()));
                depthList.remove();

                for (int depth : depthList) {
                    sum += depth;
                }


                if (sum > previousSum) {
                    increase++;
                    sumIncrease += (sum - previousSum);
                    System.out.println(sum + " (increase)");
                } else if (sum < previousSum){
                    decrease++;
                    System.out.println(sum + " (decrease)");
                } else {
                    System.out.println(sum + " (no change)");
                }

                previousSum = sum;
                sum = 0;
            }
        }

        System.out.println("Number of increase in depth: " + increase);
        System.out.println("Number of decrease in depth: " + decrease);
        System.out.println("Total increase in depth: " + sumIncrease);

    }
}


