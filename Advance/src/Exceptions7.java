//throw keyword basically throw exceptions which will be catched by catch block
//we can throw already existing exceptions or we can create our own exception class by extending exception class
class CustomException extends Exception{
    //Creating a parameterized constructor to pass an exception message
    public CustomException(String string){
        //passing to message to parent class using super method
        super(string);
    }
}
public class Exceptions7 {
    public static void main(String[] args) {
        int i=1;
        int j=0;
        try{
            j=18/i;
            if(i==0){
                //throw is thowing an arithmetic exception and we are passing a custom exception message and not the actual Arithmetic Exception Message
                throw new ArithmeticException("This is a custom exception");
            }
            if (i==1){
                throw new CustomException("The Number is 1");
            }
        }catch (ArithmeticException e){
            j=18/18;
            System.out.println(e);
            System.out.println("Divided the number by itself");
        }
        catch (CustomException e){
            System.out.println(e);

        }
        catch (Exception e){
            System.out.println(e);

        }
        System.out.println(j);
    }
}
