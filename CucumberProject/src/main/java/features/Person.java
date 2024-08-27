package features;

public class Person {

	private Integer distance;
	private String msg;

	public void setDistance(Integer distance) {
		// TODO Auto-generated method stub
		this.distance = distance;
	}

	public void setMessage(String msg) {
		// TODO Auto-generated method stub
		if(distance>0 && distance<=200)
		this.msg = msg;
		else
		this.msg = null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return this.msg;
	}

}
