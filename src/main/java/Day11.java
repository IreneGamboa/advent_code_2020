import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day11 {

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

    static boolean updateSeats(char [][] matrix){
        int rules = 5;
        char [][] newMatrix = copy(matrix);
        boolean finish = false;

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

//                int adjacentCount = adjacentCount(matrix, i, j); // First Question
                int adjacentCount = occupiedForPositon(matrix, i, j); // Second Question

                if(matrix[i][j] == 'L' && adjacentCount == 0){
                    finish = true;
                    newMatrix[i][j] = '#';
                } else if(matrix[i][j] == '#' && adjacentCount >= rules){
                    finish = true;
                    newMatrix[i][j] = 'L';
                }
            }

        }
        if(!finish){
            System.out.println(totalOccupied(newMatrix));
        }
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }

        return finish;
    }



    static int totalOccupied(char [][] matrix){
        int total = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                if(matrix[i][j] == '#'){
                    total = total + 1;
                }
            }
        }
        return total;
    }

//

    static int adjacentCount(char [][] matrix, int i, int j){
        int count = 0;
        int  xMin = Math.max(0, i-1);
        int xMax = Math.min(i+2, matrix.length);
        int yMin = Math.max(0, j-1);
        int yMax = Math.min(j+2, matrix[i].length);
//        if(i > 1 &&  matrix[i-1][j] == '#') {
//
//            count = count + 1;
//        }
        for(int a = xMin; a < xMax; a++){
            for(int b = yMin; b < yMax; b++){
                if(a == i && b == j){
                    continue;
                }
                if(matrix[a][b] == '#')  {
//                    System.out.println(matrix[a][b]);
//                    System.out.println(count);
                    count = count + 1;
                }
            }
        }
        return count;
    }
    static char[][] copy(char[][] original){
        if (original == null) {
            return null;
        }

        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    static void callFunction(String fileName){
        char [][] matrix = generateMatrix(fileName);
        boolean changed = true;

//        adjacentCount(matrix, 1,1);

//
//     changed = updateSeats(matrix);
        while(changed){
            System.out.println("here");
            changed = updateSeats(matrix);
        }
    }

    static int occupiedForPositon(char [][]matrix, int i, int j){
        int count = 0;
        int x = i, y=j;
        while (x>0){
            x--;
            if(matrix[x][j] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][j] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(x < matrix.length-1){
            x++;
            if(matrix[x][j] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][j] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(y > 0){
            y--;
            if(matrix[i][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[i][y] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(y < matrix[i].length-1){
            y++;
            if(matrix[i][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[i][y] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(x>0 && y > 0){
            x--;
            y--;
            if(matrix[x][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][y] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(x>0 && y < matrix[x].length-1){
            x--;
            y++;
            if(matrix[x][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][y] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(x < matrix.length -1 && y > 0){
            x++;
            y--;
            if(matrix[x][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][y] == 'L'){
                break;
            }
        }
        x = i;
        y = j;
        while(x < matrix.length -1 && y < matrix[x].length-1){
            x++;
            y++;
            if(matrix[x][y] == '#'){
                count = count + 1;
                break;
            } else if(matrix[x][y] == 'L'){
                break;
            }
        }

        return count;
    }


//    def get_occupied_for_position(layout, pos):
//    x, y = pos
//            count = 0
//    while x > 0:
//    x -= 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while x < len(layout)-1:
//    x += 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while y > 0:
//    y -= 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while y < len(layout[x])-1:
//    y += 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while x > 0 and y > 0:
//    x -= 1
//    y -= 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while x > 0 and y < len(layout[x])-1:
//    x -= 1
//    y += 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while x < len(layout)-1 and y > 0:
//    x += 1
//    y -= 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//    x, y = pos
//    while x < len(layout)-1 and y < len(layout[x])-1:
//    x += 1
//    y += 1
//            if layout[x][y] == '#':
//    count += 1
//            break
//    elif layout[x][y] == 'L':
//            break
//            return count

}

