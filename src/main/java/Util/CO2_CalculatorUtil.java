package Util;

import java.util.HashMap;
import java.util.Map;

import static Util.Category.*;

public class CO2_CalculatorUtil {
    private static Map<String, Map<String, Integer>> CO2data = new HashMap<>();

    public static void addValues() {
//      Adding values for small cars
        CO2data.put(Small_car.toString(), new HashMap<String, Integer>() {{
            put("small-diesel-car", 142);
            put("small-petrol-car", 154);
            put("small-plugin-hybrid-car", 73);
            put("small-electric-car", 50);
        }});
//      Adding values for medium cars
        CO2data.put(Medium_car.toString(), new HashMap<String, Integer>() {{
            put("medium-diesel-car", 171);
            put("medium-petrol-car", 192);
            put("medium-plugin-hybrid-car", 110);
            put("medium-electric-car", 58);
        }});
//      Adding values for medium cars
        CO2data.put(Large_car.toString(), new HashMap<String, Integer>() {{
            put("large-diesel-car", 209);
            put("large-petrol-car", 282);
            put("large-plugin-hybrid-car", 126);
            put("large-electric-car", 73);
        }});
//      Adding values for medium cars
        CO2data.put(Bus.toString(), new HashMap<String, Integer>() {{
            put("bus", 27);
        }});
        //      Adding values for medium cars
        CO2data.put(Train.toString(), new HashMap<String, Integer>() {{
            put("train", 6);
        }});
    }

    private static Map<String, Integer> getAllValues() {
        Map<String, Integer> result = new HashMap<>();
        result.putAll(getAllPerCategory("Small_car"));
        result.putAll(getAllPerCategory("Medium_car"));
        result.putAll(getAllPerCategory("Large_car"));
        result.putAll(getAllPerCategory("Bus"));
        result.putAll(getAllPerCategory("Train"));
        return result;
    }

    private static Map<String, Integer> getAllPerCategory(String category) {
        return CO2data.get(category);
    }

    public static int calculateCO2(double distance, String unitDistance, int nrPassengers, String transportation) {
        addValues();
        int value = getAllValues().get(transportation);
        if (unitDistance == "m") {
            distance = distance / 1000;
        }
        return (int)(distance * value * nrPassengers);
    }

    public static int calculateCO2PerCategory(double distance, String unitDistance, int nrPassengers, Category category) {
        addValues();
        Map<String, Integer> rez = new HashMap<>();
        Map<String, Integer> allCategory = getAllPerCategory(category.toString());

        for (Map.Entry<String, Integer> pair : allCategory.entrySet()) {
            rez.put(pair.getKey(), calculateCO2(distance, unitDistance, nrPassengers, pair.getKey()));
        }
        int totalPerCategory = 0;
        System.out.println("");
        for (String s : rez.keySet()) {
            System.out.println("This trip with " + s + " causes: " + rez.get(s) + "g of CO2-equivalent");
            totalPerCategory += rez.get(s);
        }
        return totalPerCategory;
    }
}
