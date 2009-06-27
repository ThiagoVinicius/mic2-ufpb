/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.test;

import br.ufpb.di.mic2.microassembler.Assembler;
import br.ufpb.di.mic2.microassembler.MicroAssemblyCode;
import br.ufpb.di.mic2.microassembler.Microinstruction;
import br.ufpb.di.mic2.microassembler.exception.CompilationErrorException;
import br.ufpb.di.mic2.microassembler.pattern.MicroinstructionPattern;
import br.ufpb.di.mic2.microassembler.words.Token;
import br.ufpb.di.mic2.microassembler.words.WordSet;
import junit.framework.TestCase;

/**
 *
 * @author thiago
 */
public class TestPatterns extends TestCase {


    public Microinstruction inst;

    @Override
    public void setUp () {
        inst = new Microinstruction();
    }

    public void testAssignment () throws Exception {

        inst.highLevelCode = new MicroAssemblyCode("mar = mdr");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc = mar + mdr + 1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("abs = mar + mdr + 1");
        try {
            Assembler.compile(inst);

            fail(); //ele nao pode compilar corretamente, pois o registrador
                    //"abs" nao existe.
        } catch (CompilationErrorException e) {
        }

        //assertTrue(pattern.match(new String [] {"mar", "=", "mdr"}, 0));
        //assertTrue(pattern.match(new String [] {"pc"}, 0));
        //assertTrue(pattern.match(new String [] {"mar", "=", "mdr", ";", "pc"}, 0));
        //assertTrue(pattern.match(new String [] {"mar", "=", "mdr", "=", "pc"}, 0));
        
    }

    public void testULA () throws Exception {

        inst.highLevelCode = new MicroAssemblyCode("pc");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("not tos");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("neg tos");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("sp + mdr");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("sp + mdr + 1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc + 1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc - 1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv - cpp");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv and cpp");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv or cpp");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("-1");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("0");
        Assembler.compile(inst);

        try {
            inst.highLevelCode = new MicroAssemblyCode("sp - pc");
            Assembler.compile(inst);

            fail(); //ele nao pode compilar corretamente, pois o registrador
                    //"pc" nao esta ligado ao barramento A.
        } catch (CompilationErrorException e) {
        }


    }

    public void testUlaShift () throws Exception {
        inst.highLevelCode = new MicroAssemblyCode("pc << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("not tos << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("neg tos << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("sp + mdr << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("sp + mdr + 1 << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc + 1 << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("pc - 1 << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv - cpp << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv and cpp << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("lv or cpp << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("1 << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("-1 << 8");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("0 << 8");
        Assembler.compile(inst);

        try {
            inst.highLevelCode = new MicroAssemblyCode("sp - pc << 8");
            Assembler.compile(inst);

            fail(); //ele nao pode compilar corretamente, pois o registrador
                    //"pc" nao esta ligado ao barramento A.
        } catch (CompilationErrorException e) {
        }
    }

    public void testMemory () throws Exception {

        inst.highLevelCode = new MicroAssemblyCode("rd");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("wr");
        Assembler.compile(inst);

        inst.highLevelCode = new MicroAssemblyCode("fetch");
        Assembler.compile(inst);

    }

}
