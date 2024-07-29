package com.thecorner.paq;

public class Lavadora extends Electrodomestico {

    private static final byte CARGA_DEFECTO = 5; // Valor por defecto para carga

    private byte carga;

    // Constructor por defecto
    public Lavadora() {

    }

    // Constructor con precioBase y peso
    public Lavadora(float precioBase, float peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEFECTO;
    }

    // Constructor con todos los atributos
    public Lavadora(float precioBase, String color, char consumo, float peso, byte carga) {
        super(precioBase, color, consumo, peso);
        this.carga = carga;
    }

    public byte getCarga() {
        return carga;
    }

    public void setCarga(byte carga) {
        this.carga = carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal(); // Llama al método de la superclase

        // Ajusta el precio basado en la carga
        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Lavadora{" +
                "precioBase=" + getPrecioBase() +
                ", color='" + getColor() + '\'' +
                ", consumo=" + getConsumo() +
                ", peso=" + getPeso() +
                ", carga=" + carga +
                '}';
    }
}
