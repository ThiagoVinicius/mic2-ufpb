// This file is part of the Code Translator source code
//
// Copyright (C) 2009 UFPB (http://www.di.ufpb.br),
// Federal University of Paraiba.
// All rights reserved.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public
// License along with this program; if not, write to the Free
// Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
// Boston, MA 02110-1301, USA.
// *****************************************************************

/*
 * File: Controller.java
 */

package codetranslator.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import codetranslator.windows.CodeTranslatorView;
import codetranslator.exceptions.DuplicatedException;
import codetranslator.exceptions.ExpectedException;
import codetranslator.exceptions.FatalException;
import codetranslator.exceptions.OpenProjectException;
import codetranslator.exceptions.SaveProjectException;
import codetranslator.exceptions.UndefinedException;
import codetranslator.util.ExtensionFileFilter;
import javax.swing.JFileChooser;

/**
 *
 * @author Erisvaldo
 */
public class Controller {

    private static Compiler compiler;
    private static Controller instance;

    private Controller() {
        compiler = null;
    }

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();

        return instance;
    }

    public Compiler getCompiler() {
        return compiler;
    }

    public void generateIJVMCode(String inputCode, CodeTranslatorView view) {
        compiler = IJVMCompiler.getInstance();
        String prefix = "[IJVM] ";

        try {
            String code = compiler.getCode(inputCode);
            view.getIjvmTextArea().setText(code);
            addOutputText(prefix + "Código gerado com sucesso.", view);
        } catch (DuplicatedException ex) {
            addOutputText(prefix + "ERRO! Duplicado: " + ex.getMessage(), view);
        } catch (ExpectedException ex) {
            addOutputText(prefix + "ERRO! Esperado: " + ex.getMessage(), view);
        } catch (FatalException ex) {
            addOutputText(prefix + "ERRO: " + ex.getMessage(), view);
        } catch (UndefinedException ex) {
            addOutputText(prefix + "ERRO! Indefinido: " + ex.getMessage(), view);
        } catch (UnsupportedOperationException ex) {
            addOutputText(prefix + "ERRO! Operação não suportada: " + ex.getMessage(), view);
        }
    }

    public void generateX86Code(String inputCode, CodeTranslatorView view) {
        compiler = X86Compiler.getInstance();
        String prefix = "[80x86] ";

        try {
            String code = compiler.getCode(inputCode);
            view.getX86TextArea().setText(code);
            addOutputText(prefix + "Código gerado com sucesso.", view);
        } catch (DuplicatedException ex) {
            addOutputText(prefix + "ERRO! Duplicado: " + ex.getMessage(), view);
        } catch (ExpectedException ex) {
            addOutputText(prefix + "ERRO! Esperado: " + ex.getMessage(), view);
        } catch (FatalException ex) {
            addOutputText(prefix + "ERRO: " + ex.getMessage(), view);
        } catch (UndefinedException ex) {
            addOutputText(prefix + "ERRO! Indefinido: " + ex.getMessage(), view);
        }
    }

    public void openProject(String filename, CodeTranslatorView view) throws OpenProjectException {
        try {
            String selectedFile = filename;
            String aux = selectedFile.endsWith(".ct") ? selectedFile.substring(0, selectedFile.indexOf(".ct")) : selectedFile;
            String ijvmFile = aux.concat(".jvm");
            String inputFile = aux.concat(".in");
            String x86File = aux.concat(".asm");

            String projectName = selectedFile.lastIndexOf("/") != -1 ? aux.substring( selectedFile.lastIndexOf("/") + 1, aux.length() ) : aux.substring( selectedFile.lastIndexOf("\\") + 1, aux.length() );

            // Read .IN
            FileReader inputFileReader = new FileReader(inputFile);
            BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);

            String inputText = "";

            String line;

            while ( ( line = inputBufferedReader.readLine() ) != null) {
                inputText += line + '\n';
            }

            inputFileReader.close();

            // Read .ASM
            FileReader x86FileReader = new FileReader(x86File);

            String x86Text = "";
            BufferedReader x86BufferedReader = new BufferedReader(x86FileReader);

            String line2;

            while ( ( line2 = x86BufferedReader.readLine() ) != null) {
                x86Text += line2 + '\n';
            }

            x86FileReader.close();

            // Read .JVM
            FileReader ijvmFileReader = new FileReader(ijvmFile);
            BufferedReader ijvmBufferedReader = new BufferedReader(ijvmFileReader);

            String ijvmText = "";

            String line3;

            while ( ( line3 = ijvmBufferedReader.readLine() ) != null) {
                ijvmText += line3 + '\n';
            }

            ijvmFileReader.close();

            Constants.PROJECT_NAME = projectName;
            view.configureLabels();
            view.getInputTextArea().setText(inputText);
            view.getX86TextArea().setText(x86Text);
            view.getIjvmTextArea().setText(ijvmText);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new OpenProjectException("Não foi possível abrir o projeto");
        }
    }

    public void openProject(CodeTranslatorView view) throws OpenProjectException {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileFilter(new ExtensionFileFilter("Projetos do Code Translator", "ct"));

            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String selectedFile = chooser.getSelectedFile().toString();

            String aux = selectedFile.substring(0, selectedFile.indexOf(".ct"));
            String ijvmFile = aux.concat(".jvm");
            String inputFile = aux.concat(".in");
            String x86File = aux.concat(".asm");

            String projectName = selectedFile.lastIndexOf("/") != -1 ? aux.substring( selectedFile.lastIndexOf("/") + 1, aux.length() ) : aux.substring( selectedFile.lastIndexOf("\\") + 1, aux.length() );

            // Read .IN
            FileReader inputFileReader = new FileReader(inputFile);
            BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);

            String inputText = "";

            String line;

            while ( ( line = inputBufferedReader.readLine() ) != null) {
                inputText += line + '\n';
            }

            inputFileReader.close();

            // Read .ASM
            FileReader x86FileReader = new FileReader(x86File);

            String x86Text = "";
            BufferedReader x86BufferedReader = new BufferedReader(x86FileReader);

            String line2;

            while ( ( line2 = x86BufferedReader.readLine() ) != null) {
                x86Text += line2 + '\n';
            }

            x86FileReader.close();

            // Read .JVM
            FileReader ijvmFileReader = new FileReader(ijvmFile);
            BufferedReader ijvmBufferedReader = new BufferedReader(ijvmFileReader);

            String ijvmText = "";

            String line3;

            while ( ( line3 = ijvmBufferedReader.readLine() ) != null) {
                ijvmText += line3 + '\n';
            }

            ijvmFileReader.close();

            Constants.CURRENT_PATH = selectedFile.lastIndexOf("/") != -1 ? selectedFile.substring( 0, selectedFile.lastIndexOf("/") + 1 ) : selectedFile.substring( 0, selectedFile.lastIndexOf("\\") + 1 );
            Constants.PROJECT_NAME = projectName;
            view.configureLabels();
            view.getInputTextArea().setText(inputText);
            view.getX86TextArea().setText(x86Text);
            view.getIjvmTextArea().setText(ijvmText);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new OpenProjectException("Não foi possível abrir o projeto");
        }
    }

    public void saveProjectAs(CodeTranslatorView view) throws SaveProjectException, OpenProjectException {
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new ExtensionFileFilter("Projetos do Code Translator", "ct"));

        if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
            return;

        String selectedFile = chooser.getSelectedFile().toString();

        if ( selectedFile.endsWith(".ct") )
            selectedFile = selectedFile.substring(0, selectedFile.indexOf(".ct"));

        Constants.CURRENT_PATH = selectedFile.lastIndexOf("/") != -1 ? selectedFile.substring(0, selectedFile.lastIndexOf("/") + 1) : selectedFile.substring(0, selectedFile.lastIndexOf("\\") + 1);
        Constants.PROJECT_NAME = selectedFile.lastIndexOf("/") != -1 ? selectedFile.substring(selectedFile.lastIndexOf("/") + 1) : selectedFile.substring(selectedFile.lastIndexOf("\\") + 1);

        saveProject( selectedFile, view.getInputTextArea().getText(), view.getX86TextArea().getText(), view.getIjvmTextArea().getText() );


        // Open project
        openProject(selectedFile, view);
    }

    public void saveProject(String filename, String inputText, String x86Text, String ijvmText) throws SaveProjectException {
        try {
            saveTextInFile(filename + ".ct", "Projeto Code Translator\nArquivo de entrada: " + Constants.PROJECT_NAME + ".in\nCódigo Assembly 80x86: " + Constants.PROJECT_NAME + ".asm\nCódigo IJVM: " + Constants.PROJECT_NAME + ".jvm");
            saveTextInFile(filename + ".in", inputText == null ? "" : inputText);
            saveTextInFile(filename + ".asm", x86Text == null ? "" : x86Text);
            saveTextInFile(filename + ".jvm", ijvmText == null ? "" : ijvmText);
        } catch (Exception ex) {
            throw new SaveProjectException("Não foi possível salvar o projeto");
        }
    }

    private void addOutputText(String outputText, CodeTranslatorView view) {
        // Get current time
        GregorianCalendar gc = new GregorianCalendar();
        String currentTimeString = gc.get(Calendar.HOUR_OF_DAY) + ":" + gc.get(Calendar.MINUTE) + ":" + ( gc.get(Calendar.SECOND) < 10 ? "0" + gc.get(Calendar.SECOND) : gc.get(Calendar.SECOND) );
        // Add text to the output area
        String currentOutputText = view.getOutputTextArea().getText();
        view.getOutputTextArea().setText(currentOutputText + "[" + currentTimeString + "] " + outputText + "\n");
    }

    private void saveTextInFile(String filename, String text) throws Exception {
        String content = text;
        // o false significa q o arquivo será substituído
        FileWriter x = new FileWriter(filename, false);
        x.write(content); // armazena o texto no objeto x, que aponta para o arquivo
        x.close(); // cria o arquivo
    }
}
