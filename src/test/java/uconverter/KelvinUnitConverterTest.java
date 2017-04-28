package uconverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KelvinUnitConverterTest {
    private KelvinUnitConverter converter = new KelvinUnitConverter();

    @Test
    public void toSI() throws Exception {
        assertEquals(0, converter.toSI(0), 0.00001);
    }

    @Test
    public void fromSI() throws Exception {
        assertEquals(0, converter.fromSI(0), 0.00001);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Kelvin", converter.getName());
    }
}