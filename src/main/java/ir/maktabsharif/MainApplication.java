package ir.maktabsharif;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        File directory = new File("/home/amirali/Desktop");
        Scanner input = new Scanner(System.in);

        //        q1p1(files);
//        q1p2(files, myFile, directory);
        appendFile(readFile("/home/amirali/Desktop/amirali.txt"),
                "/home/amirali/Desktop/amirali.txt");


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

    private static void q1p2(String[] files, String myFile, File directory) {
        if (files != null) {
            for (String file : files) {
                if (file.equals(myFile)) {
                    System.out.println("file name: " + file + "\npath: " + directory.getAbsolutePath());
                }
            }
        } else {
            System.out.println("not a directory");
        }
    }

    private static void q1p1(String[] files) {
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("not a directory");
        }
    }


}
