import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class task_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        File file = new File("E:/Java/Lection1/untitled3/src/doc.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> newList = new ArrayList<>();
        for (String string : list) {
            String[] tempArray = string.split(" ");
            newList.add(tempArray[0]);
        }
        System.out.println(newList);

        Map<String, Integer> frequency = newList.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer :: sum));
        frequency.forEach((k, v) -> System.out.println(k + ": " + v));

        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(
                Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())
        );
        sorted.addAll(frequency.entrySet());
        System.out.println(sorted);
    }
}