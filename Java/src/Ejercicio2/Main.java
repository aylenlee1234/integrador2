package Ejercicio2;

import Ejercicio1.AtomicPredicate;
import Ejercicio1.BiPredicate;
import Ejercicio1.BiPredicateEnum;
import Ejercicio1.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEjercicio 2 - Pruebas de PredicateSet");

        PredicateSet set = new PredicateSet();
        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println("belongs(20): " + set.belongs(20));
        System.out.println("belongs(5): " + set.belongs(5));

        set.remove(20);
        System.out.println("belongs(20) después de remove: " + set.belongs(20));
        System.out.println("isEmpty(): " + set.isEmpty());
        System.out.println("choose(): " + set.choose());

    }
}
