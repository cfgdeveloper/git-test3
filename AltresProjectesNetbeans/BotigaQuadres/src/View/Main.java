/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Application.BotigaController;

/**
 *
 * @author formacio
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BotigaController controller = new BotigaController();
        controller.createQuadre("El grito", 999, "Edward Munchie");
        controller.createQuadre("El lienzo en blanco", 39.95, "Manolo Vago");
        controller.createQuadre("El bostezo", 199.90, "Edward Yawn");
        controller.createQuadre("50 sombras de árbol", 199.90, "Félix Rodriguez de la Fuente");
        controller.createQuadre("Cómo programar sin pensar", 99.90, "Clevy Calculus");
        controller.createQuadre("El tostón", 399.90, "Plomo Royo");
        controller.createQuadre("El bodrio más grande jamás pintado", 0.90);
        
        System.out.println(controller.getAllItems());
        
        controller.removeQuadre("El bodrio más grande jamás pintado");
        System.out.println(controller.getAllItems());
        
        /*controller.removeQuadre("CUADRO QUE NO EXISTE NI DE COÑA");
        System.out.println(controller.getAllItems());*/
        
        controller.obliterateBotiga();
        System.out.println(controller.getAllItems());
    }
}
