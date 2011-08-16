package action;

import java.util.Map;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
public class initAction extends ActionSupport{

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
		Map  session = ActionContext.getContext().getSession();
		String ip=(String) session.getAttribute("IP");
		System.out.print(ip+"\n");
		userService.putIp(ip);
		return null;
	}

}
