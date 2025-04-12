package org.assignment_1;

import org.assignment_1.controller.ControllerOperation;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ControllerOperation();
            }
        });
    }
}
