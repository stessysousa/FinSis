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

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/api/usuario/*")
public class UsuarioService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioService() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET BY ID
	//	String pathInfo = request.getPathInfo();

//		if (pathInfo != null) {
//			String[] params = pathInfo.split("/");
//
//			if (params.length > 0) {
//				Usuario usuario = UsuarioDAO.getUsuario(Integer.parseInt(params[1]));
//
//				if (usuario != null) {
//					JSONObject jsonObject = new JSONObject();
//
//					jsonObject.put("id", usuario.getId());
//					jsonObject.put("nome", usuario.getNome());
//					jsonObject.put("email", usuario.getEmail());
//					jsonObject.put("senha", usuario.getSenha());
//
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					response.getWriter().print(jsonObject.toString());
//					response.getWriter().flush();
//				}
//				return;
//			}
//		}

		// GET BY NAME
//		if (request.getParameter("email") != null) {
//			Usuario usuario = UsuarioDAO.getUsuarioByEmail(request.getParameter("email"));
//
//			if (usuario != null) {
//
//				JSONObject jsonObject = new JSONObject();
//
//				jsonObject.put("id", usuario.getId());
//				jsonObject.put("nome", usuario.getNome());
//				jsonObject.put("email", usuario.getEmail());
//				jsonObject.put("senha", usuario.getSenha());
//
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().print(jsonObject.toString());
//				response.getWriter().flush();
//
//			}
//			return;
//		}

		// GET ALL
		List<Usuario> list = UsuarioDAO.getAllUsuario();

		try {
			JSONArray jArray = new JSONArray();

			for (Usuario usuario : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", usuario.getId());
				jsonObject.put("nome", usuario.getNome());
				jsonObject.put("email", usuario.getEmail());
				jsonObject.put("senha", usuario.getSenha());

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

		Usuario usuario = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			usuario = UsuarioDAO.addUsuario(jsonObject.getString("nome"), jsonObject.getString("email"), jsonObject.getString("senha"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", usuario.getId());
			jsonObject.put("nome", usuario.getNome());
			jsonObject.put("email", usuario.getEmail());
			jsonObject.put("senha", usuario.getSenha());

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}

	//@Override
//	protected void doPut(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// UPDATE BY ID
//		String pathInfo = request.getPathInfo();
//
//		if (pathInfo != null) {
//			String[] params = pathInfo.split("/");
//
//			if (params.length > 0) {
//				StringBuffer jb = new StringBuffer();
//				String line = null;
//				try {
//					BufferedReader reader = request.getReader();
//					while ((line = reader.readLine()) != null)
//						jb.append(line);
//				} catch (Exception e) {
//				}
//
//				Usuario usuario = null;
//				JSONObject jsonObject = null;
//
//				try {
//					// Request
//					jsonObject = new JSONObject(jb.toString());
//					usuario = UsuarioDAO.updateUsuario(Integer.parseInt(params[1]), jsonObject.getString("email"),
//							jsonObject.getString("senha"));
//
//					// Response
//					jsonObject = new JSONObject();
//					jsonObject.put("id", usuario.getId());
//					jsonObject.put("nome", usuario.getNome());
//					jsonObject.put("email", usuario.getEmail());
//					jsonObject.put("senha", usuario.getSenha());
//
//				} catch (JSONException e) {
//				}
//
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().print(jsonObject.toString());
//				response.getWriter().flush();
//			}
//		}
	//}

//	@Override
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// DELETE BY ID
//		String pathInfo = request.getPathInfo();
//
//		if (pathInfo != null) {
//			String[] params = pathInfo.split("/");
//
//			if (params.length > 0) {
//				UsuarioDAO.deleteUsuario(Integer.parseInt(params[1]));
//
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().flush();
//			}
//		}
//	}
}
