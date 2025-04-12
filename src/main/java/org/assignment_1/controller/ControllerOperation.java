package org.assignment_1.controller;

import org.assignment_1.exception_package.ExceptionDivide;
import org.assignment_1.gui.PolynomialCalculatorGUI;
import org.assignment_1.polynomial_calculator.Polynomial;
import org.assignment_1.polynomial_calculator.PolynomialOperation;
import org.assignment_1.polynomial_calculator.PolynomialRead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ControllerOperation{

    private PolynomialCalculatorGUI polynomialCalculatorGUI;
    public boolean verifyInput() {
        String polynomialString1 = polynomialCalculatorGUI.poly1TextField.getText();
        String polynomialString2 = polynomialCalculatorGUI.poly2TextField.getText();
        final Pattern pattern = Pattern.compile("[^x0-9+-.\\^]", Pattern.MULTILINE);
        final Matcher matcher1 = pattern.matcher(polynomialString1);
        final Matcher matcher2 = pattern.matcher(polynomialString2);
        boolean ok = true;
        if (matcher1.find()) {
            JOptionPane.showMessageDialog(polynomialCalculatorGUI, "Character invalid for polynomial1!");
            polynomialCalculatorGUI.poly1TextField.setText("");
            polynomialCalculatorGUI.resultTextField.setText("");
            ok = false;
        }
        if (matcher2.find()) {
            JOptionPane.showMessageDialog(polynomialCalculatorGUI, "Character invalid for polynomial2!");
            polynomialCalculatorGUI.poly2TextField.setText("");
            polynomialCalculatorGUI.resultTextField.setText("");
            ok = false;
        }
        return ok;
    }

    public class ValidatorClassEmpty {
        public static int isTextFieldEmpty(JTextField textField, String errorMessage) {
            if (textField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                return 1; // campul este gol
            }
            return 0; //ampul nu este gol
        }
    }

    public void addMessage(String message){
        JOptionPane.showMessageDialog(polynomialCalculatorGUI, message, "Eroare", JOptionPane.ERROR_MESSAGE);
    }

    public ControllerOperation() {

        polynomialCalculatorGUI = new PolynomialCalculatorGUI();
        polynomialCalculatorGUI.setVisible(true); //vizibilitate pe ecran

        //butoanele pentru operatii
        //adunare polinoame
        polynomialCalculatorGUI.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly2TextField, "Please fill in the text field : Polynomial2!") == 1) {
                    ok++;
                }
                if (ok == 1 || ok == 2) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                        polynomialCalculatorGUI.poly2TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString1 = polynomialCalculatorGUI.poly1TextField.getText();
                    String polynomialString2 = polynomialCalculatorGUI.poly2TextField.getText();
                    Polynomial polynomial1 = PolynomialRead.readPolynomial(polynomialString1);
                    Polynomial polynomial2 = PolynomialRead.readPolynomial(polynomialString2);
                    Polynomial polynomial3 = PolynomialOperation.addPolynomial(polynomial1, polynomial2);
                    polynomialCalculatorGUI.resultTextField.setText(polynomial3.toString());
                }
            }
        });

        //scadere polinoame
        polynomialCalculatorGUI.subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly2TextField, "Please fill in the text field : Polynomial2!") == 1) {
                    ok++;
                }
                if (ok == 1 || ok == 2) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                        polynomialCalculatorGUI.poly2TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString1 = polynomialCalculatorGUI.poly1TextField.getText();
                    String polynomialString2 = polynomialCalculatorGUI.poly2TextField.getText();
                    Polynomial polynomial1 = PolynomialRead.readPolynomial(polynomialString1);
                    Polynomial polynomial2 = PolynomialRead.readPolynomial(polynomialString2);
                    Polynomial polynomial3 = PolynomialOperation.subPolynomial(polynomial1, polynomial2);
                    polynomialCalculatorGUI.resultTextField.setText(polynomial3.toString());
                }
            }
        });

        //inmultire polinoame
        polynomialCalculatorGUI.multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly2TextField, "Please fill in the text field : Polynomial2!") == 1) {
                    ok++;
                }
                if (ok == 1 || ok == 2) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                        polynomialCalculatorGUI.poly2TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString1 = polynomialCalculatorGUI.poly1TextField.getText();
                    String polynomialString2 = polynomialCalculatorGUI.poly2TextField.getText();
                    Polynomial polynomial1 = PolynomialRead.readPolynomial(polynomialString1);
                    Polynomial polynomial2 = PolynomialRead.readPolynomial(polynomialString2);
                    Polynomial polynomial3 = PolynomialOperation.mulPolynomial(polynomial1, polynomial2);
                    polynomialCalculatorGUI.resultTextField.setText(polynomial3.toString());
                }
            }
        });

        //impartire polinoame

        polynomialCalculatorGUI.divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly2TextField, "Please fill in the text field : Polynomial2!") == 1) {
                    ok++;
                }
                if (ok == 1 || ok == 2) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                        polynomialCalculatorGUI.poly2TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString1 = polynomialCalculatorGUI.poly1TextField.getText();
                    String polynomialString2 = polynomialCalculatorGUI.poly2TextField.getText();
                    Polynomial polynomial1 = PolynomialRead.readPolynomial(polynomialString1);
                    Polynomial polynomial2 = PolynomialRead.readPolynomial(polynomialString2);
                    String polynomial3 = null;
                    try {
                        polynomial3 = PolynomialOperation.divisionPolynomial(polynomial1, polynomial2);
                    } catch (ExceptionDivide exception) {
                        addMessage("Eroare: " + exception.getMessage());
                        polynomialCalculatorGUI.poly2TextField.setText("");
                    }
                    polynomialCalculatorGUI.resultTextField.setText(polynomial3);
                }
            }
        });

        //derivare pentru un polinom

        polynomialCalculatorGUI.derivativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ok == 1) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString = polynomialCalculatorGUI.poly1TextField.getText();
                    Polynomial polynomial = PolynomialRead.readPolynomial(polynomialString);
                    polynomialCalculatorGUI.resultTextField.setText(PolynomialOperation.derivativePolynomial(polynomial).toString());
                }

            }
        });

        //integrare pentru un polinom
        polynomialCalculatorGUI.integrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = 0;
                if (ValidatorClassEmpty.isTextFieldEmpty(polynomialCalculatorGUI.poly1TextField, "Please fill in the text field : Polynomial1!") == 1) {
                    ok++;
                }
                if (ok == 1) {
                    polynomialCalculatorGUI.resultTextField.setText("");
                    if (!verifyInput()) {
                        polynomialCalculatorGUI.poly1TextField.setText("");
                    }
                } else if (verifyInput()) {
                    String polynomialString = polynomialCalculatorGUI.poly1TextField.getText();
                    Polynomial polynomial = PolynomialRead.readPolynomial(polynomialString);
                    polynomialCalculatorGUI.resultTextField.setText(PolynomialOperation.integratePolynomial(polynomial).toString() + "+C");
                }
            }
        });
    }

}

