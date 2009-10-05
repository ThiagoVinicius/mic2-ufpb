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
 * File: CodeTranslatorApp.java
 */

package codetranslator;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import codetranslator.core.Constants;
import codetranslator.core.Controller;
import codetranslator.exceptions.OpenProjectException;
import codetranslator.windows.CodeTranslatorView;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class CodeTranslatorApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        CodeTranslatorView view = new CodeTranslatorView(this);

        File initialFile = new File(Constants.CURRENT_PATH + "/default.ct");

        if ( !initialFile.exists() ) {
            boolean success = new File(Constants.CURRENT_PATH + "/").mkdirs();

            if (!success) {
                Constants.CURRENT_PATH = "";
            }

        } else { // open project
            try {
                // open project
                Controller.getInstance().openProject(initialFile.getAbsolutePath(), view);
            } catch (OpenProjectException ex) {
                Constants.CURRENT_PATH = "";
            }
        }
            
        show(view);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of JavaToIJVMApp
     */
    public static CodeTranslatorApp getApplication() {
        return Application.getInstance(CodeTranslatorApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(CodeTranslatorApp.class, args);
    }
}
