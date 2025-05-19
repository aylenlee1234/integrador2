package Ejercicio3;

import Ejercicio1.*;

public class PredicateOptimizer {

    public static Predicate optimize(Predicate p) {
        if (p instanceof UnitaryPredicate) {
            UnitaryPredicate up = (UnitaryPredicate) p;
            Predicate operand = up.getOperand();

            // ¬(¬A) = A
            if (up.getType() == UnitaryPredicateEnum.NOT &&
                    operand instanceof UnitaryPredicate &&
                    ((UnitaryPredicate) operand).getType() == UnitaryPredicateEnum.NOT) {
                return optimize(((UnitaryPredicate) operand).getOperand());
            }

            return new UnitaryPredicate(up.getType(), optimize(operand));

        } else if (p instanceof BiPredicate) {
            BiPredicate bp = (BiPredicate) p;
            Predicate left = optimize(bp.getLeft());
            Predicate right = optimize(bp.getRight());

            // A ∪ A = A o A ∩ A = A
            if (left.equals(right)) {
                return left;
            }

            // A ∩ ∅ = ∅
            if (bp.getType() == BiPredicateEnum.AND &&
                    (isEmpty(left) || isEmpty(right))) {
                return new BiPredicate(BiPredicateEnum.AND, left, right);
            }

            // A ∪ ∅ = A
            if (bp.getType() == BiPredicateEnum.OR) {
                if (isEmpty(left)) return right;
                if (isEmpty(right)) return left;
            }

            return new BiPredicate(bp.getType(), left, right);
        }

        return p;
    }

    private static boolean isEmpty(Predicate p) {
        for (int i = 0; i < 1000; i++) {
            if (p.eval(i)) return false;
        }
        return true;
    }
}
