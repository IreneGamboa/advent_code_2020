import java.util.ArrayList;
import java.util.HashSet;

public class Day6 {

    static void readInput(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        int union = union(lines);
        int intersection = intersection(lines);

        System.out.println("UNION:" + union);
        System.out.println("INTERSECTION:" + intersection);
    }

    static int union(ArrayList<String> data){
        HashSet<Character> yesAnswer = new HashSet<>();
        int total = 0;

        for(int i = 0; i <  data.size(); i++){
            String answers = data.get(i);
            if(answers.length() == 0){
                total = total + yesAnswer.size();
                yesAnswer = new HashSet<>();
            } else {
                for(int j = 0; j < answers.length(); j++){
                    yesAnswer.add(answers.charAt(j));
                }
            }

            if(i == data.size()-1){
                total = total + yesAnswer.size();
            }
        }
        return total;
    }

    static int intersection(ArrayList<String> data){
        ArrayList<HashSet> groupAnswer  = new ArrayList<>();
        int total = 0;

        for(int i = 0; i <  data.size(); i++){
            HashSet<Character> answerByPerson = new HashSet<>();
            String answers = data.get(i);
            if(answers.length() == 0){
                HashSet<Character> intersection = groupAnswer.get(0);
                for(int x = 1; x < groupAnswer.size(); x++){
                    intersection.retainAll(groupAnswer.get(x));
                }
                total = total + intersection.size();
                groupAnswer = new ArrayList<>();
            } else {
                for(int j = 0; j < answers.length(); j++){
                    answerByPerson.add(answers.charAt(j));
                }
                groupAnswer.add(answerByPerson);
            }

            if(i == data.size()-1){
                HashSet<Character> intersection = groupAnswer.get(0);
                for(int x = 1; x < groupAnswer.size(); x++){
                    intersection.retainAll(groupAnswer.get(x));
                }

                total = total + intersection.size();
            }
        }
        return total;
    }
}
