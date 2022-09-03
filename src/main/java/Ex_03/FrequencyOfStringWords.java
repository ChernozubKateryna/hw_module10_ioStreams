package Ex_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class FrequencyOfStringWords {
    public static void main(String[] args) throws IOException {
        countFrequency("D:/IT/GoIT_projects/module_10/words.txt");
    }

    public static void countFrequency(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        String allStrings = "";

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            allStrings += string + " ";
        }

        Map<String, Integer> map = new TreeMap<>();
        String[] stringArray = allStrings.split(" ");

        //filling the map with values
        for (int i = 0; i < stringArray.length; i++) {
            if (map.containsKey(stringArray[i])) {
                map.put(stringArray[i], map.get(stringArray[i]) + 1);
            } else {
                map.put(stringArray[i], 1);
            }
        }
        //hashLinkedList
        //map.entrySet().stream().sorted((Comparator<? super Map.Entry<String, Integer>>) Map.Entry.comparingByValue().reversed());
        //print the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();

        //sorting the map by the count of values
        //{day=1, sunny=2, is=3, the=4}
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            resultMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        fileInputStream.close();
    }
}
