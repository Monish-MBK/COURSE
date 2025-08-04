import java.sql.*;
public class Main {
    public static void main(String[] args) {
            String url="jdbc:postgresql://localhost:5432/CourseDemo";
            String uname="postgres";
            String pass="Paper";
            String sql = "select sname from students where sid = 1";
            String sql1 = "select * from students";
            String create ="insert into students values(5,'Virat',120)";
            String update = "update students set sname = 'Virat Kohli' where sid=5";
            String del = "delete from students where sid = 5;";
            try {
                Connection con = DriverManager.getConnection(url, uname, pass);
                System.out.println("connection established");
                Statement st = con.createStatement();
//                ResultSet re = st.executeQuery(sql);
//                re.next();
//                String name = re.getString("sname");
//                System.out.println("Student name is : "+name);
//                ResultSet rs=st.executeQuery(sql1);
//                while (rs.next()){
//                    System.out.print(rs.getInt(1)+" - ");
//                    System.out.print(rs.getString(2)+" - ");
//                    System.out.println(rs.getInt(3));
//                }
                st.execute(create);
                st.execute(update);
                st.execute(del);
                ResultSet rs=st.executeQuery(sql1);
                while (rs.next()){
                    System.out.print(rs.getInt(1)+" - ");
                    System.out.print(rs.getString(2)+" - ");
                    System.out.println(rs.getInt(3));
                }

                con.close();
                System.out.println("Connection closed");
            }catch (Exception e) {
                System.out.println("Some issues with the jdbc "+e);
            }


        }
    }
