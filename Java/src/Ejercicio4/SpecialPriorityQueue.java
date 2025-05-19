package Ejercicio4;

public class SpecialPriorityQueue {
    private int[] keys;
    private int[] values;
    private int count;
    private int maxSize;

    public SpecialPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        keys = new int[maxSize];
        values = new int[maxSize];
        count = 0;
    }

    public void add(int key, int value) {
        if (count >= maxSize) {
            throw new RuntimeException("Cola llena");
        }

        int i = count - 1;

        // Insertamos ordenado por key (prioridad ascendente)
        while (i >= 0 && keys[i] > key) {
            keys[i + 1] = keys[i];
            values[i + 1] = values[i];
            i--;
        }

        keys[i + 1] = key;
        values[i + 1] = value;
        count++;
    }

    // Busca todos los picos: Complejidad O(n)
    public boolean existsPeak() {
        boolean existsPeak = false;
        for (int i = 1; i < count - 1; i++) {
            if (values[i] > values[i - 1] && values[i] > values[i + 1]) {
                System.out.println("Hay un pico: " + values[i]);
                existsPeak = true;
            }
        }
        return existsPeak;
    }

    // Busca el primer pico con busqueda binaria: Complejidad O(log n)
    public boolean existsPeakBinary() {
        if (count < 3) return false;
        return findPeak(1, count - 2);
    }

    private boolean findPeak(int left, int right) {
        if (left > right) return false;

        int mid = (left + right) / 2;

        if (values[mid] > values[mid - 1] && values[mid] > values[mid + 1]) {
            System.out.println("Hay un pico: " + values[mid]);
            return true;
        }

        if (values[mid - 1] > values[mid]) {
            return findPeak(left, mid - 1);
        } else {
            return findPeak(mid + 1, right);
        }
    }

    public void printValues() {
        for (int i = 0; i < count; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return count;
    }

    public int getKey(int i) {
        return keys[i];
    }

    public int getValue(int i) {
        return values[i];
    }
}
