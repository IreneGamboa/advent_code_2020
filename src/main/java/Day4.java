import java.awt.*;
import java.util.ArrayList;

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
        for(String line : lines){
            if(line.length() == 0){
                listPass.add(passport);

                passport = new Passport();
            } else {
                String[] passportData = line.split(" ");

                for (String data : passportData) {
                    String[] dataSplit = data.split(":");
                    passport.setData(dataSplit);
                }
            }
        }

        return listPass;
    }

    static void  totalValid(){
        ArrayList<Passport> dataPasswords = new ArrayList<>();
        String fileName  = "/Users/irenegamboapadilla/IdeaProjects/advent_code_2020/input_day_4.txt";
        int totalValid = 0;

        dataPasswords = readFile(fileName);

        System.out.println(dataPasswords.size());
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
        System.out.println("--------");
        System.out.println(pass.byr);
        System.out.println(pass.iyr);
        System.out.println(pass.eyr);
        System.out.println(pass.hgt);
        System.out.println(pass.hcl);
        System.out.println(pass.ecl);
        System.out.println(pass.pid);

        if(pass.byr != -1 && pass.iyr != -1 && pass.eyr != -1 && !pass.hgt.isEmpty() &&
                !pass.hcl.isEmpty() && !pass.ecl.isEmpty() && !pass.pid.isEmpty()) {
            System.out.println("valid");
            System.out.println("-------");
            return true;

        }
        System.out.println("--------");

        return false;
    }
}
