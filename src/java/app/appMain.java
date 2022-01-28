/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Model.Conexion;

/**
 *
 * @author windows
 */
public class appMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String conectar = con.consume();
        System.out.println(conectar);
    }
    
}
