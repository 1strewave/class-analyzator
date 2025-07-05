package by.mf27;

import by.mf27.annotations.DontAnalyze;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassAnalyzator {

    public void analyzeClass(Class clazz) {
        this.parseFieldData("\uD83D\uDD27 Field:", clazz);
        this.parseMethodData("\uD83D\uDCE3 Method:", clazz);
    }

    // TODO: Add parsing to Constructors, and also output data about super class and implemented interfaces

    private void parseFieldData(String Prefix, Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(DontAnalyze.class)) continue;
            int fieldMod = field.getModifiers();
            String modifierString = Modifier.toString(fieldMod);
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            if (field.getType().getName().equals("java.lang.String")) {
                fieldType = "String";
            }

            System.out.println(Prefix + " " + modifierString + " " + fieldType + " " + fieldName);
        }
    }

    /*
    * @mf27: Reason for doing the same method again is based on adding parameters
    */
    private void parseMethodData(String Prefix, Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DontAnalyze.class)) continue;
            int methodMod = method.getModifiers();
            String modifierString = Modifier.toString(methodMod);
            String methodName = method.getName();
            String methodReturnType = method.getReturnType().getName();
            if (method.getReturnType().getName().equals("java.lang.String")) {
                methodReturnType = "String";
            }
            String methodParameter = Arrays.toString(method.getParameters());

            System.out.println(Prefix + " " + modifierString + " " + methodReturnType + " " + methodName + "(" + methodParameter + ")");
        }
    }
}
