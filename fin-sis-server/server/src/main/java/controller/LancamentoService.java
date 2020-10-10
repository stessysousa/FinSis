package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.LancamentoDAO;
import model.Lancamento;

@WebServlet("/api/lancamentos/*")
public class LancamentoService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LancamentoService() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET BY ID
		// String pathInfo = request.getPathInfo();

//			if (pathInfo != null) {
//				String[] params = pathInfo.split("/");
		//
//				if (params.length > 0) {
//					Lancamento lancamento = LancamentoDAO.getLancamento(Integer.parseInt(params[1]));
		//
//					if (lancamento != null) {
//						JSONObject jsonObject = new JSONObject();
//						jsonObject.put("id", perfis.getId());
		// jsonObject.put("nome", lancamento.getNome());
		// jsonObject.put("tipo", lancamento.getTipo());
		//
//						response.setContentType("application/json");
//						response.setCharacterEncoding("UTF-8");
//						response.getWriter().print(jsonObject.toString());
//						response.getWriter().flush();
//					}
//					return;
//				}
//			}

		// GET BY NAME
//			if (request.getParameter("nome") != null) {
//				Lancamento lancamento = LancamentoDAO.getLancamentoByEmail(request.getParameter("nome"));
		//
//				if (lancamento != null) {
		//
//					JSONObject jsonObject = new JSONObject();
		//
//					jsonObject.put("id", usuario.getId());
//					jsonObject.put("id", perfis.getId());
		// 			jsonObject.put("nome", perfis.getNome());
		// 			jsonObject.put("tipo", perfis.getTipo());
		//
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					response.getWriter().print(jsonObject.toString());
//					response.getWriter().flush();
		//
//				}
//				return;
//			}

		// GET ALL
		List<Lancamento> list = LancamentoDAO.getAllLancamento();

		try {
			JSONArray jArray = new JSONArray();

			for (Lancamento lancamento : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", lancamento.getId());
				jsonObject.put("pagamento", lancamento.getPagamento());
				jsonObject.put("perfil", lancamento.getPerfil());
				jsonObject.put("nome", lancamento.getNome());
				jsonObject.put("fixo", lancamento.getFixo());
				jsonObject.put("descricao", lancamento.getDescricao());
				jsonObject.put("valor", lancamento.getValor());
				jsonObject.put("data", lancamento.getData());
				jsonObject.put("status", lancamento.getStatus());
				jsonObject.put("tipo", lancamento.getTipo());

				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Lancamento lancamento = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			lancamento = LancamentoDAO.addLancamento(jsonObject.getString("tipo"), jsonObject.getString("pagamento"),
					jsonObject.getString("perfil"), jsonObject.getString("nome"),
					jsonObject.getString("fixo"), jsonObject.getString("descricao"), jsonObject.getDouble("valor"),
					jsonObject.getString("data"), jsonObject.getString("status"));

			// Response
			jsonObject = new JSONObject();

			jsonObject.put("id", lancamento.getId());
			jsonObject.put("pagamento", lancamento.getPagamento());
			jsonObject.put("perfil", lancamento.getPerfil());
			jsonObject.put("nome", lancamento.getNome());
			jsonObject.put("fixo", lancamento.getFixo());
			jsonObject.put("descricao", lancamento.getDescricao());
			jsonObject.put("valor", lancamento.getValor());
			jsonObject.put("data", lancamento.getData());
			jsonObject.put("status", lancamento.getStatus());
			jsonObject.put("tipo", lancamento.getTipo());

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}

	// @Override
//		protected void doPut(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
	//
//			// UPDATE BY ID
//			String pathInfo = request.getPathInfo();
	//
//			if (pathInfo != null) {
//				String[] params = pathInfo.split("/");
	//
//				if (params.length > 0) {
//					StringBuffer jb = new StringBuffer();
//					String line = null;
//					try {
//						BufferedReader reader = request.getReader();
//						while ((line = reader.readLine()) != null)
//							jb.append(line);
//					} catch (Exception e) {
//					}
	//
//					Lancamento lancamento = null;
//					JSONObject jsonObject = null;
	//lancamento
//					try {
//						// Request
//						jsonObject = new JSONObject(jb.toString());
//						Lancamento = LancamentoDAO.updateUsuario(Integer.parseInt(params[1]), jsonObject.getString("email"),
//								jsonObject.getString("senha"));
	//
//						// Response
//						jsonObject = new JSONObject();
//						jsonObject.put("id", lancamento.getId());
//						jsonObject.put("formaPagamento", lancamento.getFormaPagamento());
//						jsonObject.put("perfil", lancamento.getPerfil());
	// 					jsonObject.put("nomeLancamento", lancamento.getNomeLancamento());
//						jsonObject.put("fixo", lancamento.getFixo());
	// 					jsonObject.put("descricao", lancaperfismento.getDescricao());
	// 					jsonObject.put("valor", lancamento.getValor());
	// 					jsonObject.put("data", lancamento.getData());
	// 					jsonObject.put("status", lancamento.getStatus());
	//					 jsonObject.put("tipo", lancamento.getTipo());
	//
//					} catch (JSONException e) {
//					}
	//
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					response.getWriter().print(jsonObject.toString());
//					response.getWriter().flush();
//				}
//			}
	// }

//		@Override
//		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			// DELETE BY ID
//			String pathInfo = request.getPathInfo();
	//
//			if (pathInfo != null) {
//				String[] params = pathInfo.split("/");
	//
//				if (params.length > 0) {
//					LancamentoDAO.deleteLancamento(Integer.parseInt(params[1]));
	//
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					response.getWriter().flush();
//				}
//			}
//		}

}
