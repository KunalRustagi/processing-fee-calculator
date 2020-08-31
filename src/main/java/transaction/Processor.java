package transaction;
import java.util.ArrayList;
import java.util.HashMap;

import summary.SummarySort;
import summary.SummaryTransaction;


public class Processor {
	private static HashMap<String, SummaryTransaction> reports = new HashMap<String, SummaryTransaction>();
	public static ArrayList<SummaryTransaction> processTransactions(ArrayList<Transaction> transactions){
		ArrayList<SummaryTransaction> summary = new ArrayList<SummaryTransaction>();
		for(Transaction transaction:transactions) {
			SummaryTransaction report = new SummaryTransaction(transaction.getClientID(),transaction.getTransactionType(),transaction.getDate(),transaction.getPriority());
			calculateProcessingFee(report);
			checkIntraDay(report);
			summary.add(report);
		}
		summary.sort(new SummarySort());
		return summary;
	}
	
	public static void calculateProcessingFee(SummaryTransaction report) {
		char priorityFlag = report.getPriority();
		switch(priorityFlag) {
			case 'Y':
				report.addFee(500);
				break;
			case 'N':
			{
				type transactionType = report.getType();
				switch(transactionType) {
					case SELL:
					case WITHDRAW:
						report.addFee(100);
						break;
					case BUY:
					case DEPOSIT:
						report.addFee(50);
					default:
						break;
				}
				break;
					
			}
			default:
				break;
			
		}
	}
	
	public static void checkIntraDay(SummaryTransaction report) {
		if(reports.containsKey(report.toKeyString())) {
		    SummaryTransaction oldTransaction = reports.get(report.toKeyString());
		    oldTransaction.addFee(10);
		    report.addFee(10);
		    reports.remove(report.toKeyString());
		}
		else {
			reports.put(report.toKeyString(),report);
		}
	}
}
