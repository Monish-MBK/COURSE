//Enum is basically a class which contains named classes in the form of objects
enum Status{
    Running,Failed,Pending,Success;
}
//We can create an instance variable, methods, default constructors and parameterized constructor inside enum
enum Laptop{
    Macbook(2200),XPS(2000),Thinkpad(),Microsoft(1200);
    private int price;

    Laptop() {
        price=1500;
    }

    Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
public class Enum3 {
    public static void main(String[] args) {
        Status s = Status.Running;
        System.out.println(s);
        System.out.println(s.ordinal());

        Status stat[]=Status.values();
        for (Status st : stat){
            System.out.println(st+" : "+st.ordinal());
        }

        for (Laptop lap : Laptop.values()){
            System.out.println(lap+" : "+lap.getPrice());
        }

    }
}
