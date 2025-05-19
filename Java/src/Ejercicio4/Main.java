package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEjercicio 4 - SpecialPriorityQueue y picos");

        SpecialPriorityQueue spq = new SpecialPriorityQueue(20);
        int[] entrada = {1, 2, 3, 4, 3, 2, 4, 6, 9, 8};

        for (int i = 0; i < entrada.length; i++) {
            spq.add(i, entrada[i]);
        }

        System.out.print("Valores: ");
        spq.printValues();

        System.out.println("Todos los picos: (complejidad O(n))");
        boolean hayPico = spq.existsPeak();
        System.out.println();

        System.out.println("Todos los picos en binario: (complejidad O(log n))");
        boolean hayPicoConBinario = spq.existsPeakBinary();
        System.out.println("¿Hay picos?: " + hayPico);
    }
}
