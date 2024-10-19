package org.example.beanmanager;

import org.example.annotation.Inject;
import org.example.annotation.Provides;
import org.example.provider.H2ConnectionProvider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BeanManager {
    private static final BeanManager instance = new BeanManager();
    private final Map<Class<?>, Supplier<?>> registry = new HashMap<>();

    public static BeanManager getInstance() {
        return instance;
    }

    private BeanManager() {
        List<Class<?>> classes = List.of(H2ConnectionProvider.class);
        for (Class<?> clss : classes) {
            Method[] methods = clss.getDeclaredMethods();
            for (Method method: methods) {
                Provides provides = method.getAnnotation(Provides.class);
                if (provides != null) {
                    Class<?> returnType = method.getReturnType();
                    Supplier<?> supplier = () -> {

                        Object o = null;
                        try {
                            o = clss.getConstructor().newInstance();
                            if (!Modifier.isStatic(method.getModifiers())) {
                                o = clss.getConstructor().newInstance();
                                return method.invoke(o);
                            }
                            return method.invoke(null);
                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    };
                    registry.put(returnType, supplier);
                }
            }
        }
    }

    public <T> T getInstance(Class<T> clss) {
        try {
            T t = clss.getConstructor().newInstance();
            Field[] fields = clss.getDeclaredFields();
            for (Field field : fields) {
                Inject inject = field.getAnnotation(Inject.class);
                if (inject != null) {
                    Class<?> injectedFieldType = field.getType();
                    Supplier<?> supplier = registry.get(injectedFieldType);
                    Object objectToInject = supplier.get();
                    field.setAccessible(true);
                    field.set(t, objectToInject);
                }
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
