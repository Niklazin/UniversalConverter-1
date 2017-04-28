package uconverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CelsiusUnitConverterTest {
    private CelsiusUnitConverter converter = new CelsiusUnitConverter();
    @Parameterized.Parameter(0)
    public double celsius;
    @Parameterized.Parameter(1)
    public double kelvin;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 283.15},
                {100, 373.15},
                {-273.15, 0}
        });
    }

    @Test
    public void toSI() throws Exception {
        assertEquals(kelvin, converter.toSI(celsius), 0.00001);
    }

    @Test
    public void fromSI() throws Exception {
        assertEquals(celsius, converter.fromSI(kelvin), 0.00001);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Celsius", converter.getName());
    }

}