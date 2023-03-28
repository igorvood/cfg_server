package ru.vtb.jpaprocessor.generator.model;

public interface OrIsNullSearchMethod {
    String name();

    OrIsNullClass entity();

    OrIsNullClass filter();

    String query();
}
