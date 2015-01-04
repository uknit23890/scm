package data;

public class DataException extends Exception{
	
	public DataException() {
		super("Exception occured while connecting to database");
	}
	
	public DataException(String message){
		super(message);
	}

}
