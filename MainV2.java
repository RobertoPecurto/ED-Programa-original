import java.util.Scanner;

public class MainV2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();

        // Crear un vector para almacenar los números hasta el dato
        int[] primos = generarPrimos(dato);

        //Mostrar el vector inicial
        mostrarVector("Vector inicial hasta " + dato + ":", generarVectorInicial(dato));
        // Mostrar el vector de primos
        mostrarVector("Vector de primos hasta " + dato + ":", primos);
    }

    // Metodo para generar vector inicial
    public static int[] generarVectorInicial(int dato) {
        // Crear un array con tamaño igual al dato
        int[] vector = new int[dato];
        // Llenar array
        for (int i = 0; i < vector.length; i++) {
            vector[i] = i + 1;
        }
        return vector;
    }

    // Método para mostrar vector en pantalla
    public static void mostrarVector(String mensaje, int[] vector) {
        // Imprimir el mensaje indicado
        System.out.println(mensaje);
        // Recorrer e imprimir el vector
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) // Salto cada 10 números
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
        System.out.println(); // Salto de línea final
    }

    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (int i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (int j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }
            // ¿Cuántos primos hay?
            int cuenta = 0;
            for (int i = 0; i < dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }

            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (int i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }
}
