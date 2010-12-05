package Reglas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funciones funciones = new Funciones();
        File f = new File("C:\\Archivo2.cpp");
        System.out.println("----------------------------------------------------");
        System.out.println("Documento a evaluar:");
        System.out.println("----------------------------------------------------\n\n\n");
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            char c;
            while (entrada.ready()) {
                linea = entrada.readLine();
                System.out.println(linea);
                funciones.limpiarCodigo(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ArrayList palabras = funciones.getArreglo();
            System.out.println("\n\n\n----------------------------------------------------");
            System.out.println("Ahora se imprime el documento separado:");
            System.out.println("----------------------------------------------------\n\n\n");
            funciones.imprimirPalabras();
            System.out.println("\n\n\n----------------------------------------------------");
            System.out.println("Impresion del numero ciclomático del codigo:");
            System.out.println("----------------------------------------------------\n");
            System.out.println("Numero ciclomático:"+funciones.getNumeroCiclomatico());
            try {
                entrada.close();
            } catch (IOException e1) {
            }
        }
    }
}
