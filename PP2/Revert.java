import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Revert {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        Stack<Character> stack = new Stack<>();

        try (FileReader reader = new FileReader(inputFile)) {
            int data;
            while ((data = reader.read()) != -1) {
                stack.push((char) data);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            while (!stack.isEmpty()) {
                writer.write(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
            return;
        }

        System.out.println("Archivo invertido creado exitosamente en " + outputFile);
    }
}

