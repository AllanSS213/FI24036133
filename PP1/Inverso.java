package com.example;

public class Inverso {
    
    private static int invertirNumero(int numero, int invertido) {
        return numero == 0 ? invertido : 
               invertirNumero(numero / 10, invertido * 10 + numero % 10);
    }
    
    public static int invertirNumero(int numero) {
        return invertirNumero(numero, 0);
    }
    
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese un número natural: ");
            int numero = scanner.nextInt();
            
            if (numero < 0) {
                System.out.println("Número inválido. Debe ser mayor o igual a cero.");
                return;
            }
            
            System.out.println(numero + " - " + invertirNumero(numero));
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número natural válido.");
        }
    }
}