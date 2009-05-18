/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Duilio
 */
public class LerMicroProg {

    Scanner strEntrada;
    InstructionRecord record = new InstructionRecord();
    
    Converter cv = new Converter();
     
     
     MapaRecord  record2 = new MapaRecord();
     
     String matrix[][] ;
    public JPanel contentpanel;
    JPanel microprogPanel;
    MicroProgTableModel model;
    JTable  microprogTable;
     
    
    
    public void initMatrixMP(){
        matrix = new String [512][2];
        int j = 0;
        try {
            strEntrada = new Scanner(new File("microprog.txt"));
        } catch (FileNotFoundException ex) {
           
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao tentar abrir o arquivo microprog.txt.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }
        try{
            while(strEntrada.hasNext()){
                record.setMicroCodigo(strEntrada.next());
                matrix[j][0]="      0x"+cv.DectoHexa(j);
                matrix[j][1]="         "+record.getMicroCodigo();
                j++;
               
            }
            
        }
        catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo4.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }
        strEntrada.close();
    }
    
    
    public void initExibicaoPainel(){
        
        
       contentpanel =  new javax.swing.JPanel(new BorderLayout());
        microprogPanel = new JPanel(new BorderLayout());
         microprogPanel.setPreferredSize(new Dimension(550,405));
        model = new MicroProgTableModel(512,matrix);
        microprogTable = new JTable(model);
        
        microprogTable.setColumnSelectionAllowed(false);
        microprogTable.setRowSelectionAllowed(false);
        
            microprogTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            microprogTable.getColumnModel().getColumn(1).setPreferredWidth(350);
       
        
        microprogPanel .add(new JScrollPane(microprogTable), BorderLayout.CENTER);
        
        contentpanel.add(microprogPanel, BorderLayout.NORTH);
        
       
    }
    
    
    public void ExecutaBusca(int cd, int nmi){
        try {
            strEntrada = new Scanner(new File("microprog.txt"));
        } catch (FileNotFoundException ex) {
             javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }
        
       
       int count = 0;
       
        try{
            while(count <= cd){
                strEntrada.hasNext();
                record.setMicroCodigo(strEntrada.next());
                count++;
            }//ja li a  primeira
            
                        
            Main.mf.jTextArea2.setText("       "+record.getMicroCodigo()+"\n");
            count = 0;
            while(count<nmi-1){
                strEntrada.hasNext();
                record.setMicroCodigo(strEntrada.next());            
                Main.mf.jTextArea2.setText(Main.mf.jTextArea2.getText()+"       "+record.getMicroCodigo()+"\n");
                count++;
            }
                
               
            
          
        }
        catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo. Verifique se o arquivo microprog.txt está no diretório do programa ou se o código hexadecimal e o número de microinstruções estão coerentes.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }
       strEntrada.close();
    }
    
   
    
            
}
