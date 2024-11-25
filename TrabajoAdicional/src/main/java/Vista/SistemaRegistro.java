/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
import java.util.Scanner;

/**
 *
 * @author Laura
 */
public class SistemaRegistro {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaRegistro sistema = new SistemaRegistro();
        sistema.menu();
    }

    private void menu() {
        int opcion;

        do {
            System.out.println("1. Agregar Lenguaje");
            System.out.println("2. Buscar Lenguaje");
            System.out.println("3. Eliminar Lenguaje");
            System.out.println("4. Mostrar Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    agregarLenguaje();
                case 2 ->
                    buscarLenguaje();
                case 3 ->
                    eliminarLenguaje();
                case 4 ->
                    GestionLenguaje.imprimirLenguajes();
                case 5 ->
                    System.out.println("Saliendo");
                default ->
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public void agregarLenguaje() {
        System.out.print("Anio de creacion: ");
        int anioCreacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Caracteristica principal: ");
        String caracteristicaPrincipal = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Utilizacion: ");
        String utilizacion = scanner.nextLine();

        GestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado con exito.");
    }

    public void buscarLenguaje() {
        System.out.print("Ingrese el nombre del lenguaje: ");
        String nombre = scanner.nextLine();

        if (GestionLenguaje.buscarLenguaje(nombre) != null) {
            System.out.println("Lenguaje encontrado: " + GestionLenguaje.buscarLenguaje(nombre));
        } else {
            System.out.println("Lenguaje no encontrado.");
        }
    }

    public void eliminarLenguaje() {
        System.out.print("Ingrese el nombre del lenguaje: ");
        String nombre = scanner.nextLine();

        if (GestionLenguaje.eliminarLenguaje(nombre)) {
            System.out.println("Lenguaje eliminado con exito.");
        } else {
            System.out.println("Lenguaje no encontrado.");
        }
    }
}
