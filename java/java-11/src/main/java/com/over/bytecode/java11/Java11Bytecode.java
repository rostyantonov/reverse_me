package com.over.bytecode.java11;

import com.over.bytecode.java8.Java8Bytecode;

/**
 * Represents the class file format introduced in Java 11 (major version 55).
 *
 * <p>Java 9 (major version 53) introduced the Java Platform Module System
 * (JPMS / Project Jigsaw). A module declaration ({@code module-info.class})
 * is represented as a class file with the {@code ACC_MODULE} flag. Three new
 * attributes carry module metadata, and two new constant pool tags (Module,
 * Package) were added to name modules and packages in the constant pool.
 *
 * <p>Java 11 (LTS) introduced nest-based access control (JEP 181), replacing
 * the compiler trick of generating synthetic bridge methods for private access
 * between a host class and its nest members. Two new attributes record the
 * nest relationship so the JVM can perform direct access checks.
 *
 * <p>Java 11 also introduced Constant Dynamic (JEP 309): a new constant pool
 * tag that allows lazy, bootstrap-driven constant computation analogous to
 * {@code invokedynamic} but for constants.
 *
 * <p>New predefined class file attributes: Module, ModulePackages,
 * ModuleMainClass (Java 9), NestHost, NestMembers (Java 11).
 */
public interface Java11Bytecode extends Java8Bytecode {

    int MAJOR_VERSION = 55;

    // ── New constant pool tags introduced in Java 9 (JVMS §4.4) ─────────────

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

    // ── New constant pool tag introduced in Java 11 (JVMS §4.4) ─────────────

    /**
     * Represents a dynamically-computed constant — tag value 17 (JEP 309).
     * Analogous to CONSTANT_InvokeDynamic but for constant values rather than
     * call sites. The entry carries a bootstrap method index and a
     * CONSTANT_NameAndType index; the bootstrap method is invoked once to
     * produce the constant value.
     */
    int CONSTANT_DYNAMIC = 17;

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

    // ── Attributes first defined in Java 11 ──────────────────────────────────

    /**
     * Used on a member class of a nest; identifies the host class (top-level
     * class or interface) of the nest this class belongs to.
     * Enables private access between nest members without bridge methods.
     */
    String ATTR_NEST_HOST = "NestHost";

    /**
     * Used on a nest host class; lists all the member classes that belong
     * to the nest. Enables the JVM to verify nest membership and allow
     * direct access to private members.
     */
    String ATTR_NEST_MEMBERS = "NestMembers";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
