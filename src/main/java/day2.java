import java.util.*;

public class day2 {

    static int total(String fileName){
        int total = 0;
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);

        for(String line : lines){
            String [] data = line.split(" ");
            String [] minMax = data[0].split("-");
            char letter = data[1].charAt(0);
            String possiblePass = data[2];
            if(isPasswordTwo(Integer.parseInt(minMax[0]), Integer.parseInt(minMax[1]), letter, possiblePass)){
                total++;
            }
        }
        return total;
    }
    static boolean isPassword(int min, int max, char letter, String possiblePass){
        HashMap<Character,Integer> totalLetterInPossiblePass = new HashMap<Character,Integer>();
        boolean isPassword = false;
        for(int i = 0; i < possiblePass.length(); i++){
            int value = totalLetterInPossiblePass.getOrDefault(possiblePass.charAt(i), 0);
            totalLetterInPossiblePass.put(possiblePass.charAt(i), value+1);
        }

        int totalAppearLetter = totalLetterInPossiblePass.getOrDefault(letter,0);
        if(totalAppearLetter != 0 && totalAppearLetter >= min && totalAppearLetter <= max) {
            isPassword = true;
        }

        return isPassword;
    }

    static boolean isPasswordTwo(int positionOne, int positionTwo, char letter, String possiblePass){
        boolean isPassword = false;
        if(possiblePass.charAt(positionOne-1) == letter && possiblePass.charAt(positionTwo-1) != letter ||
                possiblePass.charAt(positionOne-1) != letter && possiblePass.charAt(positionTwo-1) == letter){
            isPassword = true;
        }

        return isPassword;
    }
}
