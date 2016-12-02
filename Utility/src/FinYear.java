import java.util.Calendar;


public class FinYear {

	public String getFinYear(){
	
	int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
    String fromDate=null,toDate=null;
    
    if (month < 4) {

        fromDate=String.valueOf(year-2);
        toDate=String.valueOf(year-2001);


    } else {

        fromDate=String.valueOf(year-1);
        toDate=String.valueOf(year-2000);

    }
    
    return fromDate+"-"+toDate;
	
}
	
}
