/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;

/**
 *
 * @author Duilio
 */
public class MapaRecord {

     String codHexadecimal;
     String nomeInstr;
    
    public MapaRecord (){
        this("","");
    }
    public MapaRecord(String ch, String ni){
        setcodHexadecimal(ch);
        setnomeInstr(ni);
    }
    
    public void setcodHexadecimal(String mc){
        codHexadecimal = mc;
    }
    public String getcodHexadecimal(){
        return codHexadecimal;
    }
    
    public void setnomeInstr(String ni){
        nomeInstr = ni;
    }
    public String getnomeInstr(){
        return nomeInstr;
    }
}
