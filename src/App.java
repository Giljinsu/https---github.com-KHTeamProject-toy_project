import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input : ");
        String input = scanner.next();
        // 데이터베이스 접근
        // Done - MY SQL workbench 실행 : 역할 JDBC 
        // - User/password와 접속 IP:port 접속
        String url = "jdbc:mysql://localhost:3306/study_sqls";
        String user = "root";
        String password = "*khacademy!";
        // - database 지정 
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
             // query Edit
            Statement statement = connection.createStatement(); // mysql에서 에디트 화면 띄운것
            // - select * from users;
            String query = "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(query); // 변수 담기
            // - 결과 출력
            while(resultSet.next()) {
            String UNIQUE_ID = resultSet.getString("UNIQUE_ID");
            System.out.print("UNIQUE_ID = "+UNIQUE_ID);
            System.out.print(", NAME = "+resultSet.getString("NAME"));
            System.out.print(", EMAIL = "+resultSet.getString("EMAIL"));
            System.out.print(", JOB = "+resultSet.getString("JOB"));
            System.out.println();
        }

        //query = "INSERT INTO users (UNIQUE_ID, NAME, EMAIL, JOB)"+
        //                "VALUES('U6', 'Jinsu', 'therin234@gmail.com', 'IT Billing')";
        //statement.execute(query);

        query = "UPDATE users SET NAME = 'SANG'";
        statement.execute(query);


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
       
    }
}
