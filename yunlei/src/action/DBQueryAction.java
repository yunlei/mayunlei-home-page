package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Running.database;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DBQueryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String queryStr;

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//Running.database db = new database("admin", "db");
		String result = database.runing(queryStr, "db", "admin");
		String html = "";
		String[] rows = result.split("<SQL>");
		for (int i = 0; i < rows.length; i++) {
			if (rows[i].startsWith("TABLE")) {
				String str = rows[i].substring(5, rows[i].length());
				String head = str.split("<head>")[0];
				String[] heads = head.split(",");
				String tmpresult = "";
				tmpresult+="<tr>";
				for (int j = 0; j < heads.length; j++) {
					tmpresult += "<th>" + heads[j] + "</th>";
				}
				tmpresult+="</tr>";
				if(str.split("<head>").length>1){
					String body = str.split("<head>")[1];
					
					String[] bodys = body.split(";");
					for (int j = 0; j < bodys.length; j++) {
						tmpresult += "<tr>";
						String[] cols = bodys[j].split(",");
						for (int s = 0; s < cols.length; s++) {
							tmpresult += "<td>" + cols[s] + "</td>";
						}
						tmpresult += "</tr>";
					}
				}
				html += "<div><table border=1px>" + tmpresult + "</table></div>";
			} else {
				html += "<div>" + rows[i] + "</div>";
			}

		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8"); // （1）一定要在（2）的前面，不然会乱码
		response.setCharacterEncoding("UTF-8"); // （2）
		PrintWriter out = null;
		
		out = response.getWriter();
		out.write(html);
		out.flush();
		out.close();
		return null;
	}

}
