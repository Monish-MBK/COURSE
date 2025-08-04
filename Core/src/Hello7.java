//Super method is the very first line of every constructor even if we do not mention it explicitly
//Super method calls the default constructor of a parent class if we do not pass any parameter
//This method calls the default constructor of the same class
class A{
    public A() {
        super();                   //mentioning super class explicitly
        System.out.println("default cons of A");
    }
    public A(int a){
        this();                     //calls def cons of same class
        System.out.println("parameterised cons of A");
    }
}
class B extends A{
    public B(){
        super(5);                //calls para cons of parent class because of paramter
        System.out.println("default cons of B");
    }
    public B(int b){
        this();                     //calls def cons of same class
        System.out.println("parameterised cons of B");
    }
}

public class Hello7 {
    public static void main(String[] args) {
        B ref = new B(5);
    }
}
//Method overriding happens when both parent and child class have a method with same name and same parameters
//when you call the method by creating an object of child class it will call the child class method only and not parent class method
//Packages are basically name of a folder where in every file need to mention its package name
//A file can only access other files in the same class but if we need to access files of another folder we need to import that particular package


