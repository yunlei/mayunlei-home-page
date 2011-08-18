package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class changeLangAction extends ActionSupport {

	/**
	 * 
	 */
	int langindex;

	public int getLangindex() {
		return langindex;
	}

	public void setLangindex(int langindex) {
		this.langindex = langindex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 8035360224815643537L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		session.put("langindex", langindex);
		//System.out.print("change language :" + langindex);
		return null;
	}

}
