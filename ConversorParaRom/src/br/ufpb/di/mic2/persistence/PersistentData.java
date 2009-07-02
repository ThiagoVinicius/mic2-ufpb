/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.persistence;

import br.ufpb.di.mic2.microassembler.MicroInstructionList;
import br.ufpb.di.mic2.microassembler.Microinstruction;
import java.util.HashMap;

/**
 *
 * @author thiago
 */
public class PersistentData extends HashMap <Object, Object> {


    public MicroInstructionList getMicroInstructionList (Object key) {
        
        Object result = get(key);
        
        if (result instanceof MicroInstructionList)
            return (MicroInstructionList) result;
        
        else
            return null;
        
    }

    public Microinstruction getMicroInstruction (Object key) {

        Object result = get(key);

        if (result instanceof Microinstruction)
            return (Microinstruction) result;

        else
            return null;

    }
    
    public String getString (Object key) {

        Object result = get(key);

        if (result instanceof String)
            return (String) result;

        else
            return null;

    }


}
