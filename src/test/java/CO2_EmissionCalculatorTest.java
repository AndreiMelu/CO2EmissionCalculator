import org.junit.Test;

import static Util.CO2_CalculatorUtil.calculateCO2;
import static Util.CO2_CalculatorUtil.calculateCO2PerCategory;
import static Util.Category.*;
import static org.junit.Assert.assertEquals;

public class CO2_EmissionCalculatorTest {
    @Test
    public void defaultValuesTest() {
        //Small_cars
        assertEquals(142, calculateCO2(1, "km", 1, "small-diesel-car"));
        assertEquals(154, calculateCO2(1, "km", 1, "small-petrol-car"));
        assertEquals(73, calculateCO2(1, "km", 1, "small-plugin-hybrid-car"));
        assertEquals(50, calculateCO2(1, "km", 1, "small-electric-car"));

        //Medium_cars
        assertEquals(171, calculateCO2(1, "km", 1, "medium-diesel-car"));
        assertEquals(192, calculateCO2(1, "km", 1, "medium-petrol-car"));
        assertEquals(110, calculateCO2(1, "km", 1, "medium-plugin-hybrid-car"));
        assertEquals(58, calculateCO2(1, "km", 1, "medium-electric-car"));

        //Large_cars
        assertEquals(209, calculateCO2(1, "km", 1, "large-diesel-car"));
        assertEquals(282, calculateCO2(1, "km", 1, "large-petrol-car"));
        assertEquals(126, calculateCO2(1, "km", 1, "large-plugin-hybrid-car"));
        assertEquals(73, calculateCO2(1, "km", 1, "large-electric-car"));

        //Bus
        assertEquals(27, calculateCO2(1, "km", 1, "bus"));

        //Train
        assertEquals(6, calculateCO2(1, "km", 1, "train"));

    }

    @Test
    public void simpleTests() {
        assertEquals(142 * 2 * 3, calculateCO2(2, "km", 3, "small-diesel-car"));
        assertEquals(342, calculateCO2(2, "km", 1, "medium-diesel-car"));
        assertEquals(684, calculateCO2(2, "km", 2, "medium-diesel-car"));
    }

    @Test
    public void simpleTestsPerCategory() {
        assertEquals(27, calculateCO2PerCategory(1, "km", 1, Bus));
        assertEquals(6, calculateCO2PerCategory(1, "km", 1, Train));

        int defaultSmallCars = calculateCO2(1, "km", 1, "small-diesel-car") +
                calculateCO2(1, "km", 1, "small-petrol-car") +
                calculateCO2(1, "km", 1, "small-plugin-hybrid-car") +
                calculateCO2(1, "km", 1, "small-electric-car");

        int defaultMediumCars = calculateCO2(1, "km", 1, "medium-diesel-car") +
                calculateCO2(1, "km", 1, "medium-petrol-car") +
                calculateCO2(1, "km", 1, "medium-plugin-hybrid-car") +
                calculateCO2(1, "km", 1, "medium-electric-car");

        assertEquals(defaultSmallCars, calculateCO2PerCategory(1, "km", 1, Small_car));
        assertEquals(defaultSmallCars, calculateCO2PerCategory(1, "km", 1, Medium_car));
    }
}