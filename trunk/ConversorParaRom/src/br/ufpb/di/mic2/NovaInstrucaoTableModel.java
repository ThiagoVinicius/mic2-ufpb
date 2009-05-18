/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Duilio
 */
public class NovaInstrucaoTableModel  extends AbstractTableModel{
 int count;
     String matrixx[][];
     public NovaInstrucaoTableModel(int i,String matrix[][]){
         count  = i;
         matrixx = matrix;
     }
     public int getColumnCount()
        { return 2; }

        public String getColumnName(int index) {
            if(index == 0)
                return "MI";            
        
            else
                return "Código";
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
