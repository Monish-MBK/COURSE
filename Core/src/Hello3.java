public class Hello3 {
    public static void main(String[] args) {
        int num[] = {5,6,7,8};
        num[1]=4;
        System.out.println(num[1]);

        int nums[]=new int[4];
        nums[0]=10;
        nums[1]=20;
        nums[2]=30;
        nums[3]=40;
        for (int i=0;i < nums.length;i++) {
            System.out.println(nums[i]);
        }

        //Multi Dimensional array
        int multi[][]=new int[3][4];

        for(int i=0;i<3;i++){
            for(int j=0;j<=3;j++){
                multi[i][j]=(int)(Math.random()*10);
            }
        }

        for(int i=0;i<3;i++){
            for (int j=0;j<=3;j++){
                System.out.print(multi[i][j] +" ");
            }
            System.out.println();
        }

        //Enhanced for loop for the above same loop
        for(int n[]:multi){                  //fetches the complete first array row "n[]"
            for(int m:n){                    //fetches the each element 'm' for the array row "n[]"
                System.out.print(m +" ");
            }
            System.out.println();
        }

        //Jagged array
        int jagged[][]=new int[3][];
        jagged[0]=new int[4];
        jagged[1]=new int[3];
        jagged[2]=new int[5];

        for(int i=0;i<jagged.length;i++){
            for(int j=0;j<jagged[i].length;j++){
                jagged[i][j]=(int)(Math.random()*10);
            }
        }
        for(int n[]:jagged){
            for(int m:n){
                System.out.print(m +" ");
            }
            System.out.println();
        }

        //ARRAY OF OBJECTS
        Student s1 = new Student();
        s1.rollno=1;
        s1.name="Monish";
        s1.marks=100;

        Student s2 = new Student();
        s2.rollno=2;
        s2.name="Kanishka";
        s2.marks=99;

        Student s3 = new Student();
        s3.rollno=3;
        s3.name="Apoorva";
        s3.marks=98;

        Student students[] = new Student[3];
        students[0]=s1;
        students[1]=s2;
        students[2]=s3;

        for (int i=0;i<students.length;i++){
            System.out.println(students[i].rollno +" : " + students[i].name +" : "+ students[i].marks);
        }
        for(Student stud : students){
            System.out.println(stud.rollno+" : "+stud.name+" : "+stud.marks);
        }
    }
}
class Student{
    int rollno;
    String name;
    int marks;
}

//Enhanced for loop is used only on arrays and collections