
package Formulario.Medico;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer {

    @Override                                  // (JTable table, Object value,  boolean isSelected, boolean hasFocus, int row, int column     
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (value instanceof JButton) { //if el dato q le asignamos es un boton
            JButton btn = (JButton) value; //agrego el boton
            return btn;     //AGREGA BOTON A LA TABLA (retorno el boton)
        }
        
        return super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
