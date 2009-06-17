/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.microassembler;

/**
 *
 * Esta classe e' a superclasse de todo e qualquer 'microcodigo objeto' que pode
 * ser gerado no processo de traducao.
 *
 * Representa uma palavra na memoria. O formato, tamanho e tudo o mais e' espe-
 * cificado por cada subclasse.
 *
 *
 *
 * @author thiago
 */
public abstract class AbstractObjectMicrocode {

    /**
     * Representa o microcodigo, os caracteres validos sao '1' e '0',
     * representando, respectivamente, o bit 1 e o bit 0
     */
    public char code[];

    /**Seleciona o endereco da proxima instrucao*/
    public abstract void setNextAddr (int address);

    /**recupera o endereco da proxima instrucao*/
    public abstract int getNextAddr ();

}
