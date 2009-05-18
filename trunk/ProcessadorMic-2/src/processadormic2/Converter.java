/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processadormic2;

/**
 *
 * @author Duilio
 */
public class Converter {
    
    public int HexatoDec(String numHexa){
        
        char array[] = numHexa.toCharArray();
        int arraylenght = array.length;
        
        int arrayAux[] = new int[arraylenght];
        
        for(int i = 0;i < arraylenght; i++){
            if(array[i] == 'A')
                arrayAux[i] = 10;
            else if (array[i] =='B')
                arrayAux[i] = 11;    
            else if (array[i] =='C')       
                arrayAux[i] = 12;
            else if (array[i] =='D')
                arrayAux[i] = 13;
            else if (array[i] =='E')
                arrayAux[i] = 14;
            else if (array[i] =='F')
                arrayAux[i] = 15;
            else {
                String aux = String.valueOf(array[i]);                
                arrayAux[i] = Integer.parseInt(aux);
                
            }
        }
        
       
       
        int valor = 0;
        for(int i = 0;i < arraylenght; i++){
            int fator;
            
            fator = elevadoA(i);
            
            valor = valor + (arrayAux[(arraylenght-1)-i]*fator);
        }
        
        return valor;
        
        
    }

    
    public String HexatoBin(String numHexa){
         char array[] = numHexa.toCharArray();
        int arraylenght = array.length;

        String arrayAux[] = new String[arraylenght];
        for(int i = 0;i < arraylenght; i++){
            if(array[i]=='0')
                arrayAux[i] = "0000";
            else if(array[i]=='1')
                arrayAux[i] = "0001";
            else if(array[i]=='2')
                arrayAux[i] = "0010";
            else if(array[i]=='3')
                arrayAux[i] = "0011";
            else if(array[i]=='4')
                arrayAux[i] = "0100";
            else if(array[i]=='5')
                arrayAux[i] = "0101";
            else if(array[i]=='6')
                arrayAux[i] = "0110";
            else if(array[i]=='7')
                arrayAux[i] = "0111";
            else if(array[i]=='8')
                arrayAux[i] = "1000";
            else if(array[i]=='9')
                arrayAux[i] = "1001";
            else if(array[i]=='A')
                arrayAux[i] = "1010";
            else if(array[i]=='B')
                arrayAux[i] = "1011";
            else if(array[i]=='C')
                arrayAux[i] = "1100";
            else if(array[i]=='D')
                arrayAux[i] = "1101";
            else if(array[i]=='E')
                arrayAux[i] = "1110";
            else if(array[i]=='F')
                arrayAux[i] = "1111";

        }
        String junta = arrayAux[0];
        for(int i = 1;i < arraylenght; i++){
            junta = junta + arrayAux[i];
        }

       
        array = junta.toCharArray();
       
        arraylenght = array.length;

        

        if(arraylenght>9){
            char arrayy[] = new char[9];
            int dif = arraylenght - 9;
            
            for(int i = 0; i<9;i++){
                arrayy[i] = array[dif+i];
            }
            return String.valueOf(arrayy);
        }
        else if (arraylenght<9){
            char arrayy[] = new char[9];
            int dif = 9 - arraylenght;
            

            for(int i = 0; i<dif;i++){
                arrayy[i]='0';
            }
            int k = 0;
            for(int i = 0; i<arraylenght;i++){
                arrayy[k+dif] = array[i];
                k++;
            }
            return String.valueOf(arrayy);
        }
        else
            return junta;

        

    }
    
    public String DectoHexa(int numDec){
        
        int array[] = new int[10];
        int resultadoAux = 0;
        
        int x = numDec;
        int i = 0;
        while(true){
            resultadoAux = x/16;
            
            array[i] = x%16;
            
            x = resultadoAux;
            
            i++;
            
            if(resultadoAux<16){
                array[i]= resultadoAux;
                
                i++;
                break;
            }
            
        }
       
        int arrayAux[] = new int[i];
        int j = i;
        for(int k = 0;k<j;k++){
            arrayAux[k] = array[i-1];
            i--;
        }
       
        char arrayFinal[] = new char[arrayAux.length];
        for(int k = 0; k < arrayAux.length; k++){
            if(arrayAux[k] == 0)
                arrayFinal[k] = '0';
            else if(arrayAux[k] == 1)
                arrayFinal[k] = '1';
            else if(arrayAux[k] == 2)
                arrayFinal[k] = '2';
            else if(arrayAux[k] == 3)
                arrayFinal[k] = '3';
            else if(arrayAux[k] == 4)
                arrayFinal[k] = '4';
            else if(arrayAux[k] == 5)
                arrayFinal[k] = '5';
            else if(arrayAux[k] == 6)
                arrayFinal[k] = '6';
            else if(arrayAux[k] == 7)
                arrayFinal[k] = '7';
            else if(arrayAux[k] == 8)
                arrayFinal[k] = '8';
            else if(arrayAux[k] == 9)
                arrayFinal[k] = '9';
            else if(arrayAux[k] == 10)
                arrayFinal[k] = 'A';
            else if(arrayAux[k] == 11)
                arrayFinal[k] = 'B';
            else if(arrayAux[k] == 12)
                arrayFinal[k] = 'C';
            else if(arrayAux[k] == 13)
                arrayFinal[k] = 'D';
            else if(arrayAux[k] == 14)
                arrayFinal[k] = 'E';
            else if(arrayAux[k] == 15)
                arrayFinal[k] = 'F';
        }
        String aux = String.valueOf(arrayFinal);
       
        return aux;
    }
    
    public int elevadoA(int expoente)
    {
        return (int)Math.pow(16, expoente);
    }

}
