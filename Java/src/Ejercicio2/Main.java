package Ejercicio2;

import Ejercicio1.AtomicPredicate;
import Ejercicio1.BiPredicate;
import Ejercicio1.BiPredicateEnum;
import Ejercicio1.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate p = new AtomicPredicate(3); // conjunto {3}
        Predicate p2 = new AtomicPredicate(5); // conjunto {5}
        Predicate union = new BiPredicate(BiPredicateEnum.OR, p, p2); // {3, 5}
        PredicateSetttt set = new PredicateSetttt(union);

        System.out.println(set.contains(3));  // true
        System.out.println(set.contains(4));  // false
        System.out.println(set.isEmpty());    // false
        System.out.println(set.choose());     // 3 o 5
    }
}
