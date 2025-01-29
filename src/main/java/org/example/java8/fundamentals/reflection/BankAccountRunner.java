package org.example.java8.fundamentals.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class BankAccountRunner {

    public static void main(String[] args) throws ClassNotFoundException {
        var bankAccountRunner = new BankAccountRunner();
        BankAccount account = new BankAccount("1234");
        bankAccountRunner.doWork(account);

        Class<?> c = Class.forName("org.example.java8.fundamentals.reflection.BankAccount");
        bankAccountRunner.showName(c);

        bankAccountRunner.showName(BankAccount.class);
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


}
