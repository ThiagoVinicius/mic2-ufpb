/*
 * JavaToIJVMApp.java
 */

package javatoijvm;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javatoijvm.core.Constants;
import javatoijvm.core.Controller;
import javatoijvm.exceptions.OpenProjectException;
import javatoijvm.windows.JavaToIJVMView;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class JavaToIJVMApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        JavaToIJVMView view = new JavaToIJVMView(this);

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
    public static JavaToIJVMApp getApplication() {
        return Application.getInstance(JavaToIJVMApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(JavaToIJVMApp.class, args);
    }
}
