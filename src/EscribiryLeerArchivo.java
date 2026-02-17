import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribiryLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "nombres.txt";
        String[] nombres = {"Ana", "Juan", "Pedro", "Lucía", "Carlos", "Jose"};

        //Escribimos en el archivo

        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            for (String nombre : nombres) {
                escritor.write(nombre + " ");
            }
            System.out.println("Archivo '" + nombreArchivo + "' creado.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        // leemos el archivo
        System.out.println("Leyendo el archivo:");

        try (Scanner lector = new Scanner(new File(nombreArchivo))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println("- " + linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
