package main;

import java.lang.reflect.*;

public class ReflectionNotFound {
    
    public static void main(String[] args) {

        Class exampleClass;
        Field field, fields[];
        Method method, methods[];
        
        try {

            exampleClass = Class.forName("classes.NotExist");

            System.out.println("Fields list:\n");
            fields = exampleClass.getFields();
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                System.out.println("\t" + field.getName());
            }

            System.out.println("\nMethods list:\n");
            methods = exampleClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                System.out.println("\t" + method.getName());
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("It hasn't found the class. " + e);
        }
    }  
}
