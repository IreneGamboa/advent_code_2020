import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileLineByLine {

    public static ArrayList<String> reader(String fileName) {
        BufferedReader reader;
        ArrayList<String> lines = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(
                    fileName));
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                lines.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
