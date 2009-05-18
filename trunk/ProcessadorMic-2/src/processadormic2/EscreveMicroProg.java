/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processadormic2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duilio
 */
public class EscreveMicroProg {

    private Formatter strSaidaAux;
    private Scanner strEntrada;
    InstructionRecord record = new InstructionRecord();
    MapaRecord  record2 = new MapaRecord();
    Converter cv = new Converter();
    
    
    
    public void Remove(int cd, int numInstr){
        boolean continua = false;
       
        String aux = "0x"+ cv.DectoHexa(cd);
          try {
            strEntrada = new Scanner(new File("mapa.txt"));

           
        } catch (FileNotFoundException ex) {
           javax.swing.JOptionPane.showMessageDialog(null, "Erro ao tentar abrir o arquivo mapa.txt");
        }
        try{
           while(strEntrada.hasNext()){
                 record2.setcodHexadecimal(strEntrada.next());
                 record2.setnomeInstr(strEntrada.next());
                 if(record2.getcodHexadecimal().equals(aux) == true)
                     continua = true;
                   
                 
                 
             }



        }
        catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo. Verifique se o arquivo mapa.txt está no diretório do programa ou se o código hexadecimal e o número de microinstruções estão coerentes.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }

        strEntrada.close();
        


        if(continua == true){

        try {
            strEntrada = new Scanner(new File("microprog.txt"));
            
            strSaidaAux = new Formatter("microprog2.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerMicroProg.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int count = 0;
        try{
           while(count < cd){
                strEntrada.hasNext();
                record.setMicroCodigo(strEntrada.next());
                strSaidaAux.format("%s\n", record.getMicroCodigo());
                count++;
            }
           count = 0;
           while(count<numInstr){
               strEntrada.hasNext();
                record.setMicroCodigo(strEntrada.next());
                strSaidaAux.format("%s\n","000000000000000000000000000000000000");
                count++;
           }
           while(strEntrada.hasNext()){                
                record.setMicroCodigo(strEntrada.next());
                strSaidaAux.format("%s\n", record.getMicroCodigo());
               
            }
           
        }
        catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivoOOO. Verifique se o arquivo microprog.txt está no diretório do programa ou se o código hexadecimal e o número de microinstruções estão coerentes.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }
        
        strEntrada.close();
        strSaidaAux.close();
        File arquivo1 = new File("microprog.txt");
        File arquivo2 = new File("microprog2.txt");
        arquivo1.delete();
        arquivo2.renameTo(arquivo1);
        
        
        
        
        Main.mf.lmp.initMatrixMP();
        
        Main.mf.lmp.model.matrixx  = Main.mf.lmp.matrix;
        Main.mf.lmp.model.fireTableDataChanged();

        String c = cv.DectoHexa(cd);
        RemoveMapa("0x"+c);
        }
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Instrução não existente! COnfira o código hexadecimal novamente no Mapa de Instruções e tente novamente.");
        
    }
    public void RemoveMapa(String ch){

     
        try {
            strEntrada = new Scanner(new File("mapa.txt"));

            strSaidaAux = new Formatter("mapa2.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerMicroProg.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        try{
           while(strEntrada.hasNext()){
                 record2.setcodHexadecimal(strEntrada.next());
                 record2.setnomeInstr(strEntrada.next());
                 if(record2.getcodHexadecimal().equals(ch))
                     continue;

                 strSaidaAux.format("%s %s\n", record2.getcodHexadecimal(),record2.getnomeInstr());
             }
           
          

        }
        catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo. Verifique se o arquivo mapa.txt está no diretório do programa ou se o código hexadecimal e o número de microinstruções estão coerentes.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }

        strEntrada.close();
        strSaidaAux.close();
        File arquivo1 = new File("mapa.txt");
        File arquivo2 = new File("mapa2.txt");
        arquivo1.delete();
        arquivo2.renameTo(arquivo1);




    }
    public void AdicionaMapa(int cd, String nome){
          try {
            strEntrada = new Scanner(new File("mapa.txt"));
            
            strSaidaAux = new Formatter("mapa2.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerMicroProg.class.getName()).log(Level.SEVERE, null, ex);
            
           
        }
          
         try{
             while(strEntrada.hasNext()){
                 record2.setcodHexadecimal(strEntrada.next());
                 record2.setnomeInstr(strEntrada.next());
                 strSaidaAux.format("%s %s\n", record2.getcodHexadecimal(),record2.getnomeInstr());
             }
             strSaidaAux.format("%s %s\n", "0x"+cv.DectoHexa(cd),nome);
             strSaidaAux.close();
             
             
         }
         catch(NoSuchElementException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo. Verifique se o arquivo microprog.txt está no diretório do programa ou se o código hexadecimal e o número de microinstruções estão coerentes.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            strEntrada.close();
        }
        
         strEntrada.close();
            strSaidaAux.close();
         
        File arquivo3 = new File("mapa.txt");
        File arquivo4 = new File("mapa2.txt");
        
        arquivo3.delete();
        arquivo4.renameTo(arquivo3);
        
    }
     
            
}
