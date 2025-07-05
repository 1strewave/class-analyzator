package by.mf27;

import by.mf27.annotations.DontAnalyze;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassAnalyzator {

    public void analyzeClass(Class<?> clazz) {
        this.parseSuperClass("\uD83E\uDDF1 Superclass:", clazz);
        this.parseInterfaces("\uD83E\uDDE9 Interface:", clazz);
        this.parseFieldData("\uD83D\uDD27 Field:", clazz);
        this.parseConstructorData("\uD83D\uDEE0️ Constructor:", clazz);
        this.parseMethodData("\uD83D\uDCE3 Method:", clazz);
    }

    private void parseFieldData(String Prefix, Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(DontAnalyze.class))
                .map(field -> {
                    String modifierString = Modifier.toString(field.getModifiers());
                    String fieldName = field.getName();
                    String fieldType = field.getType().getName();
                    if (field.getType().getName().equals("java.lang.String")) fieldType = "String";
                    return Prefix + " " + modifierString + " " + fieldType + " " + fieldName;
                })
                .forEach(System.out::println);
    }

    private void parseMethodData(String Prefix, Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> !method.isAnnotationPresent(DontAnalyze.class))
                .map(method -> {
                    String modifierString = Modifier.toString(method.getModifiers());
                    String methodName = method.getName();
                    String methodReturnType = method.getReturnType().getName();
                    if (method.getReturnType().getName().equals("java.lang.String")) methodReturnType = "String";
                    String methodParameter = Arrays.toString(method.getParameters());
                    return Prefix + " " + modifierString + " " + methodReturnType + " " + methodName + "(" + methodParameter + ")";
                })
                .forEach(System.out::println);
    }

    private void parseConstructorData(String Prefix, Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredConstructors())
                .filter(constructor -> !constructor.isAnnotationPresent(DontAnalyze.class))
                .map(constructor -> {
                    String modifierString = Modifier.toString(constructor.getModifiers());
                    String constructorName = constructor.getName();
                    String constructorParameter = Arrays.toString(constructor.getParameters());
                    return Prefix + " " + modifierString + " " + constructorName + " (" + constructorParameter + ")";
                })
                .forEach(System.out::println);
    }

    private void parseSuperClass(String Prefix, Class<?> clazz) {
        String superClass = clazz.getSuperclass().getTypeName();

        System.out.println(Prefix + " " + superClass);
    }

    private void parseInterfaces(String Prefix, Class<?> clazz) {
        Arrays.stream(clazz.getInterfaces())
                .map(interfaceClass -> {
                    String interfaceName = interfaceClass.getTypeName();
                    return Prefix + " " + interfaceName;
                })
                .forEach(System.out::println);
    }
}
