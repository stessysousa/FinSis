package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Perfis;
import util.DbUtils;

public class PerfisDAO {

	private static Connection connection = DbUtils.getConnection(); // propriedade de conexao com o banco, vai pegar os
																	// dados no banco

	public static Perfis addPerfis(String nome, String tipo) {
		try {
			PreparedStatement pStmt = connection.prepareStatement( // define a sql
					"insert into perfis(nome, tipo) values (?, ?)", Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, nome);
			pStmt.setString(2, tipo);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys(); // executa a instrução (inserir de fato)
			if (rs.next()) {
				return new Perfis(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Perfis> getAllPerfis() {
		List<Perfis> perfil = new ArrayList<Perfis>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from perfis order by id");
			while (rs.next()) {
				Perfis perfis = new Perfis(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"));
				perfil.add(perfis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return perfil;
	}
}
