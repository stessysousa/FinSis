package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.DbUtils;

public class UsuarioDAO {

	private static Connection connection = DbUtils.getConnection(); // propriedade de conexao com o banco, vai pegar os
	// dados no banco

	public static Usuario addUsuario(String nome, String email, String senha) {
		try {
			PreparedStatement pStmt = connection.prepareStatement( // define a sql
					"insert into usuario(nome, email, senha) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, nome);
			pStmt.setString(2, email);
			pStmt.setString(3, senha);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys(); // executa a instrução (inserir de fato)
			if (rs.next()) {
				return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Usuario> getAllUsuario() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario order by id");
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

}
