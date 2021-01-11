package methods;

import java.sql.*;

public class Login {
	public boolean logIntoProgram(String query, String username, String password) {
		SQLConnection sql = new SQLConnection();
		
		try {
			Connection conn = sql.getConnection();
			//System.out.println("Successfull Connection!");
			
			PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            
            ResultSet res = ps.executeQuery();

            if(res.next()) {
                    return true;
            }
			
            conn.close();
		} catch (SQLException e) {
			System.out.println("Something's wrong...");
		}
		return false;
	}

}
