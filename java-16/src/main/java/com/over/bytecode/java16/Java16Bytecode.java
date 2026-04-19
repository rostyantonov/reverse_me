package com.over.bytecode.java16;

import com.over.bytecode.java11.Java11Bytecode;

/**
 * Represents the class file format introduced in Java 16 (major version 60).
 *
 * <p>Java 16 (JEP 395) finalized record classes. A record class compiles to a
 * class file with the {@code ACC_RECORD} flag and a Record attribute that
 * describes each record component (name, descriptor, and optional attributes
 * such as Signature and runtime-visible/invisible annotations).
 *
 * <p>New predefined class file attribute: Record.
 */
public interface Java16Bytecode extends Java11Bytecode {

    int MAJOR_VERSION = 60;

    // ── Attributes first defined in Java 16 ──────────────────────────────────

    /**
     * Used on record classes; encodes the ordered list of record components.
     * Each component entry contains the component name, descriptor, and any
     * associated attributes (e.g. Signature, RuntimeVisibleAnnotations).
     */
    String ATTR_RECORD = "Record";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
