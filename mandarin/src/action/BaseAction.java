package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<TEntity, TService> extends ActionSupport implements ModelDriven<TEntity> {

	// 用于校验java对象的反序列化
	private static final long serialVersionUID = 1L;

	private TService service;
	private TEntity model;
	protected String errorMessage;

	// model
	public TEntity getModel() {
		return model;
	}

	public void setModel(TEntity model) {
		this.model = model;
	}
	
	// service
	public TService getService() {
		return service;
	}

	public void setService(TService service) {
		this.service = service;
	}
	
	// errorMessage
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
