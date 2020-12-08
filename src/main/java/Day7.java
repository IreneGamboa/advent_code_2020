import com.sun.jdi.event.StepEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Rule {

    String bagType;
    Integer amount;

    public  Rule(String bagType, Integer amount) {
        this.bagType = bagType;
        this.amount = amount;

    }
}

public class Day7 {

    static void generateBagRules(String fileName){
        ReadFileLineByLine read = new ReadFileLineByLine();
        ArrayList<String> lines = read.reader(fileName);
        HashMap<String,ArrayList> bagRules = new HashMap<>();
        HashMap<String,ArrayList> bagRulesReverse = new HashMap<>();

        ArrayList<String> rules2 = new ArrayList<>();
        String bag = "";
        String bagContains = "";
        String reverse = "";
        for(String line:lines) {
            bag = line.split("bags")[0].strip();
            bagContains = line.split("contain")[1].strip();
            ArrayList<Rule> rules = new ArrayList<>();
            for (String contain : bagContains.split(",")){
                rules.addAll(getBagsContain(contain));
                reverse = getReverse(bag, contain);
                if(!reverse.isEmpty()){
                    rules2 = bagRulesReverse.getOrDefault(reverse, new ArrayList());
                    rules2.add(bag);
                    bagRulesReverse.put(reverse, rules2);
                }
            }

            bagRules.put(bag, rules);

        }

        String findingBag = "shiny gold";
        System.out.println(getBagsContainsOtherBag(findingBag, bagRulesReverse).size());
        System.out.println(totalBagsContain(findingBag, bagRules));
    }

    static ArrayList<Rule> getBagsContain(String bag){
        ArrayList<Rule> quantityBag = new ArrayList<>();

        Pattern regexBag = Pattern.compile("(\\d)+ ([a-z ]+) bags?");
        Matcher matcher = regexBag.matcher(bag);
        while (matcher.find()) {
            Rule rule = new Rule(matcher.group(2),Integer.parseInt(matcher.group(1)));
            quantityBag.add(rule);
        }
        return quantityBag;
    }

    static String getReverse(String bagPrincipal, String bags){
        String reverse = new String();
        Pattern regexBag = Pattern.compile("(\\d)+ ([yaa-z ]+) bags?");
        Matcher matcher = regexBag.matcher(bags);

        while (matcher.find()) {
            reverse = matcher.group(2);
        }
        return reverse;
    }

    static HashSet<String> getBagsContainsOtherBag(String findingBag, HashMap<String,ArrayList> bagRules){
        ArrayList<String> bagsHasFindingBag = bagRules.getOrDefault(findingBag, new ArrayList());
        HashSet<String> reviewedBags = new HashSet<>();

        while(bagsHasFindingBag.size() > 0){
            String bag = bagsHasFindingBag.get(0);
            bagsHasFindingBag.remove(0);
            ArrayList<String> bagC  = bagRules.getOrDefault(bag, new ArrayList());
//            System.out.println(bagC);
            if(!bagC.isEmpty() && !reviewedBags.contains(bag)){
                bagsHasFindingBag.addAll(bagC);
            }
            reviewedBags.add(bag);
        }

//        System.out.println(reviewedBags);

        return reviewedBags;
    }

    static Integer totalBagsContain(String findingBag, HashMap<String, ArrayList> rules){
        Integer total = 0;
        ArrayList<Rule> bagsContains = rules.getOrDefault(findingBag, new ArrayList());
//      System.out.println(bagsContains);
        for(int i = 0; i < bagsContains.size(); i++){
            Rule rule = bagsContains.get(i);
            String bag = rule.bagType;
            Integer amount = rule.amount;
            total = total + amount + amount * totalBagsContain(bag, rules);

        }

        return total;
    }
}
