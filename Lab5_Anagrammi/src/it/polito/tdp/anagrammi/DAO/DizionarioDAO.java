package it.polito.tdp.anagrammi.DAO;

import java.sql.*;


public class DizionarioDAO {

	public boolean isCorrect(String anagramma){
		
		final String sql =  "SELECT nome "+
							"FROM parola "+
							"WHERE nome=?";

		boolean t = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				t = true;
				
			}
			conn.close();
			return t;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}
