//Abstract methods can only be defined and it will not have any body
//every abstract method can be defined only inside an abstract class
//All these abstract methods should be defined inside its child class
//Cannot create an object of abstract class but the child class can create an object of its parent type
abstract class Car{
    public abstract void drive();
    public abstract void fly();
    public void playMusisc(){
        System.out.println("playing music");
    }
}
class BMW extends Car {


    public void drive() {
        System.out.println("Diving");
    }

    public void fly() {
        System.out.println("Flying");
    }
}
public class Abstract1 {
    public static void main(String[] args) {
        Car ref = new BMW();
        ref.drive();
        ref.fly();
        ref.playMusisc();
    }
}
