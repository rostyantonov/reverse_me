package com.over.bytecode.java5;

import com.over.bytecode.java1.Java1Bytecode;

/**
 * Represents the class file format introduced in Java 5 (major version 49).
 *
 * <p>Java 5 added support for generics (Signature), annotations, varargs,
 * and enums at the bytecode level. New predefined class file attributes:
 * EnclosingMethod, Signature, SourceDebugExtension, LocalVariableTypeTable,
 * RuntimeVisibleAnnotations, RuntimeInvisibleAnnotations,
 * RuntimeVisibleParameterAnnotations, RuntimeInvisibleParameterAnnotations,
 * AnnotationDefault.
 */
public interface Java5Bytecode extends Java1Bytecode {

    int MAJOR_VERSION = 49;

    // ── Attributes first defined in Java 5 ───────────────────────────────────

    /** Used on classes or methods declared inside a method or constructor. */
    String ATTR_ENCLOSING_METHOD = "EnclosingMethod";

    /**
     * Records generic type, method, or field signatures.
     * Enables reflection of generic type parameters at runtime.
     */
    String ATTR_SIGNATURE = "Signature";

    /**
     * Holds extended debug information (JSR-045) used by non-Java language
     * compilers targeting the JVM.
     */
    String ATTR_SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";

    /**
     * Maps bytecode offsets to local variable names with generic type signatures.
     * Extends LocalVariableTable with type parameter information.
     */
    String ATTR_LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";

    /** Holds annotations visible at runtime on a class, field, or method. */
    String ATTR_RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";

    /** Holds annotations invisible at runtime (e.g. compile-time only). */
    String ATTR_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";

    /** Holds runtime-visible annotations on each method parameter. */
    String ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";

    /** Holds runtime-invisible annotations on each method parameter. */
    String ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";

    /** Records the default value declared in an annotation type element. */
    String ATTR_ANNOTATION_DEFAULT = "AnnotationDefault";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
