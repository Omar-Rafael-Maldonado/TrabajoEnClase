/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ejercicio1;

import controlador.grafo.GrafoD;

/**
 *
 * @author Omar Maldonado
 */
public class Ejercicio1Controller {
    private GrafoD grafoD;

    public Ejercicio1Controller(Integer nroVer) {
        grafoD = new GrafoD(nroVer);
    }

    public GrafoD getGrafoD() {
        return grafoD;
    }

    public void setGrafoD(GrafoD grafoD) {
        this.grafoD = grafoD;
    }
    
    
    
}
