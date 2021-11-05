package com.borshcheva.datastructure;

import java.lang.reflect.*;

public class ReflectionUtils {

    static Object create(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor = clazz.getConstructor();
        Object result = constructor.newInstance();
        return result;
    }

    public static void callMethodsWithoutParameters(Object object) throws IllegalAccessException, InvocationTargetException {
        Class clazz = object.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static void printSignatureMethodsWithFinal(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void printNotPublicMethods(Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method.getName());
            }
        }
    }

    public static void printClassAncestorsAndInterfaces(Class clazz) {
        Class[] ifs = clazz.getInterfaces();
        System.out.println("List of interfaces\n");
        for (Class<?> ifc : ifs) {
            System.out.println(ifc.getName());
        }
        Class superCls = clazz.getSuperclass();
        System.out.println(superCls);
    }

    public static void changedPrivateFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == int.class) {
                field.setInt(object, 0);
            } else if (field.getType() == boolean.class) {
                field.setBoolean(object, false);
            } else if (field.getType() == Object.class) {
                field.set(object, null);
            }

        }
    }
}
