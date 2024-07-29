package com.thecorner.paq;

public class Electrodomestico {
    // Atributos
    private static final float PRECIO_BASE_DEFECTO = 100; // Valor por defecto para el precio base
    private static final String COLOR_DEFECTO = "blanco"; // Valor por defecto para el color
    private static final char CONSUMO_ENERGETICO_DEFECTO = 'F'; // Valor por defecto para el consumo energético
    private static final float PESO_DEFECTO = 5; // Valor por defecto para el peso

    // Atributos de instancia
    private float precioBase;
    private String color;
    private char consumo;
    private float peso;

    // Constructor por defecto
    public Electrodomestico() {
        this(PRECIO_BASE_DEFECTO, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO, PESO_DEFECTO);
    }

    // Constructor con precioBase, color, consumo y peso
    public Electrodomestico(float precioBase, String color, char consumo, float peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumo = comprobarConsumoEnergetico(consumo);
        this.peso = peso;
    }

    // Constructor con precioBase y peso
    public Electrodomestico(float precioBase, float peso) {
        this(precioBase, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO, peso);
    }

    // Métodos getter y setter
    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = comprobarConsumoEnergetico(consumo);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    // Método para comprobar el consumo energético
    private char comprobarConsumoEnergetico(char letra) {
        char[] letrasValidas = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char c : letrasValidas) {
            if (Character.toUpperCase(letra) == c) {
                return Character.toUpperCase(letra);
            }
        }
        return CONSUMO_ENERGETICO_DEFECTO; // Si la letra no es válida, se usa el valor por defecto
    }

    // Método para comprobar el color
    private String comprobarColor(String color) {
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};
        for (String c : coloresValidos) {
            if (color.equalsIgnoreCase(c)) {
                return c.toLowerCase(); // Convertir a minúsculas para estandarizar
            }
        }
        return COLOR_DEFECTO; // Si el color no es válido, se usa el color por defecto
    }

    // Método para calcular el precio final basado en el consumo energético y peso
    public double precioFinal() {
        double precioFinal = this.precioBase;

        // Ajuste basado en el consumo energético
        switch (this.consumo) {
            case 'A': precioFinal += 100; break;
            case 'B': precioFinal += 80; break;
            case 'C': precioFinal += 60; break;
            case 'D': precioFinal += 50; break;
            case 'E': precioFinal += 30; break;
            case 'F': precioFinal += 10; break;
            default: precioFinal += 10; // Valor por defecto
        }

        // Ajuste basado en el peso
        if (this.peso >= 0 && this.peso <= 19) {
            precioFinal += 10;
        } else if (this.peso >= 20 && this.peso <= 49) {
            precioFinal += 50;
        } else if (this.peso >= 50 && this.peso <= 79) {
            precioFinal += 80;
        } else if (this.peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precioBase=" + precioBase +
                ", color='" + color + '\'' +
                ", consumo=" + consumo +
                ", peso=" + peso +
                '}';
    }
}
