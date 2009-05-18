/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processadormic2;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Duilio
 */
public class MicroProgTableModel extends AbstractTableModel {
     int count;
     String matrixx[][];
     public MicroProgTableModel(int i,String matrix[][]){
         count  = i;
         matrixx = matrix;
     }
     public int getColumnCount()
        { return 2; }
        
        public String getColumnName(int index) {
            if (index == 0)
                return "CodHexa";
            else if (index == 1)
                return "MicroInstrução";
            return "ERROR";
        }
        
        public int getRowCount()
        { return count; }
        
        public void atualiza(){
            fireTableStructureChanged();
            fireTableDataChanged();
        }
        public Object getValueAt(int rowIndex, int colIndex) {
           return matrixx[rowIndex][colIndex];
        }
    }
