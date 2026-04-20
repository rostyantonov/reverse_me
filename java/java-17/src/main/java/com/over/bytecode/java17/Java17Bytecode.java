package com.over.bytecode.java17;

import com.over.bytecode.java16.Java16Bytecode;

/**
 * Represents the class file format introduced in Java 17 (major version 61).
 *
 * <p>Java 17 (LTS, JEP 409) finalized sealed classes and interfaces.
 * A sealed class or interface carries the PermittedSubclasses attribute listing
 * the binary names of the classes and interfaces that are permitted to directly
 * extend or implement it.
 *
 * <p>New predefined class file attribute: PermittedSubclasses.
 */
public interface Java17Bytecode extends Java16Bytecode {

    int MAJOR_VERSION = 61;

    // ── Attributes first defined in Java 17 ──────────────────────────────────

    /**
     * Used on sealed classes and interfaces; holds the list of class/interface
     * binary names that are explicitly permitted to directly extend or implement
     * this sealed type.
     * The JVM enforces the constraint at link time.
     */
    String ATTR_PERMITTED_SUBCLASSES = "PermittedSubclasses";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
