package tw.lin.bean;

public class Msg {

	private Integer id;
	private String message;

	public Msg() {
		super();
	}

	public Msg(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Msg [id=" + id + ", message=" + message + "]";
	}

}
