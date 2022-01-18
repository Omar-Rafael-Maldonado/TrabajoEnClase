package vista.ejemplo1.modeloTabla;

import controlador.grafo.GrafoD;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Maldonado
 */
public class ModeloTabla1 extends AbstractTableModel{
    private GrafoD grafoD;
    private String[] columnas;

    public GrafoD getGrafoD() {
        generarColumnas();
        return grafoD;
    }

    public void setGrafoD(GrafoD grafoD) {
        this.grafoD = grafoD;
        generarColumnas();
    }
    
    @Override
    public int getRowCount() {
        return grafoD.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafoD.numVertices() + 1 ;
    }
    
    private String[] generarColumnas(){
        columnas = new String[grafoD.numVertices() + 1];
        columnas[0] ="";
        for (int i = 0; i < columnas.length; i++) {
            columnas[i] = String.valueOf(i);
        }
        return columnas;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        if (i1 == 0) {
            return columnas[i+1];
        }else{
            try {
                if (grafoD.existeArista(i+1, i1)) {
                    return "OK";
                }else{
                    return "--";
                }
            } catch (Exception e) {
                System.out.println("Error en ver la arista");
            }
        }
        return "";
    }
}
