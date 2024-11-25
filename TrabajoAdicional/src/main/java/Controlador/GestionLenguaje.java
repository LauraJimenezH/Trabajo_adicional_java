/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LenguajeProgramacion;

/**
 *
 * @author Laura
 */
public class GestionLenguaje {

    private static int contadorLenguajes = 0; 
    private static final int FACTOR_CRECIMIENTO = 2;
    private static LenguajeProgramacion[] arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];

    public static void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length + FACTOR_CRECIMIENTO];
            System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
            arregloLenguajes = nuevoArreglo;
        }
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    public static LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }

    public static boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                arregloLenguajes[i] = arregloLenguajes[--contadorLenguajes];
                arregloLenguajes[contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    public static LenguajeProgramacion[] getArregloLenguajes() {
        LenguajeProgramacion[] lenguajes = new LenguajeProgramacion[contadorLenguajes];
        System.arraycopy(arregloLenguajes, 0, lenguajes, 0, contadorLenguajes);
        return lenguajes;
    }

    public static void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i]);
        }
    }
}
