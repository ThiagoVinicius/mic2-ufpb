/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;

import javax.swing.LookAndFeel;
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


        String defaulLookAndFeel = UIManager.getSystemLookAndFeelClassName();

        try {

            
            UIManager.setLookAndFeel(defaulLookAndFeel);

//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            mf = new ArmdeControleMainFrame();

            mf.lmp.initMatrixMP();

            mf.lmp.initExibicaoPainel();

            mf.initContentPane();
            mf.pack();
            mf.setVisible(true);

        }
        catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro no carregamento do LaF!");
        }
       
    }

}



