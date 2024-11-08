import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2 {

    public static void main(String[] args) {
        List<Student> allData = createDataFromCSV("src/studentCSV.csv", new Student());

        allData.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    private static <T extends CreateFromCSV<T>> List<T> createDataFromCSV(String filePath, CreateFromCSV<T> clazz) {
        String line;
        // could be placed at the method params to be adjusted
        String delimiter = ",";
        List<T> classList = new ArrayList<>();
        //try with resources, the buffer will closer after execution
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(delimiter);  // Assuming the first line contains headers

            while ((line = br.readLine()) != null) {
                Map<String, String> row = new HashMap<>();
                String[] values = line.split(delimiter);

                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], values[i]);
                }
                classList.add(clazz.createFromCSV(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classList;
    }

}
