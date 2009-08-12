/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.persistence;

import br.ufpb.di.mic2.microassembler.CompiledMicrocode;
import br.ufpb.di.mic2.microassembler.Microinstruction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Thiago
 */
public class MIFFileExporter {

    public static void export (Writer wr, PersistentData list)
            throws IOException {

        wr.write("DEPTH = ");
        wr.write(Integer.toString(list.size(), 10));
        wr.write(";\n");

        wr.write("WIDTH = ");
        wr.write(Integer.toString(CompiledMicrocode.WORD_SIZE, 10));
        wr.write(";\n");

        wr.write("ADDRESS_RADIX = HEX;\n");
        wr.write("DATA_RADIX = BIN;\n");
        wr.write("\n");
        wr.write("CONTENT\n");
        wr.write("BEGIN\n");
        wr.write("\n");

        writeInstructions(wr, list);

        wr.write("\n");
        wr.write("END;");
        wr.write("\n");

    }

    private static void writeInstructions(Writer wr, PersistentData list) throws IOException {

        for (int i = 0; i < list.size(); ++i) {
            String key = "word'"+i;
            Microinstruction cur = list.getMicroInstruction(key);

            wr.write(String.format("%03X", cur.address));
            wr.write(" : ");
            wr.write(cur.machineCode.code);
            wr.write(" -- ");
            wr.write(cur.highLevelCode.toString());
            wr.write("\n");

        }

    }

    public static void export (File out, PersistentData list)
            throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        export(bw, list);
        bw.close();

    }

}
