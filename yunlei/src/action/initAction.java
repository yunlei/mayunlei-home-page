package action;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

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
		userService.putIp(ip);
		return super.execute();
	}

}
