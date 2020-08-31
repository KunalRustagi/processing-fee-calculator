package summary;
import transaction.type;
import java.time.LocalDate;


public class SummaryTransaction {
	private String clientID;
	private type transactionType;
	private LocalDate date;
	private Double processingFee;
	private char priority;
	
	public SummaryTransaction(String clientID,type newtransactionType,LocalDate date,char priority) {
		this.clientID = clientID;
		this.transactionType = newtransactionType;
		this.date = date;
		this.processingFee = (double) 0;
		this.priority = priority;
	}
	@Override 
	public String toString(){
		return this.clientID + " " + this.transactionType + " " + this.date.toString() + " " + this.processingFee.toString() + " " + this.priority;
	}

	public String toKeyString(){
		return this.clientID+this.date.toString();
	}

	public void addFee(double fee) {
		this.processingFee += fee;
	}
	
	public String getClientID() {
		return this.clientID;
	}
	
	public type getType() {
		return this.transactionType;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public char getPriority() {
		return this.priority;
	}
	
	public Double getFee() {
		return this.processingFee;
	}
}
