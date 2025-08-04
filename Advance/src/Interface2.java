//Interface is a class in which all the methods are abstract by default
//Child class will declare all these abstract methods
//Cannot create an object of interface class but the child class can create an object of type parent
//All the variables are by default final and static, all the varibles can be called using inteface class itself
//Child class can implement multiple interface classes
//Class x implements y,z{ }
//One interface class can extend or inherit another interface
interface supercar{
        int age = 25;
        String area = "Bangalore";
        void drive();
        void fly();
}
class Ferari implements supercar{
    public void drive() {
        System.out.println("driving");
    }
    public void fly() {
        System.out.println("flying");
    }
}
public class Interface2 {
    public static void main(String[] args) {
        supercar ref1 = new Ferari();
        ref1.drive();
        ref1.fly();
        System.out.println(supercar.age+" : "+supercar.area);
    }
}
//Class  extends class
//class implements interface
//interface extends interface
