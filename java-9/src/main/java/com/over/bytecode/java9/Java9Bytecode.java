package com.over.bytecode.java9;

import com.over.bytecode.java8.Java8Bytecode;

/**
 * Represents the class file format introduced in Java 9 (major version 53).
 *
 * <p>Java 9 introduced the Java Platform Module System (JPMS / Project Jigsaw).
 * A module declaration ({@code module-info.class}) is represented as a class file
 * with the {@code ACC_MODULE} flag. Three new attributes carry module metadata.
 *
 * <p>New predefined class file attributes:
 * Module, ModulePackages, ModuleMainClass.
 */
public interface Java9Bytecode extends Java8Bytecode {

    int MAJOR_VERSION = 53;

    // ── New constant pool tags (JVMS §4.4) ───────────────────────────────────

    /**
     * Represents a module name in the constant pool — tag value 19.
     * Used exclusively inside {@code module-info.class} files.
     * The entry carries an index to a CONSTANT_Utf8 for the module name.
     */
    int CONSTANT_MODULE = 19;

    /**
     * Represents a package name in the constant pool — tag value 20.
     * Used exclusively inside {@code module-info.class} files.
     * The entry carries an index to a CONSTANT_Utf8 for the package binary name.
     */
    int CONSTANT_PACKAGE = 20;

    // ── Attributes first defined in Java 9 ───────────────────────────────────

    /**
     * Used in {@code module-info.class} files; encodes the complete module
     * descriptor: module name, version, flags, requires, exports, opens,
     * uses, and provides directives.
     */
    String ATTR_MODULE = "Module";

    /**
     * Used in {@code module-info.class} files; lists packages in the module
     * that are not mentioned in the Module attribute (e.g. packages containing
     * only non-exported types). Required for proper reflective access.
     */
    String ATTR_MODULE_PACKAGES = "ModulePackages";

    /**
     * Used in {@code module-info.class} files; records the binary name of the
     * class that should be used as the module's main class.
     */
    String ATTR_MODULE_MAIN_CLASS = "ModuleMainClass";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
