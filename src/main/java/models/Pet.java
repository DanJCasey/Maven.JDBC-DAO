package models;

public class Pet implements model{
    private int id;
    private String name;
    private String type;
    private int age;
    private String color;
    private String sound;

    public Pet() {

    }
    public Pet(String name, int age, String type, String color, String sound) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.color = color;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = this.name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = this.age;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getSound(){
        return sound;
    }
    public void setSound(String sound){
        this.sound = sound;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}

