package ir.maktabsharif;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q1P4 {
    public static void main(String[] args) {

        File file = new File("/home/amirali/Desktop/newAmirali.txt");

        String fileContent = readFile("/home/amirali/Desktop/amirali.txt");
        String[] splitContent = fileContent.split("(\n)| ");
//        System.out.println(Arrays.toString(splitContent));
        Stream<String> sorted = Arrays.stream(splitContent).sorted();
        List<String> sortedList = sorted.toList();

        //            if (!file.exists()) {
//                FileWriter fileWriter = new FileWriter("/home/amirali/Desktop/newAmirali.txt", true);
//            }
        for (String line : sortedList) {
            appendFile(line + "\n", "/home/amirali/Desktop/newAmirali.txt");
        }
    }

    public static void appendFile(String inputStr, String destinationFilePath) {

        try {
            FileWriter writer = new FileWriter(destinationFilePath, true);
            writer.write(inputStr);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String inputFilePath) {
        try {
            FileReader reader = new FileReader(inputFilePath);
            String str = "";
            int i;

            while ((i = reader.read()) != -1) {
                str += (char) i;
            }

            reader.close();
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
