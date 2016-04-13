package joseph.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action{

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if (counter == null)
			counter = 1;
		else 
			counter++;
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUsername());
		if (getUsername().equals("joseph")
				&& getPassword().equals("123")){
			ctx.put("tip", "服务器提示，您已经登录成功！");
			return SUCCESS;
		}
		else{
			ctx.put("tip", "服务器提示，登录失败！");
			return ERROR;			
		}
		
	}
}
















