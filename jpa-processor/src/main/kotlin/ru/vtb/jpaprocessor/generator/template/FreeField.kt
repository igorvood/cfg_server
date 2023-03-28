package ru.vtb.jpaprocessor.generator.template;


import ru.vtb.jpaprocessor.generator.model.OrIsNullField;

public class FreeField {
    private final OrIsNullField orIsNullfield;

    public FreeField(OrIsNullField orIsNullField) {
        this.orIsNullfield = orIsNullField;
    }

    public String getName() {
        return orIsNullfield.name();
    }

    public String getType() {
        return orIsNullfield.type();
    }

    public FreeKlass getKlass() {
        return new FreeKlass(orIsNullfield.betterClass());
    }

    public String getGetter() {
        return "get" + getName().toUpperCase().charAt(0) + getName().substring(1);
    }
}
