package be.com.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static be.com.config.Properties.getProperties;

public class Rule {

    private static List<String> allRules = new ArrayList<>();

    public static List<String> rule_two_get_one(){
        allRules.addAll(Arrays.asList(getProperties().getProperty("rule.two_get_one")));
        return Arrays.asList(getProperties().getProperty("rule.two_get_one"));
    }

    public static List<String> buy_three_get_discount(){
        allRules.addAll(Arrays.asList(getProperties().getProperty("rule.buy_three_get_discount")));
        return Arrays.asList(getProperties().getProperty("rule.buy_three_get_discount"));
    }

    public static List<String> getAllRules(){
        return allRules;
    }

    public static double discount(){
        return Double.parseDouble(getProperties().getProperty("rule.discount"));
    }
}
