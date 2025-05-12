/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.primer_codigo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Primer_Codigo {

    static Scanner teclado = new Scanner(System.in);
    static final int MAX = 3;

    public static void main(String[] args) {

        String[] titulo = new String[MAX];
        String[] genero = new String[MAX];
        int[] cantidad = new int[MAX];

        System.out.println("Sistema de control de entradas");
        System.out.println("Accion, entrada = 20");
        System.out.println("Drama, entrada = 15");
        System.out.println("Comedia, entrada = 15");
        System.out.println("Ciencia ficcion, entrada = 20");
        System.out.println("Terror, entrada = 20");
        System.out.println("Fantasia, entrada = 15");
        System.out.println("Musical, entrada = 15");
        System.out.println("Thriller, entrada = 20");
        

        llenado(titulo, genero, cantidad);
        VentasDeEntradas(genero, cantidad);
        TotalDePeliculas(genero, cantidad);
        TotalDePeliculasPorGenero(genero);
    }

    public static void llenado(String titulo[], String genero[], int CantEntradas[]) {

        String[] generosValidos = {"Accion", "Drama", "Comedia", "Ciencia ficcion", "Terror", "Fantasia", "Musical", "Thriller"};
        int i = 0;
        do{
            boolean valido;
            do {
                System.out.print("Ingrese el genero de la pelicula: ");
                genero[i] = teclado.nextLine();
                valido = false;

                for (String g : generosValidos) {
                    if (genero[i].equalsIgnoreCase(g)) {
                        valido = true;
                        break;
                    }
                }

                if (!valido) {
                    System.out.println("Genero invalido. Ingrese nuevamente.");
                }

            } while (!valido);
        

        
            System.out.print("Ingrese el titulo de la pelicula que desea ver: ");
            titulo[i] = teclado.nextLine();
        

       
            do {
                System.out.print("Ingrese la cantidad de entradas (1 a 50): ");
                CantEntradas[i] = teclado.nextInt();
                teclado.nextLine();

                if (CantEntradas[i] <= 0 || CantEntradas[i] > 51) {
                    System.out.println("Cantidad invalida. Debe estar entre 1 y 50.");
                }
            } while (CantEntradas[i] <= 0 || CantEntradas[i] > 51);
            i++;
        }while(i < MAX);
    }

    public static void VentasDeEntradas(String genero[], int cant[]) {
        
         Map<String, Integer> precio = new HashMap<>();
         
         precio.put("accion" , 20);
         precio.put("comedia" , 15);
         precio.put("drama" , 15);
         precio.put("ciencia ficcion" , 20);
         precio.put("terror", 20);
         precio.put("fantasia" , 15);
         precio.put("musical" , 15);
         precio.put("thriller", 20);
         
         for (int i = 0; i < MAX; i++) {
             
             String entrada = genero[i].toLowerCase();
             
             if(precio.containsKey(entrada)){
                 
                 int preciof = precio.get(entrada) * cant[i];
                 System.out.println("El precio que debe pagar la persona " + (i + 1) + " es de " + preciof + " soles");
                } else {
                        System.out.println("Genero no disponible: " + genero[i]);
                    }
          }
    }

    public static void TotalDePeliculas(String genero[], int cantidad[]) {
    
    Map<String, Integer> precio = new HashMap<>();
    precio.put("accion", 20);
    precio.put("comedia", 15);
    precio.put("drama", 15);
    precio.put("ciencia ficcion", 20);
    precio.put("terror", 20);
    precio.put("fantasia", 15);
    precio.put("musical", 15);
    precio.put("thriller", 20);

    int total = 0;
    
    
    for (int i = 0; i < MAX; i++) {
        String entrada = genero[i].toLowerCase();

        
        if (precio.containsKey(entrada)) {
            int preciof = precio.get(entrada) * cantidad[i];
            total += preciof;
        } else {
            System.out.println("Género no disponible: " + genero[i]);
        }
    }
    System.out.println("El total obtenido por todas las peliculas es: " + total + " soles.");
}
    public static void TotalDePeliculasPorGenero(String genero[]) {
    
    Map<String, Integer> contadorGeneros = new HashMap<>();

    
    contadorGeneros.put("accion", 0);
    contadorGeneros.put("comedia", 0);
    contadorGeneros.put("drama", 0);
    contadorGeneros.put("ciencia ficcion", 0);
    contadorGeneros.put("terror", 0);
    contadorGeneros.put("fantasia", 0);
    contadorGeneros.put("musical", 0);
    contadorGeneros.put("thriller", 0);

    
    for (int i = 0; i < MAX; i++) {
        String entrada = genero[i].toLowerCase(); // Convertir el género a minúsculas

        
        if (contadorGeneros.containsKey(entrada)) {
            
            contadorGeneros.put(entrada, contadorGeneros.get(entrada) + 1);
        } else {
            System.out.println("Genero no válido: " + genero[i]);
        }
    }

    
    for (Map.Entry<String, Integer> entry : contadorGeneros.entrySet()) {
        System.out.println("Peliculas vistas del genero " + entry.getKey() + ": " + entry.getValue());
    }
}
}