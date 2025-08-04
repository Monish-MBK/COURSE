public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello World");

        int num = 10;
        int num1 = 20;
        int result = num + num1;
        System.out.println(result);

        //DATA TYPES
        int marks = 99;
        byte by = 127;
        short sh = 20;
        long lg = 5643l;
        float f= 5.8f;
        double d = 5.8;
        char ch = 'M';
        boolean bl = true;

        //LITERALS
        //TYPE CASTING
        int a = 127;
        byte b1 = (byte)a;
        System.out.println(b1);
        //ARITHMETIC OPERATORS
        //RELATIONAL OPERATORS
        //LOGICAL OPERATORS
        //CONDITIONAL STATEMENT
        int x = 8;
        int y = 19;
        int z = 10;
        if(x>y && x>z){
            System.out.println("x is greater");

        } else if (y>z) {
            System.out.println("y is greater");
        }
        else {
            System.out.println("z is greater");
        }
        //TERNARY OPERATION [condition?True:False]
        //SWITCH STATEMENTS
        int day = 5;
        switch (day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Enter a valid number");

        }
        //LOOPS
        int w = 1;
        while (w<=3){
            System.out.println("hi"+w);
            int v=1;
            while(v<=2){
                System.out.println("hello"+v);
                v++;
            }
            w++;
        }
        do {
            System.out.println("do"+w);
            w++;
        }while (w<=3);

        for(int i=5;i>=1;i--){
            for(int j =1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
