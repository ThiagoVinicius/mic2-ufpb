/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufpb.di.mic2.persistence;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author thiago
 */
public class WorkspaceManager {

    private File workspaceLocation;

    public void write (PersistentData data) throws IOException {
        throw new UnsupportedOperationException();
    }

    public File getWorkspaceLocation () {
        return workspaceLocation;
    }



}
