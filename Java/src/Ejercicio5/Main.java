package Ejercicio5;

import Ejercicio2.PredicateSet;
import Ejercicio4.SpecialPriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEjercicio 5 - Intersección entre prioridades y valores");

        SpecialPriorityQueue q5 = new SpecialPriorityQueue(10);
        q5.add(1, 3);
        q5.add(2, 2);
        q5.add(3, 3);
        q5.add(4, 1);
        q5.add(5, 5);
        q5.add(6, 6);

        System.out.print("Prioridades: ");
        for (int i = 0; i < q5.size(); i++) {
            System.out.print(q5.getKey(i) + " ");
        }
        System.out.println();

        System.out.print("Valores: ");
        for (int i = 0; i < q5.size(); i++) {
            System.out.print(q5.getValue(i) + " ");
        }
        System.out.println();

        PredicateSet intersec = IntersectionUtil.intersectionPrioritiesAndValues(q5);
        System.out.print("Intersección: ");
        for (int i = 0; i < 1000; i++) {
            if (intersec.belongs(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

}
