package Ejercicio6;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int MAX_SIZE = 10000;
    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        values = new int[MAX_SIZE];
        priorities = new int[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(int priority, int value) {
        if (count == MAX_SIZE) {
            throw new RuntimeException("Priority queue is full");
        }

        // Búsqueda binaria para encontrar posición o detectar repetido
        int pos = binarySearch(priority);

        if (pos >= 0) {
            throw new RuntimeException("Priority already exists");
        }

        // Posición para insertar (negativa de la búsqueda binaria)
        int insertPos = -pos - 1;

        // Mover elementos para hacer espacio
        for (int i = count; i > insertPos; i--) {
            priorities[i] = priorities[i - 1];
            values[i] = values[i - 1];
        }

        priorities[insertPos] = priority;
        values[insertPos] = value;
        count++;
    }

    // Nuevo método remove que elimina por prioridad usando búsqueda binaria
    public void remove(int priority) {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }

        int pos = binarySearch(priority);

        if (pos < 0) {
            throw new RuntimeException("Priority not found");
        }

        for (int i = pos + 1; i < count; i++) {
            priorities[i - 1] = priorities[i];
            values[i - 1] = values[i];
        }

        count--;
    }

    // Mantengo remove() original para eliminar el primero
    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        // Elimina el primer elemento (menor prioridad)
        for (int i = 1; i < count; i++) {
            priorities[i - 1] = priorities[i];
            values[i - 1] = values[i];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return values[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return priorities[0];
    }

    // Búsqueda binaria sobre priorities
    private int binarySearch(int priority) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midPriority = priorities[mid];

            if (midPriority == priority) {
                return mid;
            } else if (midPriority < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -low - 1;
    }

    public void printState() {
        System.out.print("Contenido: ");
        for (int i = 0; i < count; i++) {
            System.out.print("[P:" + priorities[i] + ", V:" + values[i] + "] ");
        }
        System.out.println();
    }
}
