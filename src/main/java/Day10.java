import java.util.*;

public class Day10 {
    static ArrayList<String> read(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> numbers = read.reader(fileName);

        return numbers;
    }

    static int result1(ArrayList<Integer> numbers){

        int multiply = 0;
        HashMap<Integer, Integer> differences = new HashMap<>();

        System.out.println(numbers);
        for(int i = 1; i < numbers.size(); i++){
            Integer diff = numbers.get(i) - numbers.get(i-1);
            differences.put(diff, differences.getOrDefault(diff, 0)+1);
        }
        multiply = differences.get(1) * differences.get(3);
        return multiply;
    }

    static void result2(ArrayList<Integer> numbers){
        System.out.println(numbers);
        Collections.sort(numbers);
        ArrayList<Integer> firstNodes = new ArrayList<>();
        HashMap<Integer,Long> map = new HashMap<>();
        long value = 0;

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 4){
                firstNodes.add(numbers.get(i));
            }
        }
        System.out.println(firstNodes);
        for(int i = 1; i < numbers.size(); i++){
            int va = numbers.get(i);
            if(firstNodes.contains(va)){
                value = 1;
            } else {
                value = 0;
            }
            for(int j= va-3; j < va; j++){
                System.out.println(va);
                value = value + map.getOrDefault(j, Long.valueOf(0));
            }
            map.put(va, Long.valueOf(value));
        }
        System.out.println(map);
        System.out.println(map.get(numbers.get(numbers.size()-1)));
    }

    static void callFunction(String fileName){
        ArrayList<String> lines = read(fileName);
        ArrayList<Integer> numbers = new ArrayList<>();

        for(String line:lines){
            numbers.add(Integer.parseInt(line));
        }
        Collections.sort(numbers);
        numbers.add(0,0);
        int lastNumber = numbers.get(numbers.size()-1)+3;
        numbers.add(lastNumber);
//        System.out.println(result1(numbers));
        result2(numbers);
    }

}
