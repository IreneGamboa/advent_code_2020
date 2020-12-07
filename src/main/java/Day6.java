import java.util.ArrayList;
import java.util.HashSet;

public class Day6 {

    static void readInput(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        HashSet<Character> yesAnswer = new HashSet<>();
        int total = 0;

        for(int i = 0; i <  lines.size(); i++){
            String answers = lines.get(i);
            if(answers.length() == 0){
                total = total + yesAnswer.size();
                yesAnswer = new HashSet<>();
            } else {
                for(int j = 0; j < answers.length(); j++){
                    yesAnswer.add(answers.charAt(j));
                }
            }

            if(i == lines.size()-1){
                total = total + yesAnswer.size();
            }
        }

        System.out.println(total);
    }
}
