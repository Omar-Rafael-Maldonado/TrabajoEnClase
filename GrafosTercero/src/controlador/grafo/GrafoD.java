/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import lista.controlador.Lista;

/**
 *
 * @author Omar Maldonado
 */
public class GrafoD extends Grafo {

    private Integer numV;
    protected Integer numA;
    protected Lista<Adyacencia> listaAdyacente[];

    public GrafoD(Integer numV) {
        this.numV = numV;
        numA = 0;
        listaAdyacente = new Lista[numVertices() + 1];
        for (int i = 0; i <= this.numV; i++) {
            listaAdyacente[i] = new Lista<>();
        }
    }

    @Override
    public Integer numVertices() {
        return this.numV;
    }

    @Override
    public Integer numAristas() {
        return this.numA;
    }

    @Override
    public Boolean existeArista(Integer i, Integer j) throws Exception {
        Boolean esta = false;
        if (i.intValue() <= numV && j.intValue() <= numV) {
            Lista<Adyacencia> lista_adyacentes = listaAdyacente[i];
            for (int k = 0; k < lista_adyacentes.tamanio(); k++) {
                Adyacencia aux = lista_adyacentes.consultarDatoPosicion(k);
                if (aux.getDestino().intValue() == j.intValue()) {
                    esta = true;
                    break;
                }
            }
        }
        return esta;
    }

    @Override
    public Double pesoArista(Integer i, Integer j) {
        Double peso = Double.NaN;
        try {
            if (existeArista(i, j)) {
                Lista<Adyacencia> adyacentes = listaAdyacente[i];
                for (int k = 0; k < adyacentes.tamanio(); k++) {
                    Adyacencia aux = adyacentes.consultarDatoPosicion(k);
                    if (aux.getDestino().intValue() == j.intValue()) {
                        peso = aux.getPeso();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("no se puede encontrar el dato");
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer i, Integer j) {
        insertarArista(i, j, Double.NaN);
    }

    @Override
    public void insertarArista(Integer i, Integer j, Double peso) {
        try {
            if (i.intValue() <= numV && j.intValue() <= numV) {
                if (!existeArista(i, j)) {
                    numA++;
                    listaAdyacente[i].insertarNodo(new Adyacencia(j, peso));
                }
            }
        } catch (Exception e) {
            System.out.println("Error en insertarArista");
        }
    }

    @Override
    public Lista<Adyacencia> adyacentes(Integer i) {
        return listaAdyacente[i];
    }

}
