//Throws is used to pass the exception handling task to someother class which calls that particular method which throws
//when 2 or more classes or methods has to handel the same type of exception and all those methods are called by the same class or method
//Then all these methods can throw it to same calling class

//public int a{
//    try{
//            b();
//        }catch(Exception e){
//
//        }
//
//        }
//public int b throws Exception{
//    c();
//    d();
//}
//public void c throws Exception{
//
//    some critical statement;
//}
//public void d throws Exception{
//
//    same critical statement;
//}
class Exe {
    //There is no class called calculator inside this entire project so this will throw an error
    //we are passing the responsibility of handling to the class or method which calls this method
    public void show() throws ClassNotFoundException{
        Class.forName("calculator");
    }
}
public class Exceptions8 {
    public static void main(String[] args) {
        Exe ref = new Exe();
        try{
            ref.show();
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
