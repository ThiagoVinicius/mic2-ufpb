/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.test;

import br.ufpb.di.mic2.microassembler.pattern.MicroinstructionPattern;
import junit.framework.TestCase;

/**
 *
 * @author thiago
 */
public class TestPatterns extends TestCase {

    public void testAssignment () throws Exception {

        MicroinstructionPattern pattern = new MicroinstructionPattern();
        
        assertTrue(pattern.match(new String [] {"mar", "=", "mdr"}, 0));
        assertTrue(pattern.match(new String [] {"pc"}, 0));
        assertTrue(pattern.match(new String [] {"mar", "=", "mdr", ";", "pc"}, 0));
        assertTrue(pattern.match(new String [] {"mar", "=", "mdr", "=", "pc"}, 0));


    }

    public void testULA () throws Exception {

        MicroinstructionPattern pattern = new MicroinstructionPattern();

        assertTrue(pattern.match(new String [] {"mar", "+", "mdr"}, 0));
        assertTrue(pattern.match(new String [] {"pc"}, 0));
        assertTrue(pattern.match(new String [] {"mar", "+", "mdr", "+", "1"}, 0));


    }

}
