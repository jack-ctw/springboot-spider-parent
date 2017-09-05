package cn.ctw.spider.info;

/**
 * 会有很多异常
 * 自定义异常类
 * @author jack
 *
 */
public class UserException extends Exception{

	private static final long serialVersionUID = 1L;
	//异常信息
	private String message;
	
	public UserException(){
		super();
	}
	
	public UserException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
