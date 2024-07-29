package com.thecorner.paq;

public class Television extends Electrodomestico {

    private static final int RESOLUCION_DEFECTO = 20; // Valor por defecto para resolución
    private static final boolean SINTONIZADOR_TDT_DEFECTO = false; // Valor por defecto para sintonizador TDT

    private int resolucion;
    private boolean sintonizadorTDT;

    // Constructor por defecto
    public Television() {
        this(RESOLUCION_DEFECTO, SINTONIZADOR_TDT_DEFECTO); // Llama al constructor con valores predeterminados
    }

    // Constructor con precioBase y peso
    public Television(float precioBase, float peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;
    }

    // Constructor con todos los atributos
    public Television(float precioBase, String color, char consumo, float peso, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    private Television(int RESOLUCION_DEFECTO, boolean SINTONIZADOR_TDT_DEFECTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal(); // Llama al método de la superclase

        // Ajuste basado en la resolución
        if (resolucion > 40) {
            precioFinal *= 1.30; // Aumenta el precio en un 30%
        }

        // Ajuste basado en la presencia del sintonizador TDT
        if (sintonizadorTDT) {
            precioFinal += 50; // Aumenta el precio en 50 € si tiene sintonizador TDT
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Television{" +
                "precioBase=" + getPrecioBase() +
                ", color='" + getColor() + '\'' +
                ", consumo=" + getConsumo() +
                ", peso=" + getPeso() +
                ", resolucion=" + resolucion +
                ", sintonizadorTDT=" + sintonizadorTDT +
                '}';
    }
}
