package ru.vtb.jpaprocessor.generator.template;

import ru.vtb.jpaprocessor.generator.model.OrIsNullClass;

import java.util.List;
import java.util.stream.Collectors;

public class FreeKlass {
    private final OrIsNullClass orIsNullSearchInterface;

    public FreeKlass(OrIsNullClass orIsNullSearchInterface) {
        this.orIsNullSearchInterface = orIsNullSearchInterface;
    }

    public String getPackageName() {
        return orIsNullSearchInterface.packageName();
    }

    public String getFullname() {
        return orIsNullSearchInterface.name();
    }
    public String getShortname() {
        return orIsNullSearchInterface.shortName();
    }

    public List<FreeField> getFields() {
        return orIsNullSearchInterface.fields().stream()
                .map(f -> new FreeField(f))
                .collect(Collectors.toList());
    }
}
