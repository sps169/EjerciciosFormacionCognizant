package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_Manager {
    String path;
    public File_Manager(String path) {
        this.path = path;
    }

    public List<String> getContent(){
        List<String> data = new ArrayList<>();
        String line;
        try {
            File myObj = new File("src/PageList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                if (line.contains("☑"))
                    data.add(line.replace(" ☑", ""));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
