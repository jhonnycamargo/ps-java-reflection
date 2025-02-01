package org.example.java8.fundamentals.reflection;

import java.lang.reflect.*;

public class BankAccountRunner {

    public static void main(String[] args) throws ClassNotFoundException {
        var bankAccountRunner = new BankAccountRunner();
        BankAccount account = new BankAccount("1234");
        bankAccountRunner.doWork(account);

        Class<?> c = Class.forName("org.example.java8.fundamentals.reflection.BankAccount");
        bankAccountRunner.showName(c);

        bankAccountRunner.showName(BankAccount.class);

        BankAccount acct1 = new BankAccount("1234");
        bankAccountRunner.startWork("org.example.java8.fundamentals.reflection.AccountWorker", acct1);
    }

    void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }

    void doWork(Object obj) {
        Class<?> theClass = obj.getClass();
        showName(theClass);
    }

    void classInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        System.out.println("Class name: " + theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println("Super class: " + superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println("Interface: " + i.getSimpleName());
        }
    }

    void typeModifiers(Object obj) {
        Class<?> theClass = obj.getClass();
        int modifiers = theClass.getModifiers();
        if ((modifiers & Modifier.FINAL) > 0) {
            System.out.println("bitwise check - final");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println("method check - final");
        }
        if (Modifier.isPrivate(modifiers)) {
            System.out.println("method check - private");
        }
        if (Modifier.isProtected(modifiers)) {
            System.out.println("method check - protected");
        }
        if (Modifier.isPublic(modifiers)) {
            System.out.println("method check - public");
        }
    }

    void fieldInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        Field[] fields = theClass.getFields();
        displayFields(fields);

        Field[] declaredFields = theClass.getDeclaredFields();
        displayFields(declaredFields);
    }

    private void displayFields(Field[] fields) {
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType().getSimpleName());
            int modifiers = field.getModifiers();
            System.out.println("Field modifiers: " + modifiers);
            System.out.println("Field is public: " + Modifier.isPublic(modifiers));
            System.out.println("Field is protected: " + Modifier.isProtected(modifiers));
            System.out.println("Field is private: " + Modifier.isPrivate(modifiers));
            System.out.println("Field is static: " + Modifier.isStatic(modifiers));
            System.out.println("Field is final: " + Modifier.isFinal(modifiers));
            System.out.println("Field is transient: " + Modifier.isTransient(modifiers));
            System.out.println("Field is volatile: " + Modifier.isVolatile(modifiers));
            System.out.println();
        }
    }

    void methodInfo(Object obj) {
        Class<?> theClass = obj.getClass();
        var methods = theClass.getMethods();
        displayMethods(methods);

        var declaredMethods = theClass.getDeclaredMethods();
        displayMethods(declaredMethods);
    }

    private void displayMethods(Method[] methods) {
        for (Method m : methods) {
            System.out.println("Method name: " + m.getName());
            System.out.println("Method return type: " + m.getReturnType().getSimpleName());
            System.out.println("Method is public: " + Modifier.isPublic(m.getModifiers()));
            System.out.println("Method is protected: " + Modifier.isProtected(m.getModifiers()));
            System.out.println("Method is private: " + Modifier.isPrivate(m.getModifiers()));
            System.out.println("Method is static: " + Modifier.isStatic(m.getModifiers()));
            System.out.println("Method is final: " + Modifier.isFinal(m.getModifiers()));
            System.out.println("Method is synchronized: " + Modifier.isSynchronized(m.getModifiers()));
            System.out.println("Method is abstract: " + Modifier.isAbstract(m.getModifiers()));
            System.out.println("Method is native: " + Modifier.isNative(m.getModifiers()));
            System.out.println("Method is strict: " + Modifier.isStrict(m.getModifiers()));
            System.out.println();
        }
    }

    void methodInfo2(Object obj) {
        Class<?> theClass = obj.getClass();
        Method[] methods = theClass.getMethods();
        for (Method m : methods) {
            if (m.getDeclaringClass() != Object.class) {
                System.out.println("Method name: " + m.getName());
                System.out.println("Method return type: " + m.getReturnType().getSimpleName());
                Class<?>[] paramTypes = m.getParameterTypes();
                for (Class<?> paramType : paramTypes) {
                    System.out.println("Parameter type: " + paramType.getSimpleName());
                }
                System.out.println();
            }
        }
    }

    void callGetId(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> theClass = obj.getClass();
        Method m = theClass.getDeclaredMethod("getId");
        Object result = m.invoke(obj);
        System.out.println("Result: " + result);
    }

    void callDeposit(Object obj, int amt) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> theClass = obj.getClass();
        Method m = theClass.getMethod("deposit", int.class);
        m.invoke(obj, amt);
    }

    void startWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            Class<?> targetType = workerTarget.getClass();
            Constructor c = workerType.getConstructor(targetType);
            Object worker = c.newInstance(workerTarget);
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
                 | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
