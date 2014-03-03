package main;

import classes.Example;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionClass {
    
    public static void main(String[] args) {

        Class exampleClass, interfaceClass, classInterfaces[];
        Constructor constructor, Constructors[];
        Field field, fields[];
        Method method, methods[];
        
        try {

            exampleClass = Class.forName("classes.Example");
            
            System.out.println("Class name:\n");
            System.out.println("\t" +exampleClass.getName());
            
            System.out.println("\nPackage name:\n");
            System.out.println("\t" +exampleClass.getPackage());
            
            System.out.println("\nSuperclass:\n");
            System.out.println("\t" +exampleClass.getSuperclass());
            
            System.out.println("\nInterfaces list:\n");
            classInterfaces = exampleClass.getInterfaces();
            for (int i = 0; i < classInterfaces.length; i++) {
                interfaceClass = classInterfaces[i];
                System.out.println("\t" + interfaceClass.getName());
            }
            
            System.out.println("\nConstructor:\n");
            try {
                constructor = exampleClass.getConstructor(new Class[] {String.class, String.class});
                try {
                    Example example = (Example) constructor.newInstance("R","l");
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(ReflectionClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("\t" + constructor.getName());
            } catch (NoSuchMethodException e) {
                System.out.println("It hasn't found the constructor. " + e);
            } catch (SecurityException ex) {
                Logger.getLogger(ReflectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("\nConstructors list:\n");
            Constructors = exampleClass.getConstructors();
            for (int i = 0; i < Constructors.length; i++) {
                constructor = Constructors[i];
                System.out.println("\t" + constructor.getName());
            }

            System.out.println("\nField:\n");
            try {
                field = exampleClass.getField("name");
                System.out.println("\t" + field.getName());
            } catch (NoSuchFieldException e) {
                System.out.println("It hasn't found the field. " + e);
            } catch (SecurityException ex) {
                Logger.getLogger(ReflectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("\nFields list:\n");
            fields = exampleClass.getFields();
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                System.out.println("\t" + field.getName());
            }
            
            System.out.println("\nMethod:\n");
            try {
                method = exampleClass.getMethod("setColor", new Class[] {String.class});
                System.out.println("\t" + method.getName());
            } catch (NoSuchMethodException e) {
                System.out.println("It hasn't found the method. " + e);
            } catch (SecurityException ex) {
                Logger.getLogger(ReflectionClass.class.getName()).log(Level.SEVERE, null, ex);
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
