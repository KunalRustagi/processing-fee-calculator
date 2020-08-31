package summary;
import java.util.Comparator;


public class SummarySort implements Comparator<SummaryTransaction> {
	public int compare(SummaryTransaction st1, SummaryTransaction st2) {
        if(!st1.getClientID().equals(st2.getClientID()))
        	return st2.getClientID().compareTo(st1.getClientID());
        else if(!st1.getType().equals(st2.getType())) {
        	return st1.getType().compareTo(st2.getType());
        }
        else if(!st1.getDate().toString().equals(st2.getDate().toString())) {
        	return st1.getDate().toString().compareTo(st2.getDate().toString());
        }
        else if(st1.getPriority()!=(st2.getPriority())) {
        	if(st1.getPriority()==(st2.getPriority()))
        		return 0;
        	return st1.getPriority()-st2.getPriority();
        }
        else {
        	return 0;
        }
    }
}
