package by.mf27;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassAnalyzator {

    public void analyzeClass(Class clazz) {
        this.parseFieldData("\uD83D\uDD27 Field:", clazz);
        this.parseMethodData("\uD83D\uDCE3 Method:", clazz);
    }

    private void parseFieldData(String Prefix, Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {

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

    private void parseMethodData(String Prefix, Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            int methodMod = method.getModifiers();
            String modifierString = Modifier.toString(methodMod);
            String methodName = method.getName();
            String methodReturnType = method.getReturnType().getName();
            if (method.getReturnType().getName().equals("java.lang.String")) {
                methodReturnType = "String";
            }
            String methodParameterTypes = method.getParameterTypes().toString();

            System.out.println(Prefix + " " + modifierString + " " + methodReturnType + " " + methodName + "(" + methodParameterTypes + ")");
        }
    }
}
