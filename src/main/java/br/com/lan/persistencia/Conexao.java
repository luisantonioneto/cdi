package br.com.lan.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	
	
	public void abrirConexao(){
		try {
		/*	Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/cdi");
			Connection conn = ds.getConnection();
			//
			Statement statement = conn.createStatement();
			String sql = "select id, nome from Pessoa";
			ResultSet rs = statement.executeQuery(sql);
			//
			while(rs.next()){
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("nome"));
			}*/
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdi");
			EntityManager manager = factory.createEntityManager();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
;