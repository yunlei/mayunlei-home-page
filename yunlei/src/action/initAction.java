package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class initAction extends ActionSupport {
    
	UserService userService;
	String ip;         

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		String ip;
		ActionContext ct = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ct
				.get(ServletActionContext.HTTP_REQUEST);
		ip = request.getRemoteAddr();
		
		System.out.print("init " + ip + "\n");
		if(ip==null)
			ip="1.1.1.1";
		userService.putIp(ip);
		return null;
	}

}
