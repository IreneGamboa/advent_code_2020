import java.util.ArrayList;

public class AdventCodeMain {
    public static void main(String args[]){
        System.out.println("Hello world");


        Day2 testDay2 = new Day2();
        Day3 testDay3 = new Day3();
        Day4 testDay4 = new Day4();
        Day5 testDay5 = new Day5();
        Day6 testDay6 = new Day6();
        Day7 testDay7 = new Day7();
        Day8 testDay8 = new Day8();

//        testDay7.generateBagRules("/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input-7.txt");
        ArrayList<String> instructions = testDay8.getInstructions("/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input-8.txt");
        System.out.println(testDay8.process(instructions).accumulator);
        System.out.println(testDay8.possibleOperation(instructions));

//
    }
}
