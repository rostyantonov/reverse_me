package com.over.bytecode.java17;

import com.over.bytecode.java11.Java11Bytecode;

/**
 * Represents the class file format introduced in Java 17 (major version 61).
 *
 * <p>Java 16 (major version 60, JEP 395) finalized record classes. A record
 * class compiles to a class file with the {@code ACC_RECORD} flag and a Record
 * attribute that describes each record component (name, descriptor, and optional
 * attributes such as Signature and runtime-visible/invisible annotations).
 *
 * <p>Java 17 (LTS, JEP 409) finalized sealed classes and interfaces.
 * A sealed class or interface carries the PermittedSubclasses attribute listing
 * the binary names of the classes and interfaces that are permitted to directly
 * extend or implement it.
 *
 * <p>New predefined class file attributes: Record (Java 16), PermittedSubclasses (Java 17).
 */
public interface Java17Bytecode extends Java11Bytecode {

    int MAJOR_VERSION = 61;

    // ── Attributes first defined in Java 16 ──────────────────────────────────

    /**
     * Used on record classes; encodes the ordered list of record components.
     * Each component entry contains the component name, descriptor, and any
     * associated attributes (e.g. Signature, RuntimeVisibleAnnotations).
     */
    String ATTR_RECORD = "Record";

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
