import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

class Result {
    Integer accumulator;
    boolean finished;

    public void setAccumulator(Integer value){
        accumulator = value;
    }
    public void setFinished( boolean value){
        finished = value;
    }
}
public class Day8 {

    static ArrayList<String> getInstructions(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> instructions = read.reader(fileName);

        return instructions;
    }

    static Result process(ArrayList<String> instructions) {
        HashSet<Integer> instructionsProcessed = new HashSet<>();
        Integer accumulator = 0;
        String instruction = "", operation = "";
        Integer argument = 0;
        int i = 0;
        Result result = new Result();


        while (i < instructions.size() && !instructionsProcessed.contains(i)) {
            instructionsProcessed.add(i);
            instruction = instructions.get(i);
            operation = instruction.split(" ")[0];
            argument = Integer.parseInt(instruction.split(" ")[1]);
            switch (operation) {
                case "acc":
                    accumulator = accumulator + argument;
                    i = i + 1;
                    break;
                case "jmp":
                    i = i + argument;
                    break;
                case "nop":
                    i = i + 1;
                    break;
            }
        }

        result.setAccumulator(accumulator);

        if (i == instructions.size()){
            result.setFinished(true);
            return result;

        }

        return result;
    }

    static Integer possibleOperation(ArrayList<String> instructions) {
        for(int i=0; i < instructions.size(); i++){
            Result runResult = new Result();
            ArrayList<String> newOperationInInstructions = new ArrayList<>(instructions);;
            String newOperation = "";
            String operation = newOperationInInstructions.get(i).split(" ")[0];
            String argument = newOperationInInstructions.get(i).split(" ")[1];

            if(operation.equals("jmp")){
                newOperation = newOperation+"nop "+argument;
                newOperationInInstructions.set(i, newOperation);
            }else if(operation.equals("nop")) {
                newOperation = newOperation + "jmp " + argument;
                newOperationInInstructions.set(i, newOperation);
            } else {
                continue;
            }
            runResult = process(newOperationInInstructions);
            if(runResult.finished){
                return  runResult.accumulator;
            }
        }
        return 0;
    }
}
