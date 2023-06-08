package Exercises;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        returnArrayNumber();
        System.out.println();
        returnArrayString();
        System.out.println();
        oddNumers();
        System.out.println();
        secondLargestElement();
        System.out.println();
        differenceDates();
        System.out.println();
       // readFile();
       // System.out.println();
        regularExpressions();
        System.out.println();
        regexReplace();
    }

    public static void returnArrayNumber() {
        int[] arrayNumber = new int[]{1, 2, 3, 4, 5};
        System.out.println("Numbers Array");

        for(int i = 0; i < arrayNumber.length; ++i) {
            System.out.println(arrayNumber[i]);
        }

    }

    public static void returnArrayString() {
        String[] arrayString = new String[]{"Java", "JavaScript", "C", "C++"};
        System.out.println("Strings Array");

        for(int i = 0; i < arrayString.length; ++i) {
            System.out.print(arrayString[i]);
            if (i != arrayString.length - 1) {
                System.out.print(",");
            }
        }

    }

    public static void oddNumers() {
        int[] arrayNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Odd numbers");
        int[] var1 = arrayNumbers;
        int var2 = arrayNumbers.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int number = var1[var3];
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }

    }

    public static void secondLargestElement() {
        int[] arrayNumber = new int[]{1, 5, 7, 8, 2, 22};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        System.out.println("Second largest element");

        for(int i = 0; i < arrayNumber.length; ++i) {
            if (arrayNumber[i] > largest) {
                secondLargest = largest;
                largest = arrayNumber[i];
            } else if (arrayNumber[i] > secondLargest && arrayNumber[i] != largest) {
                secondLargest = arrayNumber[i];
            }
        }

        System.out.println("Second largest element is " + secondLargest);
    }

    public static void differenceDates() {
        LocalDate date1 = LocalDate.of(2019, 3, 7);
        LocalDate date2 = LocalDate.of(2023, 5, 26);
        Period period = Period.between(date1, date2);
        int dayDifference = period.getDays();
        int monthDifference = period.getMonths();
        int yearsDifferrence = period.getYears();
        System.out.println("Difference in days: " + dayDifference);
        System.out.println("Difference in months: " + monthDifference);
        System.out.println("Difference in years: " + yearsDifferrence);
    }

    public static void readFile() {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            String line = reader.readLine();
            StringBuilder reverseString = (new StringBuilder(line)).reverse();
            writer.write(reverseString.toString());
            System.out.println("String reversed and save!");
        } catch (IOException var6) {
            System.out.println("Error: " + String.valueOf(var6));
        }

    }

    public static void regularExpressions() {
        String input = "pq";
        String regex = "p[q]*";
        boolean isMatch = Pattern.matches(regex, input);
        System.out.println("Write a Java program that matches a string that has a p followed by zero or more q´s with regex");
        if (isMatch) {
            System.out.println("The string matches the pattern");
        } else {
            System.out.println("The string doesn't match the pattern");
        }

    }

    public static void regexReplace() {
        String input = "window[\"input\"] = function(\"a<3${<text to replace>}\");";
        // Escape regex special characters
        String textToReplace = "<text to replace>"; String regex = Pattern.quote(textToReplace);
        // Replace with an empty string
        String replacement = "";
        System.out.println(input);
        String result = input.replaceAll(regex, replacement);
        System.out.println(result);
    }
}
