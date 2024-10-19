package org.example.beanmanager;

import jdk.internal.access.JavaSecurityAccess;
import org.example.annotation.Provides;
import org.example.orm.EntityManager;
import org.example.provider.H2ConnectionProvider;

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

    public <T> EntityManager<T> getInstance(Class<T> clss) {
        return null;
    }
}
