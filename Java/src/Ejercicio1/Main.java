package Ejercicio1;

import Ejercicio2.PredicateSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 - Pruebas de Predicate");

        Predicate p1 = new AtomicPredicate(3);
        Predicate p2 = new AtomicPredicate(5);

        Predicate and = new BiPredicate(BiPredicateEnum.AND, p1, p2);
        Predicate or = new BiPredicate(BiPredicateEnum.OR, p1, p2);
        Predicate not = new UnitaryPredicate(UnitaryPredicateEnum.NOT, p1);

        System.out.println("AND eval(3): " + and.eval(3));
        System.out.println("OR eval(3): " + or.eval(3));
        System.out.println("NOT eval(3): " + not.eval(3));
        System.out.println("NOT eval(7): " + not.eval(7));
    }
}
