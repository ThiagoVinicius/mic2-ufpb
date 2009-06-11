/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.microassembler;

/**
 *
 * @author thiago
 */
public abstract class AbstractObjectMicrocode {

    public char code[];

    public abstract void setNextAddr (int address);
    
    public abstract int getNextAddr ();

}
