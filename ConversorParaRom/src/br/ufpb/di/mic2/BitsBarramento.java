/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2;

/**
 *
 * @author Duilio
 */
public class BitsBarramento {

    int posicaoC = 0;

    public void DeterminaBarramentoC(String cod){
        if(cod.equals("MAR")==true)
            posicaoC = 0;
        else if(cod.equals("MDR")==true)
            posicaoC = 1;
        else if(cod.equals("PC")==true)
            posicaoC = 2;
        else if(cod.equals("SP")==true)
            posicaoC = 3;
        else if(cod.equals("LV")==true)
            posicaoC = 4;
        else if(cod.equals("CPP")==true)
            posicaoC = 5;
        else if(cod.equals("TOS")==true)
            posicaoC = 6;
        else if(cod.equals("OPC")==true)
            posicaoC = 7;
        else if(cod.equals("H")==true)
            posicaoC = 8;
        else
            posicaoC = -1;
        
    }

    public String DeterminaBarramentoB(String cod){
        if(cod.equals("MDR")==true)
            return "0000";
        else if (cod.equals("PC")==true)
            return "0001";
        else if (cod.equals("MBR1")==true)
            return "0010";
        else if (cod.equals("MBR1U")==true)
            return "0011";
        else if (cod.equals("MBR2")==true)
            return "0100";
        else if (cod.equals("MBR2U")==true)
            return "0101";
        else if (cod.equals("SP")==true)
            return "0110";
        else if (cod.equals("LV")==true)
            return "0111";
        else if (cod.equals("CPP")==true)
            return "1000";
        else if (cod.equals("TOS")==true)
            return "1001";
        else if (cod.equals("OPC")==true)
            return "1010";
        else if (cod.equals("H")==true)
            return "1011";

        else
        return null;
    }

    public String DeterminaBarramentoA(String cod){
        if(cod.equals("MDR")==true)
            return "000";
        else if (cod.equals("SP")==true)
            return "001";
        else if (cod.equals("LV")==true)
            return "010";
        else if (cod.equals("CPP")==true)
            return "011";
        else if (cod.equals("TOS")==true)
            return "100";
        else if (cod.equals("OPC")==true)
            return "101";
        else if (cod.equals("H")==true)
            return "110";
        

        else
        return null;
    }

    public int ehRegistrador(String cod){
        if(cod.equals("MDR") || cod.equals("MAR") || cod.equals("PC") || cod.equals("MBR1") || cod.equals("MBR1U") || cod.equals("MBR2") || cod.equals("MBR2U") || cod.equals("SP") || cod.equals("LV") || cod.equals("CPP") || cod.equals("TOS") || cod.equals("OPC") || cod.equals("H") ) {
            return 1;
        }
        else
            return 0;
    }
}



