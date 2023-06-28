import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Date;

public class MasterClassJavaExercises {

    public void run() {
        printEjBanner(1);
        ej1PrintArray(new Integer[]{1, 2, 3}, 1);
        ej1PrintArray(new Integer[]{1, 2, 3}, 2);
        printEjBanner(2);
        ej2PrintArray(new int[]{1, 2, 3});
        printEjBanner(3);
        ej3FindSecondLargestNumber(new int[]{1, 2, 3, 4, 5, 6, 7});
        ej3FindSecondLargestNumber(new int[]{-1, -2, -3, -4, -5, -6, -7});
        printEjBanner(4);
        ej4FindDifferenceBetweenDates(Date.from(Instant.now()), Date.from(Instant.now().minusMillis(10010001000L)), ChronoUnit.DAYS);
        ej4FindDifferenceBetweenDates(Date.from(Instant.now()), Date.from(Instant.now().minusMillis(10010000000001000L)), ChronoUnit.MILLIS);
        printEjBanner(5);
        ej5ReverseString(Path.of(getFileFromResources("inputFile.txt")), Path.of(getFile("outputFile.txt")));
        printEjBanner(6);
        ej6MatchPQRegex("hola");
        ej6MatchPQRegex("pqq");
        ej6MatchPQRegex("pqqqqqqqqqQ");
        ej6MatchPQRegex("PqlqqQ");
        ej6MatchPQRegex("");
        printEjBanner(7);
        ej7ReplaceRegexMatch("Hola mundo", "Hola", "Adios");
    }

    private void printEjBanner(int i) {
        if (i != 1)
            System.out.println("\n");
        System.out.println("------------------------ Exercise " + i + ":------------------------------\n");
    }

    private URI getFileFromResources(String fileName) {
        URI uri = null;
        try {
            uri = getClass().getResource(fileName).toURI();
        } catch (URISyntaxException e) {
            System.err.println("Wrong URI");
        }
        return uri;
    }

    private URI getFile(String path) {
        return new File(System.getProperty("user.dir") + File.separator + path).toURI();
    }
    public void ej1PrintArray(Object[] elements, int option) {
        if (elements != null) {
            if (option == 2)
            {
                for (int i = 0; i < elements.length; i++) {
                    System.out.print(elements[i]);
                    if (i != elements.length - 1)
                        System.out.print(", ");
                }
                System.out.println();
            } else {
                Arrays.stream(elements).forEach(System.out::println);
            }
        } else
            System.err.println("Null array provided");
    }

    public void ej2PrintArray(int[] numbersArray) {
        if (numbersArray != null) {
            System.out.println("Evens:\n");
            for (int i = 0; i < numbersArray.length; i += 2) {
                System.out.println(numbersArray[i]);
            }
            if (numbersArray.length >= 2) {
                System.out.println("\n\nOdds:\n");
                for (int i = 1; i < numbersArray.length; i += 2) {
                    System.out.println(numbersArray[i]);
                }
            } else
                System.out.println("\n\nOdds: There is no odds in a 0/1 length array");
        } else
            System.err.println("Null array provided");
    }

    public void ej3FindSecondLargestNumber(int[] numbersArray) {
        if (numbersArray == null)
            System.err.println("Null arrray provided");
        else {
            final int LARGEST = 0;
            final int SECOND_LARGEST = 1;
            int[] largest = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            for (int i = 0; i < numbersArray.length; i++) {
                if (numbersArray[i] > largest[LARGEST]) {
                    largest[SECOND_LARGEST] = largest[LARGEST];
                    largest[LARGEST] = numbersArray[i];
                } else if (numbersArray[i] > largest[SECOND_LARGEST]){
                    largest[SECOND_LARGEST] = numbersArray[i];
                }
            }
            System.out.println("The second largest integer in the array is " + largest[SECOND_LARGEST]);
        }
    }

    public void ej4FindDifferenceBetweenDates(Date date1, Date date2, TemporalUnit unit) {

        long result = 0;
        Instant first = null;
        Instant second = null;

        if (date1 != null && date2 != null) {
            if (date1.before(date2)) {
                first = date1.toInstant();
                second = date2.toInstant();
            } else {
                first = date2.toInstant();
                second = date1.toInstant();
            }
            if (!first.isSupported(unit))
            {
                System.err.println("Unit " + unit + " is not supported in this operation, unit was switched to Days.");
                unit = ChronoUnit.DAYS;
            }
            result = first.until(second, unit);
        }

        System.out.println("The difference between " + date1.toString() + " and " + date2.toString() + " is: \n" + result + " " + unit.toString());

    }

    public void ej5ReverseString(Path inputPath, Path outputPath) {
        String string = null;
        try {
            string = Files.readString(inputPath);
            System.out.println("Read \""+ string + "\" from file " + inputPath.getFileName());
        } catch (IOException e) {
            System.err.println("Path " + inputPath + " is wrong");;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--)
            builder.append(string.charAt(i));
        try {
            Files.writeString(outputPath, builder.toString());
            System.out.println("Wrote \"" + builder.toString() + "\" in file " + outputPath.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ej6MatchPQRegex(String testedString) {
        if (testedString.matches("(?i)^pq*"))
            System.out.println("TRUE: The string " + testedString + " is only composed by an starting p and zero to infinite q's");
        else
            System.out.println("FALSE: The string " + testedString + " is NOT only composed by an starting p and zero to infinite q's");
    }

    public void ej7ReplaceRegexMatch(String text, String textToReplace, String newText) {
        System.out.println("The result of replacing \"" + textToReplace+ "\" in \"" + text + "\" is: \"" +text.replace(textToReplace, newText) + "\"");
    }
}
