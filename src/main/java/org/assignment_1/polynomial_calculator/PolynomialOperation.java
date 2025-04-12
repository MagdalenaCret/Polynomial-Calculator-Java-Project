package org.assignment_1.polynomial_calculator;

import org.assignment_1.exception_package.ExceptionDivide;

import java.util.Iterator;
import java.util.Set;


public class PolynomialOperation {
    public static Polynomial addPolynomial(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial polynomial3 = new Polynomial();
        for (int degree : polynomial1.getMonoame().keySet()) {
            Monom monom = new Monom();
            Double coefficientPoly1 = polynomial1.getMonoame().get(degree).getCoefficient();
            Double coefficientPoly3 = 0.0;
            if (polynomial2.getMonoame().containsKey(degree)) {
                coefficientPoly3 = coefficientPoly1 + polynomial2.getMonoame().get(degree).getCoefficient();
            } else {
                coefficientPoly3 = coefficientPoly1;
            }
            if (coefficientPoly3 != 0.0) {
                monom.setCoefficient(coefficientPoly3);
                monom.setDegree(degree);
                polynomial3.addMonom(monom);
            }
        }
        for (int degree : polynomial2.getMonoame().keySet()) {
            Monom monom = new Monom();
            if (polynomial1.getMonoame().containsKey(degree) == false) {
                monom.setCoefficient(polynomial2.getMonoame().get(degree).getCoefficient());
                monom.setDegree(polynomial2.getMonoame().get(degree).getDegree());
                polynomial3.addMonom(monom);
            }
        }
        return polynomial3;
    }

    public static Polynomial subPolynomial(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial polynomial2Minus = new Polynomial();
        for (int degree : polynomial2.getMonoame().keySet()) {
            Monom monom = new Monom();
            monom.setDegree(degree);
            monom.setCoefficient(-1 * polynomial2.getMonoame().get(degree).getCoefficient());
            polynomial2Minus.addMonom(monom);
        }
        return PolynomialOperation.addPolynomial(polynomial1, polynomial2Minus);
    }

    public static Polynomial mulPolynomial(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial polynomialF = new Polynomial();
        for (int degree1 : polynomial1.getMonoame().keySet()) {
            Polynomial polynomialInterm = new Polynomial();
            Integer degreeM = polynomial1.getMonoame().get(degree1).getDegree();
            Double coefficientM = polynomial1.getMonoame().get(degree1).getCoefficient();
            for (int degree2 : polynomial2.getMonoame().keySet()) {
                Monom monom = new Monom();
                Integer degreeI = polynomial2.getMonoame().get(degree2).getDegree();
                Integer degrreInterm = degreeM + degreeI;
                Double coefficientI = polynomial2.getMonoame().get(degree2).getCoefficient();
                Double coefficientInterm = coefficientM * coefficientI;

                monom.setDegree(degrreInterm);
                monom.setCoefficient(coefficientInterm);

                polynomialInterm.addMonom(monom);
            }
            polynomialF = PolynomialOperation.addPolynomial(polynomialF, polynomialInterm);
        }
        return polynomialF;
    }

    public static String divisionPolynomial(Polynomial polynomial1, Polynomial polynomial2) throws ExceptionDivide {

        //cazul in care polinomul al doilea are valoarea 0
        if (polynomial2.verifPolynomialEquals0(polynomial2)) {
            throw new ExceptionDivide("--0--The division of polynomials cannot be performed!");
        } else if (Polynomial.calculateDegreePolynomial(polynomial1) < Polynomial.calculateDegreePolynomial(polynomial2)) {
            //cazul cand gradul celui de-al doilea polinom este mai mare decat a primului polinom
            throw new ExceptionDivide("--degree Polynomial 1 < degree Polynomial 2--The division of polynomials cannot be performed!");
        }
        else if(Polynomial.calculateDegreePolynomial(polynomial2) == 0){
            Polynomial catPoly = new Polynomial();
            Polynomial restPoly = new Polynomial();
            for(int degree: polynomial1.getMonoame().keySet())
            {
                Monom monom = new Monom();
                Double coefficientR = polynomial1.getMonoame().get(degree).getCoefficient() / polynomial2.getMonoame().get(0).getCoefficient();
                Integer degreeR = polynomial1.getMonoame().get(degree).getDegree();
                monom.setDegree(degreeR);
                monom.setCoefficient(coefficientR);
                catPoly.addMonom(monom);
            }
            restPoly = PolynomialOperation.subPolynomial(polynomial1, PolynomialOperation.mulPolynomial(catPoly, polynomial2));
            return "Quotient: " + catPoly.toString() + "   Remainder: " + restPoly.toString();
        }
        else {
            Polynomial catPoly = new Polynomial();
            Polynomial restPoly = new Polynomial();
            while (Polynomial.calculateDegreePolynomial(polynomial1) >= Polynomial.calculateDegreePolynomial(polynomial2)) {
                Integer degreePolynomial1 = Polynomial.calculateDegreePolynomial(polynomial1);
                Integer degreePolynomial2 = Polynomial.calculateDegreePolynomial(polynomial2);
                Monom monom = new Monom();
                Integer degreeDiv = degreePolynomial1 - degreePolynomial2;
                Double coefficientDiv = polynomial1.getMonoame().get(degreePolynomial1).getCoefficient() / polynomial2.getMonoame().get(degreePolynomial2).getCoefficient();
                monom.setDegree(degreeDiv);
                monom.setCoefficient(coefficientDiv);
                catPoly.addMonom(monom);

                Polynomial product = new Polynomial();
                for(int degree: polynomial2.getMonoame().keySet()){
                    Monom monomP = new Monom();
                    Integer degreeP=  polynomial2.getMonoame().get(degree).getDegree() + monom.getDegree();
                    Double coefficientP = polynomial2.getMonoame().get(degree).getCoefficient() * monom.getCoefficient();
                    monomP.setDegree(degreeP);
                    monomP.setCoefficient(coefficientP);
                    product.addMonom(monomP);
                }
                polynomial1 = PolynomialOperation.subPolynomial(polynomial1, product);
            }
                restPoly = polynomial1;
                return "Quotient: " + catPoly.toString() + "   Remainder: " + restPoly.toString();
        }
    }

    public static Polynomial derivativePolynomial(Polynomial polynomial) {

        Polynomial polynomialCopy = new Polynomial();
        for (int degree : polynomial.getMonoame().keySet()) {
            Monom monom = new Monom();
            monom.setDegree(degree - 1);
            Double degreeCopy = monom.getDegree() * 0.1;
            monom.setCoefficient(polynomial.getMonoame().get(degree).getCoefficient() * degree);
            polynomialCopy.addMonom(monom);
        }
        return polynomialCopy;
    }

    public static Polynomial integratePolynomial(Polynomial polynomial) {

        Polynomial polynomialCopy = new Polynomial();
        for (int degree : polynomial.getMonoame().keySet()) {
            Monom monom = new Monom();
            monom.setDegree(degree + 1);
            monom.setCoefficient(polynomial.getMonoame().get(degree).getCoefficient() / (degree + 1.0));
            polynomialCopy.addMonom(monom);
        }
        return polynomialCopy;
    }
}
