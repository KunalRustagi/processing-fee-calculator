package csvManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import summary.SummaryTransaction;
import com.opencsv.CSVWriter;

public class Writer {
	public static void writeToFile(ArrayList<SummaryTransaction> summary) {
		File file = new File("Output.csv"); 
	    try { 
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	        String[] header = { "Client ID ", "Transaction Type", "Transaction Date", "Priority","Processing Fees" }; 
	        writer.writeNext(header); 
	        List<String[]> data = new ArrayList<String[]>(); 
	        for(SummaryTransaction report:summary) {
	        	data.add(new String[] { report.getClientID(), report.getType().toString(), report.getDate().toString(),Character.toString((report.getPriority())),report.getFee().toString() });
	        }
	        writer.writeAll(data);
	        writer.close();
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	}
}
