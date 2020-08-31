package runner;

import java.util.ArrayList;

import csvManager.Reader;
import csvManager.Writer;
import summary.SummaryTransaction;
import transaction.Processor;
import transaction.Transaction;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transactions = Reader.readCSV("Sample_Data_Fee_Calculator.csv");
		ArrayList<SummaryTransaction> reports = Processor.processTransactions(transactions);
		Writer.writeToFile(reports);
	}

}
