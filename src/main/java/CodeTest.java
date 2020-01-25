import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
    }

    public static String[] reverseArray(String[] input) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(input));
        Collections.reverse(list);
        return list.toArray(input);
    }

    public static String[] uppercaseArray(String[] input) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(input));
        return list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()).toArray(input);
    }

    public static Map<String, Integer> findWordCountAll(String text) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(text.split(" ")));
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : list) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
            ;
        }
        return map;
    }

    public static int findWordCount(String text, String wordToFind) {
        Map<String, Integer> map = findWordCountAll(text);
        return map.get(wordToFind);
    }

    public static Function<Integer, Integer> composeU(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return (d) -> {
            return f2.apply(f1.apply((d)));
        };
    }

    public static void writeContentsToConsole() {
        File myObj = new File(".gitignore");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
              }
              myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
     
    }

    public static void handleInvalidArgument(int x) {
        if (x < 15) {
            throw new IllegalArgumentException("Invalid value must be greater than 14 x was: " + x);
        }
    }

    public static void puzzle() {
        // add code here
    }
}