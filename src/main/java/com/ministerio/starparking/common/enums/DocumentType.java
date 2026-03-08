package com.ministerio.starparking.common.enums;

public enum DocumentType {
    CC("Cédula de Ciudadanía"),
    CE("Cédula de Extranjería"),
    TI("Tarjeta de Identidad"),
    NIT("Número de Identificación Tributaria"),
    P("Pasaporte"),
    RC("Registro Civil"),
    PE("Permiso Especial de Permanencia"),
    CDP("Carné Diplomático/Consular");

    private final String description;

    DocumentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}