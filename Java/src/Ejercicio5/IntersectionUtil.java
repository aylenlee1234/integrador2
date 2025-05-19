package Ejercicio5;

import Ejercicio2.PredicateSet;
import Ejercicio4.SpecialPriorityQueue;

public class IntersectionUtil {

    public static PredicateSet intersectionPrioritiesAndValues(SpecialPriorityQueue q) {
        PredicateSet result = new PredicateSet();
        PredicateSet priorities = new PredicateSet();
        PredicateSet values = new PredicateSet();

        for (int i = 0; i < q.size(); i++) {
            priorities.add(q.getKey(i));
            values.add(q.getValue(i));
        }

        for (int i = 0; i < 1000; i++) {
            if (priorities.belongs(i) && values.belongs(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
