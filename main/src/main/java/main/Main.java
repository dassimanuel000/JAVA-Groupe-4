/**

 * @author Groupe 4
 * @version 3.0
 */
package main;

import controllergrp4.ControllerGRP4;
import modelgrp4.ModelGRP4;
import viewgrp4.ViewGRP4;

/**
 * The Class Main.
 *
 * @author Groupe 4
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final ModelGRP4 model = new ModelGRP4();
        final ViewGRP4 view = new ViewGRP4(model);
        final ControllerGRP4 controller = new ControllerGRP4(view, model);
        view.setController(controller);
        controller.control();
    }
}
