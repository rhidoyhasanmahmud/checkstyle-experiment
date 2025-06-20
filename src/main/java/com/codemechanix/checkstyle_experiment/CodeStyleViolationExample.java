package com.codemechanix.checkstyle_experiment;

import java.util.*; // ❌ AvoidStarImport
import static java.lang.System.out; // ❌ Unused import

public class CodeStyleViolationExample {

    public void BADMethod(int X, int Y, int Z, int A, int B, int C) { // ❌ Too many parameters, not camelCase
        int SUM=1+2; // ❌ Uppercase variable, no whitespace around operators
        if(SUM==3) System.out.println("Check passed"); // ❌ No braces, uses println
        else System.out.println("Check failed"); // ❌ Uses println again
    }

    public void emptyBlock() { // ❌ Empty code block
    }

    public void magic() {
        int threshold = 42; // ❌ Magic number
        int limit = 100; // ❌ Magic number
        System.out.println(threshold + limit); // ❌ Uses println
    }
}