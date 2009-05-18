/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processadormic2;

/**
 *
 * @author Duilio
 */
public class InstructionRecord {

    String microCod;
    
    public InstructionRecord (){
        this("");
    }
    public InstructionRecord(String mc){
        setMicroCodigo(mc);
    }
    
    public void setMicroCodigo(String mc){
        microCod = mc;
    }
    public String getMicroCodigo(){
        return microCod;
    }
}
