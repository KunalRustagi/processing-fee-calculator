package transaction;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class Transaction {
	private String externalID;
	private String clientID;
	private String securityID;
	private type transactionType;
	private LocalDate date;
	private Double value;
	private char priority;
	
	public Transaction(String externalID,String clientID,String securityID,String transactionType,String date,String value,String priority) {
		this.externalID=externalID;
		this.clientID=clientID;
		this.securityID=securityID;
		this.transactionType=Enum.valueOf(type.class,transactionType);
		this.date=LocalDate.parse(date, DateTimeFormatter.ofPattern("LL/dd/yyyy"));
		this.value=Double.parseDouble(value);
		this.priority=priority.charAt(0);
		
	}
	public String getClientID() {
		return this.clientID;
	}
	public type getTransactionType() {
		return this.transactionType;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public char getPriority() {
		return this.priority;
	}
	
}
