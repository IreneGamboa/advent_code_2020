import java.util.ArrayList;

public class Day3 {

    static char [][] generateMatrix(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        int x = lines.size();
        int y = lines.get(0).length();

        char [][] matrix = new char[x][y];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matrix[i][j] = lines.get(i).charAt(j);
            }
        }
        return matrix;
    }

   static long countTrees(int right, int down, char [][] matrix){
       long totalTrees = 0;

        char value = matrix[down][right];
        int downCounter = down, rightCounter = right;

//        System.out.println(rightCounter);
//        System.out.println(downCounter);
        System.out.println(matrix.length);
        while(downCounter < matrix.length){
            int currentRightPattern = rightCounter%matrix[downCounter].length;
//            System.out.println(downCounter);
            if(matrix[downCounter][currentRightPattern] == '#'){
                System.out.println("x:" + downCounter +" - y:"+ currentRightPattern);
                totalTrees = totalTrees + 1;
            }
            downCounter = downCounter + down;
            rightCounter = rightCounter +right;
        }


        return totalTrees;
   }

   static void callCountTrees(){
       String fileName = "/Users/irenegamboapadilla/Desktop/input-day-3.txt";
       ReadFileLineByLine read = new ReadFileLineByLine();
       ArrayList<String> lines = read.reader(fileName);
       char [][] matrix = generateMatrix(fileName);
       long totalOne = countTrees(1, 1, matrix);
       long totalTwo = countTrees(3, 1, matrix);
       long totalThree = countTrees(5, 1, matrix);
       long totalFour = countTrees(7, 1, matrix);
       long totalFive = countTrees(1, 2, matrix);

       System.out.println(totalOne);
       System.out.println(totalTwo);
       System.out.println(totalThree);
       System.out.println(totalFour);
       System.out.println(totalFive);
       System.out.println(totalOne*totalTwo*totalThree*totalFour*totalFive);
   }
}
