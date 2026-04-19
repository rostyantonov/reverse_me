package com.over.bytecode.java8;

import com.over.bytecode.java7.Java7Bytecode;

/**
 * Represents the class file format introduced in Java 8 (major version 52).
 *
 * <p>Java 8 (LTS) added support for lambda expressions (compiled via
 * {@code invokedynamic}), default and static interface methods, and extended
 * annotation support with type annotations (JSR 308).
 *
 * <p>New predefined class file attributes:
 * RuntimeVisibleTypeAnnotations, RuntimeInvisibleTypeAnnotations,
 * MethodParameters.
 */
public interface Java8Bytecode extends Java7Bytecode {

    int MAJOR_VERSION = 52;

    // ── Attributes first defined in Java 8 ───────────────────────────────────

    /**
     * Holds annotations visible at runtime on type uses (JSR 308):
     * field types, return types, thrown exception types, type arguments, etc.
     * May appear on classes, fields, methods, or in the Code attribute.
     */
    String ATTR_RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";

    /**
     * Holds annotations invisible at runtime on type uses (JSR 308).
     * Same placement rules as RuntimeVisibleTypeAnnotations.
     */
    String ATTR_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";

    /**
     * Used on methods; records the name and access flags of each formal parameter
     * so that their names are available via reflection at runtime.
     */
    String ATTR_METHOD_PARAMETERS = "MethodParameters";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
