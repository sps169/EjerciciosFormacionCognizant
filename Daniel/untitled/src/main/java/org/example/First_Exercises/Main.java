package org.example.First_Exercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        exercise1(); // Done
//        exercise2(); // Done
//        exercise3(); // Done
//        exercise4(); // Done
        exercise5();
//        exercise6(); // Done
        exercise7(); // Done
    }

    private static void exercise1() {
        // Print elements of an array
        // Each element in one line and each element separated by comas
        int[] array = {1, 2, 3, 4, 5};
        for (int number : array) {
            System.out.println(number);
        }
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += i < array.length-1 ? array[i] + ", " : array[i];
        }
        System.out.println(output);
    }

    private static void exercise2() {
        // Print even and ood numbers from an array
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Odd numbers: ");
        for(int n : array){
            if (n % 2 == 1) System.out.println(n);
        }
        System.out.println("Even numbers: ");
        for(int n : array){
            if (n % 2 == 0) System.out.println(n);
        }
    }

    private static void exercise3() {
        // Find the second largest number in a numeric array
        int[] array = {3, 5, 1, 4, 2};
        System.out.print("The second largest number of the array " + Arrays.toString(array) + " is ");
        Arrays.sort(array);
        System.out.println(array[array.length-2]);
    }

    private static void exercise4() {
        // Find the difference between 2 dates
        //            "2023-05-24"   0 years 1 month 1 day
        String first = "2022-04-27", second = "" + java.time.LocalDate.now(), time = "";
        String[] date1 = first.split("-"), date2 = second.split("-");
        // [0] Year | [1] Month | [2] Day

        double years, months, days = 0,
            y1 = Integer.valueOf(date1[0]), y2 = Integer.valueOf(date2[0]),
            m1 = Integer.valueOf(date1[1]), m2 = Integer.valueOf(date2[1]),
            d1 = Integer.valueOf(date1[2]), d2 = Integer.valueOf(date2[2]);
        days += (y1 - y2) * 365 + (m1 - m2) * 30 + d1-d2;
        time = days > 0 ? "past" : "future";

        System.out.println("WARING! FOR THIS EXERCISE YEARS ARE ASUMED TO BE ALL 365 DAYS AND MONTHS ALL 30 DAYS");
        System.out.printf("The date %s is %.2f days in the future\n", first, Math.abs(days));
        System.out.printf("The date %s is %.2f months in the future\n", first, Math.abs(days / 30));
        System.out.printf("The date %s is %.2f years in the future\n", first, Math.abs(days / 10950));
        days = Math.abs(days);
        years = Math.floor(days / 365);
        days %= 365;
        months = Math.floor(days / 30);
        days %= 30;
        System.out.println("The date " + first + " is " + years + " year(s), " +
                        months + " month(s) and " + days + " day(s) in the " + time);
    }

    private static void exercise5() {
        // Read a string from a file, reverse the string and save it in another file
    }

    private static void exercise6() {
        // Regexp matching q and 0 or more p
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce string to test: ");
        String result, test = sc.nextLine();

        result = test.matches("^qp*$") ? "Match found, true comparisson!" : "Match not found, get outa here!";
        System.out.println(result);
    }

    private static void exercise7() {
        // Regexp to replace text from the string:
        // window["input"]=function("a<3${<text to replace}");"
        String original = "=window[\"input\"]=function(\"a<3${<text to replace}\");\"";
        System.out.println("Original string: " + original);
        System.out.println("Replaced string: " + original.replace("text to replace", "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"));
    }
}


