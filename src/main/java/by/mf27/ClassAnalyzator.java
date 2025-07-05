package by.mf27;

import by.mf27.annotations.DontAnalyze;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassAnalyzator {

    public void analyzeClass(Class clazz) {
        this.parseFieldData("\uD83D\uDD27 Field:", clazz);
        this.parseConstructorData("\uD83D\uDEE0\uFE0F Constructor:", clazz);
        this.parseMethodData("\uD83D\uDCE3 Method:", clazz);
    }

    // TODO: Output data about super class and implemented interfaces

    private void parseFieldData(String Prefix, Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(DontAnalyze.class)) continue;
            String modifierString = Modifier.toString(field.getModifiers());
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            if (field.getType().getName().equals("java.lang.String")) {
                fieldType = "String";
            }

            System.out.println(Prefix + " " + modifierString + " " + fieldType + " " + fieldName);
        }
    }

    private void parseMethodData(String Prefix, Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DontAnalyze.class)) continue;
            String modifierString = Modifier.toString(method.getModifiers());
            String methodName = method.getName();
            String methodReturnType = method.getReturnType().getName();
            if (method.getReturnType().getName().equals("java.lang.String")) {
                methodReturnType = "String";
            }
            String methodParameter = Arrays.toString(method.getParameters());

            System.out.println(Prefix + " " + modifierString + " " + methodReturnType + " " + methodName + "(" + methodParameter + ")");
        }
    }

    private void parseConstructorData(String Prefix, Class clazz) {
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(DontAnalyze.class)) continue;
            String modifierString = Modifier.toString(constructor.getModifiers());
            String constructorName = constructor.getName();
            String constructorParameter = Arrays.toString(constructor.getParameters());

            System.out.println(Prefix + " " + modifierString + " " + constructorName + " (" + constructorParameter + ")");
        }
    }
}
