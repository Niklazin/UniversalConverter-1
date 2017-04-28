package uconverter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UniversalConverterTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private final UniversalConverter uconv = spy(UniversalConverter.class);
    private final UnitConverter source = mock(UnitConverter.class);
    private final UnitConverter target = mock(UnitConverter.class);

    @Test
    public void convertBothNulls() throws Exception {
        when(uconv.getSourceConverter()).thenReturn(null);
        when(uconv.getTargetConverter()).thenReturn(null);
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Source and Target converters are not set");

        uconv.convert(0);
    }


    @Test
    public void convertSourceNull() throws Exception {
        when(uconv.getSourceConverter()).thenReturn(null);
        when(uconv.getTargetConverter()).thenReturn(target);
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Source converter is not set");

        uconv.convert(0);
    }

    @Test
    public void convertTargetNull() throws Exception {
        when(uconv.getSourceConverter()).thenReturn(source);
        when(uconv.getTargetConverter()).thenReturn(null);
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Target converter is not set");

        uconv.convert(0);
    }

    @Test
    public void convert() throws Exception {
        when(uconv.getSourceConverter()).thenReturn(source);
        when(uconv.getTargetConverter()).thenReturn(target);

        when(source.toSI(1000.0)).thenReturn(500.0);
        when(target.fromSI(500.0)).thenReturn(250.0);

        assertEquals(250.0, uconv.convert(1000.0), 0.00001);
    }
}