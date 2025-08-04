//Exceptions are runtime errors that we handle using try catch blocks
//In try block we will write statements which might throw errors and in catch block we will handle those exceptions
//Exceptionas are of two types 1 uncheched exceptions    2 checked exceptions
//Unchecked exceptions are runtime exceptions example arithmatic arrayindexoutofrange and it is not compulasry to handle these exceptions
//Checked exceptions are SQL IO exceptions which are compulsary to handle
public class Exceptions6 {
    public static void main(String[] args) {
        int i=2;
        int j=0;
        int arr[]=new int[5];
        String str = null;

        try {
            j=18/i;
            //System.out.println(arr[5]);
            System.out.println(str.length());
        }
//we can write multiple catch block to handle specific exceptions
        catch (ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index value of array is out of range");
        }
        //This default exception should always be the last catch block
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(j);
    }
}
