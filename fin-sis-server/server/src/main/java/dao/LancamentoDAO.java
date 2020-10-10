package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Lancamento;
import util.DbUtils;

public class LancamentoDAO {

	private static Connection connection = DbUtils.getConnection(); //propriedade de conexao com o banco, vai pegar os dados no banco

	public static Lancamento addLancamento(String tipo, String pagamento, String perfil, String nome,
			String fixo, String descricao, double valor, String data, String status) {
		try {
			PreparedStatement pStmt = connection.prepareStatement( // define a sql
					"insert into lancamento(perfil, nome, fixo, descricao, valor, data, status, tipo, pagamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			
			pStmt.setString(1, perfil);
			pStmt.setString(2, nome);
			pStmt.setString(3, fixo);
			pStmt.setString(4, descricao);
			pStmt.setDouble(5, valor);
			pStmt.setString(6, data);
			pStmt.setString(7, status);
			pStmt.setString(8, tipo);
			pStmt.setString(9, pagamento);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys(); //executa a instrução (inserir de fato)
			if (rs.next()) {
				return new Lancamento(rs.getInt("id"), rs.getString("tipo"), rs.getString("pagamento"),
						rs.getString("perfil"), rs.getString("nome"), rs.getString("fixo"),
						rs.getString("descricao"), rs.getDouble("valor"), rs.getString("data"), rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Lancamento> getAllLancamento() {
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from lancamento order by id");
			while (rs.next()) {
				Lancamento lancamento = new Lancamento(rs.getInt("id"), rs.getString("tipo"),
						rs.getString("pagamento"), rs.getString("perfil"), rs.getString("nome"),
						rs.getString("fixo"), rs.getString("descricao"), rs.getDouble("valor"), rs.getString("data"),
						rs.getString("status"));
				lancamentos.add(lancamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lancamentos;
	}

}