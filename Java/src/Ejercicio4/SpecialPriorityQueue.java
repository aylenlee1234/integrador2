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

    public boolean existsPeak() {
        for (int i = 1; i < count - 1; i++) {
            if (values[i] > values[i - 1] && values[i] > values[i + 1]) {
                return true;
            }
        }
        return false;
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
