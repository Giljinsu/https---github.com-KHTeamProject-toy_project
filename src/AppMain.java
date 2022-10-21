import java.sql.*;

public class AppMain {
    public static void main(String[] args)  {
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
            // - select statement
            AppSelect appSelect = new AppSelect();
            appSelect.SelectFunction(statement);
            // insert into
            AppInsert appInsert = new AppInsert();
            appInsert.InsertFunction(statement);
            // update
            AppUpdate appUpdate = new AppUpdate();
            appUpdate.UpdateFunction(statement);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
       
    }
}

