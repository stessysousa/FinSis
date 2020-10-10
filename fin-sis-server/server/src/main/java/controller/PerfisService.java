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

import dao.PerfisDAO;
import model.Perfis;

@WebServlet("/api/perfis/*")
public class PerfisService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PerfisService() {
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
//					Perfis perfis = PerfisDAO.getPerfis(Integer.parseInt(params[1]));
		//
//					if (perfis != null) {
//						JSONObject jsonObject = new JSONObject();
//						jsonObject.put("id", perfis.getId());
		// 				jsonObject.put("nome", perfis.getNome());
		// 				jsonObject.put("tipo", perfis.getTipo());
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
//				Perfis perfis = UsuarioDAO.getPerfisByName(request.getParameter("nome"));
		//
//				if (perfis != null) {
		//
//					JSONObject jsonObject = new JSONObject();
		//
//						jsonObject.put("id", perfis.getId());
		// 				jsonObject.put("nome", perfis.getNome());
		// 				jsonObject.put("tipo", perfis.getTipo());
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
		List<Perfis> list = PerfisDAO.getAllPerfis();

		try {
			JSONArray jArray = new JSONArray();

			for (Perfis perfis : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", perfis.getId());
				jsonObject.put("nome", perfis.getNome());
				jsonObject.put("tipo", perfis.getTipo());

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

		Perfis perfis = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			perfis = PerfisDAO.addPerfis(jsonObject.getString("nome"), jsonObject.getString("tipo"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", perfis.getId());
			jsonObject.put("nome", perfis.getNome());
			jsonObject.put("tipo", perfis.getTipo());

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
//					Perfis perfis = null;
//					JSONObject jsonObject = null;
	//
//					try {
//						// Request
//						jsonObject = new JSONObject(jb.toString());
//						perfis = PerfisDAO.updatePerfis(Integer.parseInt(params[1]), jsonObject.getString("tipo"));
	//
//						// Response
//						jsonObject = new JSONObject();
//						jsonObject.put("id", perfis.getId());
//						jsonObject.put("nome", perfis.getNome());
//						jsonObject.put("tipo", perfis.getTipo());
//						
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
//					PerfisDAO.deletePerfis(Integer.parseInt(params[1]));
	//
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//					response.getWriter().flush();
//				}
//			}
//		}

}
