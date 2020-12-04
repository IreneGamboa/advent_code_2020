import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Passport {

    int byr = -1;
    int iyr= -1;
    int eyr = -1;
    String hgt  = "";
    String hcl = "";
    String ecl = "";
    String pid = "";
    String cid = "";

    public void setData(String [] data){
        switch (data[0]){
            case "byr":
                byr = Integer.parseInt(data[1]);
                break;
            case "iyr":
                iyr = Integer.parseInt(data[1]);
                break;
            case "eyr":
                eyr = Integer.parseInt(data[1]);
                break;
            case "hgt":
                hgt = data[1];
                break;
            case "hcl":
                hcl = data[1];
                break;
            case "ecl":
                ecl = data[1];
                break;
            case "pid":
                pid = data[1];
                break;
            case "cid":
                cid = data[1];
                break;
            default:
                break;
        }
    }


}

public class Day4 {
    static ArrayList<Passport> readFile(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        ArrayList<Passport> listPass = new ArrayList<>();

        Passport passport = new Passport();
        for(int i = 0; i <  lines.size(); i++){
            if(lines.get(i).length() == 0){
                listPass.add(passport);
                passport = new Passport();
            } else {
                String[] passportData = lines.get(i).split(" ");

                for (String data : passportData) {
                    String[] dataSplit = data.split(":");
                    passport.setData(dataSplit);
                }
            }

            if(i == lines.size()-1){
                listPass.add(passport);
            }
        }

        return listPass;
    }

    static void  totalValid(){
        ArrayList<Passport> dataPasswords = new ArrayList<>();
        String fileName  = "/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input_day_4.txt";
        int totalValid = 0;

        dataPasswords = readFile(fileName);

        for(Passport pass : dataPasswords){
            if(isValid(pass)){
                totalValid++;
            }
        }

        System.out.println(totalValid);
    }



    static String capitalize(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    static boolean isValid(Passport pass){

        if(validYear(pass.byr, 1920, 2002) && validYear(pass.iyr, 2010, 2020) && validYear(pass.eyr, 2020, 2030) &&
                validHeight(pass.hgt) && validHcl(pass.hcl) && validEcl(pass.ecl) && validPid(pass.pid)) {
            return true;

        }

        return false;
    }

    static boolean validYear(int year, int min, int max){
        if(year != -1  && year >= min && year <= max){
            return true;
        }

        return false;
    }

    static boolean validHeight(String height){
        Pattern cm = Pattern.compile("cm"), in = Pattern.compile("in");
        Matcher matcherCm = cm.matcher(height) , matcherIn = in.matcher(height);

        if(!height.isEmpty() && matcherCm.find()){
            int centimeters = Integer.parseInt(height.substring(0, height.length() - 2));
            if( centimeters >= 150 && centimeters <= 193){
                return true;
            }
        }

        if(matcherIn.find()){
            int inches = Integer.parseInt(height.substring(0, height.length() - 2));
            if( inches >= 59 && inches <= 76){
                return true;
            }
        }

        return false;
    }

    static boolean validHcl(String hcl){
        Pattern regexHcl = Pattern.compile("#[0-9a-f]{6}");
        Matcher matcherHcl = regexHcl.matcher(hcl);

        if(!hcl.isEmpty() && matcherHcl.find()){
            return true;
        }
        return false;
    }

    static boolean validEcl(String ecl){
        HashSet<String> eclRequire = new HashSet<>();
        eclRequire.add("amb");
        eclRequire.add("blu");
        eclRequire.add("brn");
        eclRequire.add("gry");
        eclRequire.add("grn");
        eclRequire.add("hzl");
        eclRequire.add("oth");

        if(!ecl.isEmpty() && eclRequire.contains(ecl)){

            return true;
        }
        return false;
    }

    static boolean validPid(String pid){
        Pattern regexPid = Pattern.compile("\\d{9}");
        Matcher matcherPid= regexPid.matcher(pid);

        if(!pid.isEmpty() && matcherPid.find()){

            return true;
        }
        return false;
    }

}
