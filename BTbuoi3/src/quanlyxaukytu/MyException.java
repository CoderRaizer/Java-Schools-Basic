package quanlyxaukytu;

public class MyException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String error;
	
	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	

}
