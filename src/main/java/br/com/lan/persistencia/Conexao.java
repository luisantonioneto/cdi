package br.com.lan.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexao {

	public void abrirConexao(){
		try {
			Context initContext = new InitialContext();
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
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
