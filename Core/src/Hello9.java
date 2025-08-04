//Wrapper class
public class Hello9 {
    public static void main(String[] args) {
        int num = 7;
        Integer num1 = new Integer(num);  //Boxing-converting a premitive datatype value into object type
        Integer num2 = num;               //Autoboxing-automatically converting
        int num3=num2.intValue();         //Unboxing-converting object type into premitive datatype int
        int num4=num2;                    //Auto unboxing-Automatically converting
        System.out.println(num1+" "+num2+" "+num3+" "+num4);


        String str = "20";
        int a = Integer.parseInt(str);    //ParseInt is a method of Integer class which converts string into int
        System.out.println(a+10);
    }
}
