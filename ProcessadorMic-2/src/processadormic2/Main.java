/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processadormic2;

import javax.swing.UIManager;

/**
 *
 * @author Duilio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    
    public static ArmdeControleMainFrame mf;
    public static void main(String[] args) {


        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
             mf = new ArmdeControleMainFrame();

            mf.lmp.initMatrixMP();

            mf.lmp.initExibicaoPainel();

            mf.initContentPane();
            mf.setVisible(true);

        }
        catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro no carregamento do LaF!");
        }
       
    }

}



