package functions;

import static org.junit.jupiter.api.Assertions.*;

import functions.models.Country;
import functions.models.CountryUtil;
import org.junit.jupiter.api.Test;

public class CountryTests {

    @Test
    public void testBetween() {
        Country country = new Country(0x480000, 0x487FFF, "Netherlands, Kingdom of the", "Netherlands.png");

        int hexa = Integer.parseInt("486258", 16);
        assertTrue(hexa >= country.getStart() && hexa <= country.getEnd());

    }

    @Test
    public void testCountryUtil() {
        Country country = new Country(0x480000, 0x487FFF, "Netherlands, Kingdom of the", "Netherlands.png");

        int hexa = Integer.parseInt("486258", 16);
        assertEquals("Netherlands, Kingdom of the", CountryUtil.findByICAO("486258").getName());

    }
}
