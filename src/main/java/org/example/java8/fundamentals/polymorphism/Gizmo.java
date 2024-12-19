package org.example.java8.fundamentals.polymorphism;

public class Gizmo implements Widget, PersistentObject {

    private String helpText;

    public Gizmo(String helpText) {
        this.helpText = helpText;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }

    @Override
    public void save() {
        System.out.println("Saving Gizmo");
    }
}
