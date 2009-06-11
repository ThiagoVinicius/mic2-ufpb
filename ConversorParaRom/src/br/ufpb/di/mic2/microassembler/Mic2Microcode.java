/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.microassembler;

import java.util.Arrays;

/**
 *
 * @author thiago
 */
public class Mic2Microcode extends AbstractObjectMicrocode {

    public static final int WORD_SIZE = 39;

    public static final int ADDR_OFFSET = 0;
    public static final int ADDR_LENGHT = 9;

    public Mic2Microcode () {
        code = new char[WORD_SIZE];
        Arrays.fill(code, '0');
    }

    public void setNextAddr (int address) {

        if (address >= 0 && (2 << ADDR_LENGHT) - 1 < address) {

            char newAddress[] = Integer.toBinaryString(address).toCharArray();

            int index;
            index = ADDR_LENGHT - newAddress.length;
            for (int i = 0; i < newAddress.length; ++i) {
                code[ADDR_OFFSET+index+i] = newAddress[i];
            }

        }

    }

    public int getNextAddr () {
        return Integer.parseInt(
                new String (
                    Arrays.copyOfRange(
                        code, ADDR_OFFSET, ADDR_OFFSET+ADDR_LENGHT)
                    )
                , 2);
    }

}
