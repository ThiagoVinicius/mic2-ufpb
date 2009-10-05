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
 * File: Compiler.java
 */

package codetranslator.core;

import codetranslator.exceptions.DuplicatedException;
import codetranslator.exceptions.ExpectedException;
import codetranslator.exceptions.FatalException;
import codetranslator.exceptions.UndefinedException;

/**
 *
 * @author Erisvaldo
 */
public abstract class Compiler {

    public abstract String getCode(String inputCode) throws DuplicatedException, ExpectedException, FatalException, UndefinedException;

    // CODE GENERATION ROUTINES

    // primary register = zero
    protected abstract void instructionClear();
    // primare register = negative
    protected abstract void instructionNegative();
    // primary register = numeric constant
    protected abstract void instructionLoadConst(String val);
    // primary register = variable
    protected abstract void instructionLoadVar(String name) throws UndefinedException;
    // put primary register at the stack
    protected abstract void instructionPush();
    // add primary register to top of the stack
    protected abstract void instructionPopAdd();
    // subtract primary register from top of the stack
    protected abstract void instructionPopSub();
    // multiply primary register by top of the stack
    protected abstract void instructionPopMul();
    // divide top of the stack by primary register
    protected abstract void instructionPopDiv();
    // stores primary register in a variable
    protected abstract void instructionStore(String name);
    // invert primary register
    protected abstract void instructionNot();
    // AND from top of the stack with primary register
    protected abstract void instructionPopAnd();
    // OR from top of the stack with primary register
    protected abstract void instructionPopOr();
    // "OR-exclusive" from top of stack with primary register
    protected abstract void instructionPopXor();
    // compares top of stack with primary register
    protected abstract void instructionPopCompare();
    // changes primary register and flags according to comparison
    protected abstract void instructionRelOp(char op);
    // jump
    protected abstract void instructionJmp(int label);
    // jump if false (0)
    protected abstract void instructionJmpFalse(int label);
    // read a value to the primary register and stores in a variable
    protected abstract void instructionRead();
    // shows primary register value
    protected abstract void instructionWrite();
    // Header of Main routine
    protected abstract void instructionHeader();
    // Prolog of Main routine
    protected abstract void instructionProlog();
    // Epilog of Main routine
    protected abstract void instructionEpilog();
}
