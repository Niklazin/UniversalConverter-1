package uconverter;

import asg.cliche.Command;

import java.util.Arrays;
import java.util.List;

public class UniversalConverter {
    private final List<UnitConverter> converters = Arrays.asList(
            new CelsiusUnitConverter(),
            new FahrenheitUnitConverter(),
            new KelvinUnitConverter()
    );
    private UnitConverter sourceConverter;
    private UnitConverter targetConverter;

    @Command
    public void list() {
        for (int i = 0; i < converters.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, converters.get(i));
        }
    }

    public List<UnitConverter> getConverters() {
        return converters;
    }

    @Command
    public void source(int idx) {
        sourceConverter = converters.get(idx - 1);
    }

    @Command
    public void target(int idx) {
        targetConverter = converters.get(idx - 1);
    }

    public UnitConverter getSourceConverter() {
        return sourceConverter;
    }

    public UnitConverter getTargetConverter() {
        return targetConverter;
    }

    @Command
    public double convert(double value) {
        UnitConverter src = getSourceConverter();
        UnitConverter trg = getTargetConverter();
        if (src == null && trg == null) {
            throw new IllegalStateException("Source and Target converters are not set");
        }
        if (src == null) {
            throw new IllegalStateException("Source converter is not set");
        }
        if (trg == null) {
            throw new IllegalStateException("Target converter is not set");
        }
        double si = src.toSI(value);
        return trg.fromSI(si);
    }
}

