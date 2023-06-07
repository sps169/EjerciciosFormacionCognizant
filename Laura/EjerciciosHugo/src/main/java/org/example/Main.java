package org.example;

import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
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
        readFile();
        System.out.println();
        regularExpressions();
        System.out.println();
        regexReplace();
    }

    public static void returnArrayNumber(){
       int[] arrayNumber = {1,2,3,4,5};
        System.out.println("Numbers Array");
       for (int i = 0;i< arrayNumber.length;i++){
           System.out.println(arrayNumber[i]);
       }
    }

    public static void returnArrayString(){
        String[] arrayString = {"Java","JavaScript","C","C++"};
        System.out.println("Strings Array");
        for (int i = 0; i < arrayString.length;i++){
            System.out.print(arrayString[i]);
            if (i != arrayString.length - 1){
                System.out.print(",");
            }
        }
    }

    public static void oddNumers(){
        int[] arrayNumbers = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Odd numbers");
        for (int number : arrayNumbers){
            if (number % 2 != 0){
                System.out.println(number);
            }
        }
    }
    public static void secondLargestElement(){
        int[] arrayNumber = {1,5,7,8,2,22};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        System.out.println("Second largest element");
        for (int i = 0; i < arrayNumber.length; i++){
            if (arrayNumber[i] > largest){
                secondLargest = largest;
                largest = arrayNumber[i];
            }
            else if (arrayNumber[i] > secondLargest && arrayNumber[i] != largest){
                secondLargest = arrayNumber[i];
            }
        }
        System.out.println("Second largest element is " + secondLargest);
    }
    public static void differenceDates(){
        LocalDate date1 = LocalDate.of(2019,3,7);
        LocalDate date2 = LocalDate.of(2023,5,26);

        //Calculate the difference between the 2 dates
        Period period = Period.between(date1,date2);

        //Choose the report type (days, months, years)
        int dayDifference = period.getDays();
        int monthDifference = period.getMonths();
        int yearsDifferrence = period.getYears();

        System.out.println("Difference in days: " + dayDifference);
        System.out.println("Difference in months: " + monthDifference);
        System.out.println("Difference in years: " + yearsDifferrence);
    }

    public static void readFile(){
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            //Read the string from the input file
            String line = reader.readLine();

            //Reverse the string
            StringBuilder reverseString = new StringBuilder(line).reverse();

            //Save the reversed string in the output file
            writer.write(reverseString.toString());

            System.out.println("String reversed and save!");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public static void regularExpressions(){
        String input ="pq";
        String regex = "p[q]*";
        boolean isMatch = Pattern.matches(regex,input);

        if (isMatch){
            System.out.println("The string matches the pattern");
        }
        else{
            System.out.println("The string doesn't match the pattern");
        }
    }
    public static void regexReplace(){
        String input = "window[\"input\"] = function(\"a<3${<text to replace}\");";
        String regex = "<text to replace>"; String replacement = "replacement text";
        String result = input.replaceAll(regex, replacement);

        System.out.println("Original string: " + input);
        System.out.println("Modified string: " + result);
    }
}