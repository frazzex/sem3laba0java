package app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class Invoker {

    private static Object[] buildArgs(Method method) {
        Class<?>[] types = method.getParameterTypes();
        Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            if (types[i] == String.class) args[i] = "тест";
            else if (types[i] == int.class) args[i] = 5;
            else if (types[i] == boolean.class) args[i] = true;
            else if (types[i] == double.class) args[i] = 1.0;
            else if (types[i] == long.class) args[i] = 1L;
            else args[i] = null;
        }
        return args;
    }

    public static void runAllProtectedPrivateMethods(Object myClass) {

        for (Method method : myClass.getClass().getDeclaredMethods()) {
            if (! method.isAnnotationPresent(Repeat.class)) continue;

            if (Modifier.isPublic(method.getModifiers())) continue;

            Repeat repeat = method.getAnnotation(Repeat.class);

            int times = repeat.times();

            method.setAccessible(true);
            Object[] args = buildArgs(method);

            for (int i = 0; i < times; i++) {
                try {
                    method.invoke(myClass, args);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    continue;
                }
            }


        }

    }
}
