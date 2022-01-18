/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

/**
 *
 * @author Omar Maldonado
 */
public class GrafoND extends GrafoD {

    public GrafoND(Integer numV) {
        super(numV);
    }

    @Override
    public void insertarArista(Integer i, Integer j, Double peso) {
        try {
            if (i.intValue() <= numVertices()&& j.intValue() <= numVertices()) {
                if (!existeArista(i, j)) {
                    numA++;
                    listaAdyacente[i].insertarNodo(new Adyacencia(j, peso));
                    listaAdyacente[j].insertarNodo(new Adyacencia(j, peso));
                }
            }
        } catch (Exception e) {
            System.out.println("Error en insertar GND");
        }
    }

}
