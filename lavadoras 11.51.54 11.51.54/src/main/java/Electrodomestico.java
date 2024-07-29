
package com.thecornet.lavadoras;

public class Electrodomestico {
    private float precioBase;
    private String color;
    private char consumo;
    private float peso;
    

   public Electrodomestico(float precioBase, String color, char consumo, float peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

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
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
// Método comprobarConsumoEnergetico
    private char comprobarConsumoEnergetico(char letra) {
        char[] letrasValidas = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char c : letrasValidas) {
            if (Character.toUpperCase(letra) == c) {
                return letra;
            }
        }
        return 'F'; // Si la letra no es válida, se usa la letra F por defecto
    }

    // Método comprobarColor
    private String comprobarColor(String color) {
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};
        for (String c : coloresValidos) {
            if (color.equalsIgnoreCase(c)) {
                return c;
            }
        }
        return "blanco"; // Si el color no es válido, se usa el color blanco por defecto
    }

    // Método precioFinal
    public double precioFinal() {
        double precioFinal = this.precioBase;

        switch (this.consumoEnergetico) {
            case 'A':
                precioFinal += 1000;
                break;
            case 'B':
                precioFinal += 2000;
                break;
            // Agregar los casos para las demás letras de consumo energético si es necesario
        }

        if (this.peso >= 1 && this.peso <= 19) {
            precioFinal += 100;
        } else if (this.peso >= 20 && this.peso <= 29) {
            precioFinal += 200;
        }
        // Agregar más condiciones según la tabla de precios

        return precioFinal;
    }
}
    @Override
    public String toString() {
        return "Electrodomestico{" + "precioBase=" + precioBase + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso + '}';
    }
   
}
