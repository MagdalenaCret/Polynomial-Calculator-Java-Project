package org.assignment_1.polynomial_calculator;
import java.util.*;

public class Polynomial {
    private Map<Integer, Monom> monoame = new TreeMap<Integer, Monom>(Collections.reverseOrder()); // Mapa pentru stocarea monoamelor, sortate după grad

    public Polynomial() {
        // Constructor pentru inițializarea unui obiect Polinom
    }

    // Metodă pentru adăugarea unui monom la polinom
    public void addMonom(Monom monom) {
        monoame.put(monom.getDegree(), monom); // Se adaugă monomul în mapa, folosind gradul monomului ca si cheie
    }

    public Map<Integer, Monom> getMonoame() {
        return monoame;
    }

    @Override
    public String toString() {
        // Metoda toString() pentru afișarea polinomului sub formă de șir de caractere(
        String polynomial = "";
        for (Monom indexMonom : monoame.values()) {
            if (indexMonom.getCoefficient() != 0) {
                polynomial = polynomial + indexMonom.toString();
            }
        }
        if (polynomial.isEmpty()) {
            return 0 + "";
        }
        if (polynomial.substring(0, 1).equals("+")) {
            polynomial = polynomial.substring(1);
            return polynomial;
        }
        return polynomial;
    }

    public static Integer calculateDegreePolynomial(Polynomial polynomial) {
        Integer polyDegree = 0;
        for (int degree : polynomial.getMonoame().keySet()) {
            if (polynomial.getMonoame().get(degree).getDegree() >= polyDegree) {
                polyDegree = polynomial.getMonoame().get(degree).getDegree();
            }
        }
        return polyDegree;
    }

    public boolean verifPolynomialEquals0(Polynomial polynomial) {
        boolean verif0Pol = false;

        int numberVerif = 0;
        for (int degree : polynomial.getMonoame().keySet()) {
            if (polynomial.getMonoame().get(degree).getCoefficient() != 0) {
                numberVerif++;
            }
        }
        if (numberVerif == 0) {
            verif0Pol = true;
        }
        return verif0Pol;
    }
}

