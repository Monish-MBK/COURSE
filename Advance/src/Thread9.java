//Running more application or software at a same time in one OS is called mullti tasking
//Running multiple things in a single software is called threads
//Suppose you have 2 different methods in 2 different classes and you have created an object of these two classes and called the method
//Now you want these 2 methods to run parallely then we can use threads
//Firstly both the classes need to extend threads and menthod name should be run() while calling the methods we cannot use the methods name, we have to use start()
class First extends Thread{
    public void run(){
        for (int i =0;i<100;i++){
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Second extends Thread{
    public void run(){
        for (int i=0;i<100;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Thread9 {
    public static void main(String[] args) {
        First ref = new First();
        Second ref1 = new Second();

        ref.start();
        ref1.start();
    }
}
//Thread scheduler priority
//10 has the highest priority
//1 has the lowest priority
//5 has the default priority
//In order to stop the thread for a particular period of time we can use sleep
