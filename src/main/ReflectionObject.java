package main;

import java.lang.reflect.*;

public class ReflectionObject {
    
    public static void main(String[] args){
        
        Class exampleClass;
        Object object;
        Field field, fields[];
        String value;
        
        try {

            exampleClass = Class.forName("classes.Example");

            try {
                
                object = exampleClass.newInstance();

                System.out.println("Field list:\n");
                fields = exampleClass.getFields();
                for (int i = 0; i < fields.length; i++) {
                    field = fields[i];

                    value = (String) field.get(object);
                    System.out.println("\t" + field.getName() + " = " + value + " ("
                            + field.getType().getName() + ")");

                    value += " new";
                    field.set(object, value);
                    System.out.println("\tNew value: " + field.getName() + " = " + value);
                }
                
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Error to instantiate the object. " + e);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("It hasn't found the class. " + e);
        }
    }
}
