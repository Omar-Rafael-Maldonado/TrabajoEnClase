/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import java.util.HashMap;
import lista.controlador.Lista;

/**
 *
 * @author Omar Maldonado
 */
public class GrafoEtiquedadoD<E> extends GrafoD {
    // V1    V2   V3   V4   V5   

    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;

    public GrafoEtiquedadoD(Integer numV) {
        super(numV);
        this.etiquetas = (E[]) new Object[numV + 1];
        dicVertices = new HashMap<>(numV);
    }

    public Boolean existeAristaE(E i, E j) {
//        return this.existeArista(numA, numA);
        try {
            return this.existeArista(obtenerCodigo(i), obtenerCodigo(j));
        } catch (Exception e) {
            return false;
        }
    }

    public void insertarAristaE(E i, E j, Double peso) {
        try {
            this.insertarArista(obtenerCodigo(i), obtenerCodigo(j), peso);
        } catch (Exception e) {
            System.out.println("Error en insertar Arista CON peso");
            e.printStackTrace();
        }
    }

    public void insertarAristaE(E i, E j) {
        try {
            this.insertarArista(obtenerCodigo(i), obtenerCodigo(j));
        } catch (Exception e) {
            System.out.println("Error en insertar Arista SIN peso");
            e.printStackTrace();
        }
    }

    public Integer obtenerCodigo(E etiqueta) {
        try {
            return dicVertices.get(etiqueta);
        } catch (Exception e) {
            return -1;
        }
    }

    public Lista<Adyacencia> adyacentesDE(E i) {
        return adyacentes(obtenerCodigo(i));
    }

    public void etiquetaVertice(Integer codigo, E etiqueta) {
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }

    public E obtenerEtiqueta(Integer codigo) {
        return etiquetas[codigo];
    }

    @Override
    public String toString() {
        String grafo = "";
        for (int i = 1; i < numVertices(); i++) {
            grafo += "Vertice " + i + " E (" + obtenerEtiqueta(i).toString() + ")";
            Lista<Adyacencia> lista = adyacentes(i);
            for (int j = 0; j < lista.tamanio(); j++) {
                Adyacencia aux = lista.consultarDatoPosicion(j);
                if (aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                    grafo += " --Vertice destino " + aux.getDestino() + " E (" + obtenerEtiqueta(aux.getDestino()) + ")" + "--SP";
                } else {
                    grafo += " --Vertice destino " + aux.getDestino() + " E (" + obtenerEtiqueta(aux.getDestino()) + ")" + "-- Peso " + aux.getPeso() + "--";
                }
            }
            grafo += "\n";
        }
        return grafo;
    }

}
