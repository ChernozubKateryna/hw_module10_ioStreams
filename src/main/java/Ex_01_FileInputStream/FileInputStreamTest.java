package Ex_01_FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        getCorrectNumber("D:/IT/GoIT_projects/module_10/file.txt");

    }

    public static void getCorrectNumber(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();

            String regex1 = "\\A\\(\\d{3}\\)\\s\\d{3}-\\d{4}\\Z"; //(xxx) xxx-xxxx
            String regex2 = "\\d{3}-\\d{3}-\\d{4}"; //xxx-xxx-xxxx

            if(number.matches(regex1) || number.matches(regex2)) {
                System.out.println(number);
            }
        }
        fileInputStream.close();
    }
}
