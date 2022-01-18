/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controlador.grafo.GrafoD;
import controlador.grafo.GrafoEtiquedadoD;
import controlador.grafo.GrafoND;
import controlador.grafo.GrafoEtiquetadoND;

/**
 *
 * @author Omar Maldonado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // V1 ---- 3 4
        // V2 ----- 1
        // v3 ------
        // V4 ------ V3
        // V5 ------ V2
//        GrafoND grafoD = new GrafoND(5);
//        grafoD.insertarArista(1, 3);
//        grafoD.insertarArista(2, 1);
//        grafoD.insertarArista(4, 3);
//        grafoD.insertarArista(4, 5);
//        grafoD.insertarArista(5, 2);
//        System.out.println(grafoD.toString());
//        grafoD.existeArista(Integer.SIZE, Integer.SIZE)
//        GrafoEtiquedadoD ged = new GrafoEtiquedadoD(5);

        GrafoEtiquetadoND ged = new GrafoEtiquetadoND(5);
        ged.etiquetaVertice(1, "Alba");
        ged.etiquetaVertice(2, "Nayeli");
        ged.etiquetaVertice(3, "Oscar");
        ged.etiquetaVertice(4, "Sandra");
        ged.etiquetaVertice(5, "Luis");
        
        ged.insertarAristaE(ged.obtenerEtiqueta(1), ged.obtenerEtiqueta(2), 100.00);
        ged.insertarAristaE(ged.obtenerEtiqueta(3), ged.obtenerEtiqueta(1), 25.00);
        ged.insertarAristaE(ged.obtenerEtiqueta(4), ged.obtenerEtiqueta(5), 0.00);
        
        System.out.println(ged.toString());
    }

}
