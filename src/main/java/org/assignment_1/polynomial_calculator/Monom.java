package org.assignment_1.polynomial_calculator;

public class Monom implements Comparable<Monom>{
    private double coefficient;
    private int degree;

    // Constructor fără argumente
    public Monom() {
        this.coefficient = 0.0;
        this.degree = 0;
    }
    public double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }

    // Metoda de comparare pentru a ordona monoamele după grad
    @Override
    public int compareTo(Monom other) {
        return Integer.compare(this.degree, other.degree);
    }

    public String getToStringForCoefficient1(){
        if(this.degree == 0) {
            return "+" + this.coefficient + "";
        }
        else if(this.degree == 1){
            return "+x";
        }
        else if(this.degree > 0){
            return "+x^" + this.degree;
        }
        else{
            return "+x^" + "(" + this.degree + ")";
        }
    }
    public String getToStringForCoefficient2(){
        if(this.degree == 0 ){
            return "+" + this.coefficient;
        }
        else if(this.degree == 1){
            return "+" + this.coefficient + "*x";
        }
        else if (this.degree > 0){
            return "+" + this.coefficient + "*x^" + this.degree;
        }
        else{
            return "+" + this.coefficient + "*x^" + "(" + this.degree + ")";
        }
    }
    public String getToStringForCoefficient3(){
        if(this.degree == 0) {
            return this.coefficient + "";
        }
        else if(this.degree == 1){
            return "-x";
        }
        else if (this.degree > 0){
            return "-x^" + this.degree;
        }
        else{
            return "-x^" + "(" + this.degree + ")";
        }
    }

    public String getToStringForCoefficient4(){
        if(this.degree == 0) {
            return this.coefficient + "";
        }
        else if(this.degree == 1){
            return this.coefficient + "*x";
        }
        else if (this.degree > 0){
            return this.coefficient + "*x^" + this.degree;
        }
        else{
            return this.coefficient + "*x^" + "(" + this.degree + ")";
        }
    }

    public String toString() {
        if(this.coefficient == 1)
        {
            return getToStringForCoefficient1();
        }
        else if(this.coefficient > 0) {
            return getToStringForCoefficient2();
        }
        else if(this.coefficient == -1){
            return getToStringForCoefficient3();
        }
        else if(this.coefficient < 0){
            return getToStringForCoefficient4();
        }
        else {
            return 0 + "";
        }
    }
}
