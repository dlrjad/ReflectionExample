package main;

import java.lang.reflect.*;

public class ReflectionObjectOptimized {

    public static void main(String arg[]) {
        
        Class exampleClase;
        Object object;
        Method metGetColor, metSetColor;
        String result;
        Class[] classParamSetColorl;
        Object[] paramSetColor;
        
        try {

            exampleClase = Class.forName("classes.Example");

            try {
                object = exampleClase.newInstance();
                try {

                    metGetColor = exampleClase.getMethod("getColor", null);
                    result = (String) metGetColor.invoke(object, null);
                    System.out.println("getColor() = " + result);

                    classParamSetColorl = new Class[1];
                    classParamSetColorl[0] = Class.forName("java.lang.String");
                    metSetColor = exampleClase.getMethod("setColor", classParamSetColorl);
                    paramSetColor = new Object[1];
                    paramSetColor[0] = result + " new";
                    metSetColor.invoke(object, paramSetColor);
                    System.out.println("setColor()");

                    result = (String) metGetColor.invoke(object, null);
                    System.out.println("getColor() = " + result);
                    
                } catch (NoSuchMethodException e) {
                    System.out.println("Error to instantiate the object. " + e);
                } catch (SecurityException e) {
                    System.out.println("Error to instantiate the object. " + e);
                } catch (InvocationTargetException e) {
                    System.out.println("Error to instantiate the object. " + e);
                }
                
            } catch (InstantiationException e) {
                System.out.println("Error to instantiate the object. " + e);
            } catch (IllegalAccessException e) {
                System.out.println("Error to instantiate the object. " + e);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("It hasn't found the class. " + e);
        }
    }
}
