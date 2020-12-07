import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day5 {

    static ArrayList<Integer> read(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        ArrayList<Integer> seatsID = new ArrayList<>();
        for(String line:lines){
            int maxRow = 127, minRow  = 0;
            int maxColumn = 7, minColumn = 0;
            for(int i =0 ; i<line.length(); i++){
                char letter = line.charAt(i);
                switch (letter) {
                    case 'F':
                        maxRow = (minRow + maxRow) / 2;
                        break;
                    case 'B':
                        minRow = (minRow + maxRow+1) / 2;
                        break;
                    case 'L':
                        maxColumn = (minColumn + maxColumn) / 2;
                        break;
                    case 'R':
                        minColumn = (minColumn + maxColumn) / 2;
                        break;
                }
            }
            seatsID.add(maxRow * 8 + maxColumn);
        }
        return seatsID;
    }

    static int highestSeatID(){
        String fileName = "/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input-5.txt";
        ArrayList<Integer> seatsID = read(fileName);
        Collections.sort(seatsID);
        System.out.println(seatsID);
        return seatsID.get(seatsID.size()-1);

    }

    static int myTicket(){
        String fileName = "/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input-5.txt";
        ArrayList<Integer> seatsID = read(fileName);
        Integer myTicket  = 0;
//        Collections.sort(seatsID);
//        System.out.println(seatsID);
        for(Integer seatID: seatsID){
            System.out.println(seatID);
//            System.out.println(seatID + 2);
//            System.out.println(seatID + 1);
//            System.out.println("----");
           if(seatsID.contains(seatID + 2) && !seatsID.contains(seatID + 1)){
////               System.out.println(seatsID.get(seatID + 2));
               System.out.println("here: " + (seatID + 1));
                myTicket = seatID + 1;
               return myTicket;
           }
        }
        return myTicket;
    }
}
