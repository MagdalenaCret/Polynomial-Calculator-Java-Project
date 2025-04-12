package org.assignment_1.polynomial_calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialRead {
    private static final String CONST_REGEX =   "([\\+-]?[1-9]*(\\.[0-9][0-9]*)?x\\^-?[2-9]+)|([\\+-]?[1-9]*(\\.[0-9][0-9]*)?x)|([\\+-]?[0-9]+(\\.[0-9][0-9]*)?)";
    public static Polynomial readPolynomial(String inputPolynomial){
        final Pattern pattern = Pattern.compile(CONST_REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(inputPolynomial);
        Polynomial polynomial = new Polynomial();
        while (matcher.find()) {
            String groupPoly = matcher.group(0);
            Monom monomPoly = new Monom();
            Double coefficient = 0.0;
            Integer degree = 0;
            if(groupPoly.contains("x")) {
                coefficient = getCoefficient(groupPoly);
                if(groupPoly.contains("^")){
                    degree = Integer.parseInt(groupPoly.substring(groupPoly.indexOf("x") + 2));
                }
                else{
                    degree = 1;
                }
            }
            else{
                 coefficient = Double.parseDouble((groupPoly));
                 degree = 0;
            }
            monomPoly.setCoefficient(coefficient);
            monomPoly.setDegree(degree);
            polynomial.addMonom(monomPoly);
        }

        return polynomial;

    }
    public static Double getCoefficient(String groupPoly)
    {
        Double coefficient = 0.0;
        if(groupPoly.substring(0, groupPoly.indexOf("x")).isEmpty()){
            coefficient = 1.0;
        }
        else if(groupPoly.substring(0, groupPoly.indexOf("x")).equals("-"))
        {
            coefficient = -1.0;
        }
        else if(groupPoly.substring(0, groupPoly.indexOf("x")).equals("+"))
        {
            coefficient = 1.0;
        }
        else {
            coefficient = Double.parseDouble(groupPoly.substring(0, groupPoly.indexOf("x")));
        }
        return coefficient;
    }
}
