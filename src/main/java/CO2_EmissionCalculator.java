import java.util.HashMap;
import java.util.Map;
import static Util.Category.*;
import static Util.CO2_CalculatorUtil.*;


public class CO2_EmissionCalculator {
    static Map<String, Map<String, Integer>> CO2data = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Your trip causes: " + calculateCO2(15, "km", 1, "medium-diesel-car") + "g of CO2-equivalent");
        System.out.println("Your trip causes: " + calculateCO2(15032, "m", 1, "medium-diesel-car") + "g of CO2-equivalent");
        System.out.println("This trip with all " + Medium_car.toString() + " causes: " + calculateCO2PerCategory(15, "km", 1, Medium_car) + "g of CO2-equivalent");
        System.out.println("This trip with all " + Small_car.toString() + " causes: " + calculateCO2PerCategory(15, "km", 1, Small_car) + "g of CO2-equivalent");
        System.out.println("This trip with all " + Bus.toString() + " causes: " + calculateCO2PerCategory(1, "km", 1, Bus) + "g of CO2-equivalent");
    }
}
