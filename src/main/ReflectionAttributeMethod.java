package main;

import classes.Example;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionAttributeMethod {
    
    public static void main(String[] args) {

        Class exampleClass;
        Field field, fields[];
        Method method, methods[];
        
        try {

            exampleClass = Class.forName("classes.Example");
            
            System.out.println("\nFieldw list:\n");
            fields = exampleClass.getFields();
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                System.out.println("\t" + field.getName() + " (" + field.getType().getName() + ")");
            }

            System.out.println("\nMethods list:\n");
            methods = exampleClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                System.out.print("\t" + method.getName() + " (");

                Class parametros[] = method.getParameterTypes();
                for (int j = 0; j < parametros.length; j++) {
                    System.out.print(parametros[j].getName());
                    if (j < parametros.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print(") = " + method.getReturnType().getName());

                Class excepciones[] = method.getExceptionTypes();
                System.out.print(" [");
                for (int j = 0; j < excepciones.length; j++) {
                    System.out.print(excepciones[j].getName());
                    if (j < excepciones.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
            
            System.out.println("\nInvoke method:\n");
            try {
                method = exampleClass.getMethod("getValue", new Class[] {String.class});
                Example example = new Example();
                try {
                    method.invoke(example, new Object[]{"\t invoke getValue\n\n"});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(ReflectionAttributeMethod.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchMethodException e) {
                System.out.println("It hasn't found the method. " + e);
            } catch (SecurityException ex) {
                Logger.getLogger(ReflectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("It hasn't found the class. " + e);
        }
    }
}
