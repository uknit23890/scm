package data;

public class InvalidUserIdException extends DataException {
	public InvalidUserIdException() {
		super("The Userid or Password is invalid");
	}
}
 