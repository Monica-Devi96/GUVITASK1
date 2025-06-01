package JavaDatabaseConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTableCreate {

	public static void main(String[] args) {
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";

		try {
			Connection connection = DriverManager.getConnection(db_url, username, password);
			String create_DB="create database employe_details";
			String useDB="use employe_details";
			String createTable="create table employee(empcode int unique auto_increment,empname varchar(15),empage int,esalary int)";
			String alter_table="alter table employee auto_increment=101";
			String insert="insert into employee(empname,empage,esalary) values('Jenny',25,10000),('Jacky',30,20000),('Joe',20,40000),('John',40,80000),('Shameer',25,90000)";
			String select="Select * from employee";
			
			
            Statement smt = connection.createStatement();
			smt.execute(create_DB); 
			smt.execute(useDB);
			smt.execute(createTable);
			smt.execute(alter_table);
			smt.executeUpdate(insert);
			ResultSet result = smt.executeQuery(select); 
           while(result.next()) {
				
				 System.out.println(result.getInt("empcode")+"  "+result.getString("empname")+"    "+result.getInt("empage")+"  "+result.getInt("esalary"));
				 
           }
           connection.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
