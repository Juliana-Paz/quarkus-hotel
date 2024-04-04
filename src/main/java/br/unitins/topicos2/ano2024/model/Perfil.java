package br.unitins.topicos2.ano2024.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {

    CLIENTE(1, "Cliente"),
    FUNCIONARIO(2, "Funcionário");

    private final int id;
    private final String label;

    Perfil(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Perfil valueOf(Integer id) throws IllegalArgumentException {
        if (id == null) {
            return null;
        }

        for (Perfil perfil : Perfil.values()) {
            if (id.equals(perfil.getId())) {
                return perfil;
            }
        }

        throw new IllegalArgumentException("ID inválido: " + id);
    }
}