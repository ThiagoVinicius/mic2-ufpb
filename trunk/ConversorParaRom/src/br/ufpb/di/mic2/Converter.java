/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;

/**
 *
 * @author Duilio
 */
public class Converter {

    public int HexatoDec(String numHexa){
        return Integer.parseInt(numHexa.toLowerCase(), 16);
    }

    public String HexatoBin(String numHexa){
        return Integer.toBinaryString(HexatoDec(numHexa));
    }

    public String DectoHexa(int numDec){
        return Integer.toHexString(numDec).toUpperCase();
    }
    
    public int elevadoA(int expoente)
    {
        return (int)Math.pow(16, expoente);
    }

}
