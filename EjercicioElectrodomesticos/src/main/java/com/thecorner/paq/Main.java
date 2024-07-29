package com.thecorner.paq;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Electrodomestico[] electrodomesticos = new Electrodomestico[3];

        for (int i = 0; i < electrodomesticos.length; i++) {
            System.out.println("Ingrese los detalles para el electrodoméstico " + (i + 1) + ":");
            
            System.out.println("Tipo de electrodoméstico (1: Lavadora, 2: Televisión, 3: General):");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            System.out.print("Ingrese el precio base: ");
            float precioBase = scanner.nextFloat();
            
            System.out.print("Ingrese el color: ");
            scanner.nextLine(); // Consumir el salto de línea
            String color = scanner.nextLine();
            
            System.out.print("Ingrese el consumo energético (A-F): ");
            char consumo = scanner.next().charAt(0);
            
            System.out.print("Ingrese el peso: ");
            float peso = scanner.nextFloat();
            
            if (tipo == 1) { // Lavadora
                System.out.print("Ingrese la carga: ");
                byte carga = scanner.nextByte();
                electrodomesticos[i] = new Lavadora(precioBase, color, consumo, peso, carga);
            } else if (tipo == 2) { // Televisión
                System.out.print("Ingrese la resolución en pulgadas: ");
                int resolucion = scanner.nextInt();
                
                System.out.print("¿Tiene sintonizador TDT? (true/false): ");
                boolean sintonizadorTDT = scanner.nextBoolean();
                
                electrodomesticos[i] = new Television(precioBase, color, consumo, peso, resolucion, sintonizadorTDT);
            } else { // General
                electrodomesticos[i] = new Electrodomestico(precioBase, color, consumo, peso);
            }
        }

        scanner.close();

        // Inicializar contadores de precios
        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisiones = 0;

        // Calcular precios
        for (Electrodomestico e : electrodomesticos) {
            double precio = e.precioFinal();
            totalElectrodomesticos += precio;
            if (e instanceof Lavadora) {
                totalLavadoras += precio;
            } else if (e instanceof Television) {
                totalTelevisiones += precio;
            }
        }

        // Mostrar resultados
        System.out.println("Precio total de Electrodomésticos: " + totalElectrodomesticos);
        System.out.println("Precio total de Lavadoras: " + totalLavadoras);
        System.out.println("Precio total de Televisiones: " + totalTelevisiones);
    }
}

