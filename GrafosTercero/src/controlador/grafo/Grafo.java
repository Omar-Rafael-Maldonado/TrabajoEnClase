package controlador.grafo;

import lista.controlador.Lista;

/**
 *
 * @author Omar Maldonado
 */
public abstract class Grafo {

    public abstract Integer numVertices();
    /**
     * Es el numero de aristas del grafo
     *
     * @return Integer numero de aristas
     */
    public abstract Integer numAristas();
    /**
     * Permite ver si entre dos nodos hay conexion (arista)
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @return true si estan conectados
     * @throws Exception Excepcion
     */
    public abstract Boolean existeArista(Integer i, Integer j) throws Exception;
    /**
     * Retorna el peso que hay entre dos vertices
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @return Double peso de la arista
     */
    public abstract Double pesoArista(Integer i, Integer j);
    /**
     * Permite insertar arista sin peso
     *
     * @param i Nodo incial
     * @param j Nodo final
     */

    public abstract void insertarArista(Integer i, Integer j);
    /**
     * Permite insertar arista con peso
     *
     * @param i Nodo incial
     * @param j Nodo final
     * @param peso peso de la arista
     */

    public abstract void insertarArista(Integer i, Integer j, Double peso);
    /**
     * Listado de adycencias de un nodo
     *
     * @param i Nodo a listar sus adyacencias
     * @return Lista
     */

    public abstract Lista<Adyacencia> adyacentes(Integer i);

    @Override
    public String toString() {
        String grafo = "";
        for (int i = 1; i < numVertices(); i++) {
            grafo += "Vertice " + i;
            Lista<Adyacencia> lista = adyacentes(i);
            for (int j = 0; j < lista.tamanio(); j++) {
                Adyacencia aux = lista.consultarDatoPosicion(j);
                if (aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                    grafo += " --Vertice destino " + aux.getDestino() + "--SP";
                } else {
                    grafo += " --Vertice destino " + aux.getDestino() + "-- Peso " + aux.getPeso() + "--";
                }
            }
            grafo += "\n";
        }
        return grafo;
    }

}
