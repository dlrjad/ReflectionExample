package classes;

public class Example {
   
    public String name = "JAD";
    private String color = "red";

    public Example() {
    }
        
    public Example(String name, String color) {
        this.name = name;
        this.color = color;
    }

    private void setName(String s) {
        name = s;
    }

    protected String getName() {
        return name;
    }

    public void setColor(String s) {
        color = s;
    }

    public String getColor() {
        return color;
    }
    
    public String getValue(String value){
        System.out.print(value);
        return value;
    }
    
}
