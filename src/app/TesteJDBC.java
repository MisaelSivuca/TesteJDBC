package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConnectionUtil;

public class TesteJDBC {

	public static void main(String[] args) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão realizada com Sucesso");
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = ((java.sql.Statement) stm).executeQuery("SELECT * FROM teste. `fabricante`;");
			while (rs.next()) {
				int Codigo_Fab = rs.getInt("Codigo_Fab");
				int cnpj = rs.getInt("cnpj");
				String Razao_Social = rs.getString("Razao_Social");
				String Nome_Fantasia = rs.getString("Nome_Fantasia");
				String Endereco = rs.getString("Endereco");
				String Email = rs.getString("Email");
				int Telefone = rs.getInt("Telefone");
				System.out.println("Codigo do Fabricante " + Codigo_Fab + "| CNPJ " + cnpj + "| Razão Social "
						+ Razao_Social + "| Nome de Fantasia " + Nome_Fantasia + "| Endereço " + Endereco + "| Eamil "
						+ Email + "| Telefone" + Telefone);
			}
			
			stm = (Statement) conn.createStatement();
			((java.sql.Statement) stm).executeUpdate(
					"INSERT INTO fabricante(cnpj, Razao_Social, Nome_Fantasia, Endereco, Email, Telefone) Values (12376425365, `TesteConexão LTDA`, `Conexão Med`, `Rua MySQL`, `conexão@mysql.com`, 3636-8084);");
			rs = ((java.sql.Statement) stm).executeQuery("SELECT * FROM teste. `fabricante`;");
			
			while (rs.next()) {
				int Codigo_Fab = rs.getInt("Codigo_Fab");
				int cnpj = rs.getInt("cnpj");
				String Razao_Social = rs.getString("Razao_Social");
				String Nome_Fantasia = rs.getString("Nome_Fantasia");
				String Endereco = rs.getString("Endereco");
				String Email = rs.getString("Email");
				int Telefone = rs.getInt("Telefone");
				System.out.println("Codigo do Fabricante " + Codigo_Fab + "| CNPJ " + cnpj + "| Razão Social "
						+ Razao_Social + "| Nome de Fantasia " + Nome_Fantasia + "| Endereço " + Endereco + "| Eamil "
						+ Email + "| Telefone" + Telefone);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Problema na conexao com o SGBD " + e.getMessage());
		}

	}

}
