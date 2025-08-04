//Encapsulation is a way of providing added security to the variables created inside a class
class Human{
    //from now we will have all the variables as private
    private int age;
    private String name;
//Constructor will have a same name as class name and does not have any return type
//constructor is called everytime when a new object of class is created
//It is used to intialise the instance variables os the same class
    public Human(){
        age=12;
        name="Kanishka";
    }
//The above constructor is a default constructor. We can also create parameterized constructor
//This PC is used to assign values to instance variables while creating an object of the same class
    public Human(int age,String name){
        this.age=age;
        this.name=name;
    }
    //private variables can only be accessed by getters and setters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    //This keyword is used to differentiate between local variable[int age (parameter)] and instance variable[private int age]
    //local varible carries the value and it will get assigned to instance variable
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Hello5 {
    public static void main(String[] args) {
        Human ref = new Human();
        System.out.println(ref.getAge()+" : "+ref.getName());
        ref.setAge(20);
        ref.setName("Monish");
        System.out.println(ref.getAge()+" : "+ref.getName());
        //creating an object for parameterized constructor
        Human ref2=new Human(23,"Apoorva");
        System.out.println(ref2.getAge()+" : "+ref2.getName());
    }
}
