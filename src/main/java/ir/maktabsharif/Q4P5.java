package ir.maktabsharif;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Q4P5 {
    public static void main(String[] args) {
        File newFile = new File("/home/amirali/Desktop/InternetTaxi");
        System.out.println(extracted(newFile));


//        File directory = new File("/home/amirali/Desktop/InternetTaxi");
//        long size = FileUtils.sizeOfDirectory(directory);
//        System.out.println("Size of directory: " + size + " bytes");


//        Path folder = Paths.get("/home/amirali/Desktop/InternetTaxi");
//        try {
//            long size = Files.walk(folder)
//                    .filter(p -> p.toFile().isFile())
//                    .mapToLong(p -> p.toFile().length())
//                    .sum();
//
//            System.out.println(size);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static Long extracted(File newFile) {
        File[] filesArray = newFile.listFiles();
        Long fileSize = 0L;
        for (File file : filesArray) {
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                fileSize += extracted(file);
            } else {
                try {
                    fileSize += (Long) Files.getAttribute(file.toPath(), "basic:size");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return fileSize;
    }
}
