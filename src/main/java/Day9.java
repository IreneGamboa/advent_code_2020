import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Day9 {

    static ArrayList<String> read(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> numbers = read.reader(fileName);

        return numbers;
    }

    static Integer checkProperty(ArrayList<String> numbers){
        Integer preamble = 25;
        boolean valid = true;

        for(int i = preamble; i < numbers.size(); i++){
            List<String> subNumbers = numbers.subList(i-preamble, i);
           ArrayList<Integer> result = isValid(subNumbers, Integer.parseInt(numbers.get(i)));
            if(result.isEmpty()){
                return Integer.parseInt(numbers.get(i));
            }
        }
        return 0;
    }

    static ArrayList<Integer> isValid( List<String> numbers, Integer finding){
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashSet<Integer> setReport = new HashSet<Integer>();

        for(String i: numbers){
            setReport.add(Integer.parseInt(i));
        }

        for(String entry : numbers){
            Integer missing = finding - Integer.parseInt(entry);
            if(setReport.contains(missing)){
                result.add(Integer.parseInt(entry));
                result.add(missing);
                return result;
            }
        }
        return result;
    }

    static Integer contiguos(ArrayList<String> numbers, Integer finding, int size) {
        List<String> subNumbers = new ArrayList<>();
        Integer smallAndLargest = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(i+size < numbers.size()){
                subNumbers = numbers.subList(i, i + size);
                long sum = 0;
                for (String subNumber : subNumbers) {
                    sum = sum + Long.parseLong(subNumber);
                }
                if (Long.valueOf(finding) == sum) {
                    Collections.sort(subNumbers);
                    smallAndLargest = Integer.parseInt(subNumbers.get(0)) + Integer.parseInt(subNumbers.get(subNumbers.size()-1));
                }

            }
            if(smallAndLargest != 0){

                return smallAndLargest;
            }
        }
        return  smallAndLargest;
    }

    static Integer findingContiguos(ArrayList<String> numbers){
        Integer least = 2;
        Integer finding = checkProperty(numbers);
        List<String> result = new ArrayList<>();

        for(int i = least; i < numbers.size(); i++){
            Integer sum = contiguos(numbers, finding, i);
            if(sum != 0) {
                return sum;
            }
        }
        return 0;
    }

    static void callFunction(String fileName){
        ArrayList<String> numbers = read(fileName);
        System.out.println(checkProperty(numbers));
        System.out.println(findingContiguos(numbers));

    }
}
