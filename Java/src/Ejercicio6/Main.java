package Ejercicio6;

public class Main {
    public static void main(String[] args) {
        StaticPriorityQueue queue = new StaticPriorityQueue();

        try {
            // Agregar elementos con prioridades distintas
            queue.add(10, 100);
            queue.add(5, 200);
            queue.add(15, 300);

            System.out.println("Cola despues de agregar 3 elementos:");
            queue.printState();

            // Intentar agregar con prioridad repetida
            System.out.println("Intentando agregar prioridad repetida (10):");
            queue.add(10, 999); // debe tirar error
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Obtener primero
        System.out.println("Primer valor: " + queue.getFirst());
        System.out.println("Prioridad del primero: " + queue.getPriority());

        // Eliminar elemento con prioridad específica
        System.out.println("Eliminando elemento con prioridad 5");
        queue.remove(5);
        queue.printState();

        // Eliminar el primero (mínima prioridad actual)
        System.out.println("Eliminando primer elemento (por orden)");
        queue.remove();
        queue.printState();

        // Estado final
        System.out.println("Estado final de la cola:");
        queue.printState();
    }
}