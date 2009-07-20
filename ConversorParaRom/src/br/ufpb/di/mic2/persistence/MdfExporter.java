/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author thiago
 */
public class MdfExporter {

    public static void write (BufferedWriter bw,
                              PersistentData dict) throws IOException {
        throw new UnsupportedOperationException();

    }


    public static void write (File where,
                              PersistentData dict) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(where));
        write(bw, dict);
        bw.close();
    }

}
