package in.net.dpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import in.net.dpl.dto.*;
import in.net.dpl.utility.*;

public class Project 
{
public ArrayList<FeedObjects> GetFeeds(String param1,String param2) throws Exception
	{
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
			try
			{
			
			
			Connection conn=new ConnDB().make_connection();	
			PreparedStatement ps = conn.prepareStatement("SELECT title,description,url,id FROM website ORDER BY id DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			FeedObjects feedObject = new FeedObjects();
			feedObject.setTitle(rs.getString("title"));
			feedObject.setDescription(rs.getString("description"));
			feedObject.setUrl(rs.getString("url"));
			feedObject.setId(rs.getString("id"));
			
			feedData.add(feedObject);
			}
			return feedData;
			}
			catch(Exception e)
			{
			throw e;
			}finally{
			
			}
	}

public String consumerAuth(String consumerNo,String meterNo) throws Exception
{
	String name=null;
	String conNo=null;
	System.out.println("Inside Auth");
	
	
		try
		{
		
		Connection conn=new ConnDB().make_connection();	
//**Charge- Start

	PreparedStatement ps = conn.prepareStatement("SELECT con_no,meter_no,name FROM v_login WHERE con_no='"+consumerNo+"' AND meter_no='"+meterNo+"' ");

//**Change- End
		ResultSet rs = ps.executeQuery();
		int counter=0;
		while(rs.next())
		{
		counter++;	
		name=rs.getString(3);
		conNo=rs.getString(1);
		System.out.println("Name-"+name);
		System.out.println("Con No-"+name);
		
		}
		
		if(counter>0){
		return name+"|"+conNo;
		
		}
		else return "UNAUTHORIZED";
		
		}
		catch(Exception e)
		{
		throw e;
		}
}

public ArrayList<Consumer> getDashboard(String conNo) {
	
 System.out.println("Inside Dash Borad WS, Con No-"+conNo);
	
	ArrayList<Consumer> feedData = new ArrayList<Consumer>();
	try
		{
		
		String partyCode,partyName,address,reference,category,tariff,phase,demand,mf;
		Connection conn=new ConnDB().make_connection();	
		PreparedStatement ps = conn.prepareStatement("SELECT party_code,party_name,address,reference,category,tariff,con_phase,demand,mf FROM v_dashboard WHERE con_no='"+conNo+"'");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			
		Consumer consumer = new Consumer();
		partyCode=rs.getString(1);
		partyName=rs.getString(2);
		address=rs.getString(3);
		reference=rs.getString(4);
		category=rs.getString(5);
		tariff=rs.getString(6);
		phase=rs.getString(7);
		demand=rs.getString(8);
		mf=rs.getString(9);
		consumer.setPartyCode(partyCode);
		consumer.setConsumerName(partyName);
		consumer.setAddress(address);
		consumer.setReference(reference);
		consumer.setCategory(category);
		consumer.setCategory(category);
		consumer.setTariffType(tariff);
		consumer.setPhase(phase);
		consumer.setContractDemand(demand);
		consumer.setMulFactor(mf);
		feedData.add(consumer);
		
		}
		return feedData;
		}
		
		catch(SQLException e)
		{
		e.printStackTrace();
		}
	
	return null;
}


public ArrayList<Consumer> fetchCurrBill(String conNo) {
	
	
		
		ArrayList<Consumer> feedData = new ArrayList<Consumer>();
		try
			{
			
			String month,lastReading,presentReading,meterStatus,amountDue,tariff,phase,demand,mf,unit,due1,due2;
			Connection conn=new ConnDB().make_connection();	
			PreparedStatement ps = conn.prepareStatement("SELECT MONTH,last_read,curr_read,mf,meter_status,unit,bill_amount,DATE_FORMAT(due_date1,'%d-%m-%Y') AS due_date1,DATE_FORMAT(due_date2,'%d-%m-%Y') AS due_date2 FROM v_curr_bill where con_no='"+conNo+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
			Consumer consumer = new Consumer();
			month=rs.getString(1);
			lastReading=rs.getString(2);
			presentReading=rs.getString(3);
			mf=rs.getString(4);
			meterStatus=rs.getString(5);
			unit=rs.getString(6);
			amountDue=rs.getString(7);
			due1=rs.getString(8);
			due2=rs.getString(9);
			consumer.setMonth(month);
			consumer.setPrevReading(lastReading);
			consumer.setCurrReading(presentReading);
			consumer.setMulFactor(mf);
			consumer.setMeterStatus(meterStatus);
			consumer.setUnit(unit);
			consumer.setAmountDue(amountDue);
			consumer.setDue1(due1);
			consumer.setDue2(due2);
			feedData.add(consumer);
			
			}
			return feedData;
			}
			
			catch(SQLException e)
			{
			e.printStackTrace();
			}
		
		return null;
	}

public ArrayList<Tariff> fetchTariff(String conNo) {
	
	
	
	ArrayList<Tariff> feedData = new ArrayList<Tariff>();
	try
		{
		
		//change- new Start

		
				String ph=null;
				String phname=null;
				String mnth1=null;
				String mnth2=null;
				String cat=null;
				String catname=null;
				String fy=null;
				String mtr=null;

				Connection conn=new ConnDB().make_connection();	
				PreparedStatement ps1 = conn.prepareStatement("SELECT ph, phase, month1, month2, cat_type, category, fin_year, meter_no FROM v_login WHERE con_no='"+conNo+"'");
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next())
				{
					
					ph=rs1.getString(1);
					phname=rs1.getString(2);
					mnth1=rs1.getString(3);
					mnth2=rs1.getString(4);
					cat=rs1.getString(5);
					catname=rs1.getString(6);
					fy=rs1.getString(7);
					mtr=rs1.getString(8);
				}

		String head,consumption;
		double rate;
		//Connection conn=new ConnDB().make_connection();	
//**Charge- Start

		//PreparedStatement ps = conn.prepareStatement("SELECT head,consumption,rate FROM v_tariff where con_no='"+conNo+"'");
		
		//PreparedStatement ps = conn.prepareStatement("SELECT 'Energy Charge' AS head,IF((LOWER_UNIT = 1),IF((UPPER_UNIT = 999999),'On All Units',CONCAT('UPTO ',UPPER_UNIT,' Units')),IF((UPPER_UNIT<999999),CONCAT('Next ',((UPPER_UNIT-LOWER_UNIT) + 1),' Units'),CONCAT('Above ',(LOWER_UNIT - 1),' Units'))) AS Consumption, RATE FROM consdb.p_rate WHERE CAT_TYPE = '" + cat + "' AND FIN_YEAR = '" + fy + "' AND MATTER = 'E' UNION SELECT 'Fixed Charge' AS head,IF(add_amount<0, 'per KVA per Month', 'per Month') AS Consumption, IF(add_amount<0,RATE,add_amount) AS rate FROM consdb.p_rate WHERE CAT_TYPE = '" + cat + "' AND FIN_YEAR = '" + fy + "' AND MATTER = 'X' UNION SELECT CONCAT('MVCA for ',SUBSTR(MONTHNAME(STR_TO_DATE((MONTH%100),'%m')),1,3),'-',SUBSTR(MONTH,3,2)) AS head,'On All Units' AS Consumption, RATE FROM consdb.p_vrate WHERE `month` = '" + mnth1 + "' OR `month` = '" + mnth2 + "' UNION  SELECT 'Government Duty(%)' AS head,IF((LOWER_UNIT = 1),IF((UPPER_UNIT = 999999),'On All Units',CONCAT('UPTO ',UPPER_UNIT,' Units')),IF((UPPER_UNIT<999999),CONCAT('Next ',((UPPER_UNIT-LOWER_UNIT) + 1),' Units'),CONCAT('Above ',(LOWER_UNIT - 1),' Units'))) AS Consumption, RATE FROM consdb.p_rate WHERE CAT_TYPE = '" + cat + "' AND FIN_YEAR = '" + fy + "' AND MATTER = 'D' UNION  SELECT 'Meter Rent/Month' AS head,CONCAT('For ', '" + phname + "' ,' Phase') AS Consumption, AMOUNT AS RATE FROM consdb.p_mrent WHERE FIN_YEAR = '" + fy + "' AND METER_TYPE = 'E' AND PHASE = '" + ph + "' AND CAT_TYPE = '" + cat + "' ") ;
		
		PreparedStatement ps= conn.prepareStatement("SELECT IF(matter = 'E', 'Energy Charge', IF(matter = 'D', 'Government Duty(%)','Fixed Charge')) AS head,IF((LOWER_UNIT = 1),IF((UPPER_UNIT = 999999),'On All Units',CONCAT('UPTO ',UPPER_UNIT,' Units')),IF((UPPER_UNIT<999999),CONCAT('Next ',((UPPER_UNIT-LOWER_UNIT) + 1),' Units'),CONCAT('Above ',(LOWER_UNIT - 1),' Units'))) AS Consumption, truncate(RATE,2) AS RATE, IF(matter = 'E', '1', IF(matter = 'D', '4','2')) AS matter, upper_unit FROM consdb.p_rate WHERE CAT_TYPE = '" + cat + "' AND FIN_YEAR = '" + fy + "' AND (MATTER = 'E' OR MATTER = 'X' OR MATTER = 'D') UNION SELECT CONCAT('MVCA for ',SUBSTR(MONTHNAME(STR_TO_DATE((MONTH%100),'%m')),1,3),'-',SUBSTR(MONTH,3,2)) AS head,'On All Units' AS Consumption, truncate(RATE,2) AS RATE, '3' AS matter, MONTH AS upper_unit FROM consdb.p_vrate WHERE `month` = '" + mnth1 + "' OR `month` = '" + mnth2 + "' UNION  SELECT 'Meter Rent/Month' AS head,CONCAT('For ', '" + phname + "' ,' Phase') AS Consumption, truncate(AMOUNT,2) AS RATE, '5' AS matter, 0 AS upper_unit FROM consdb.p_mrent WHERE FIN_YEAR = '" + fy + "' AND METER_TYPE = 'E' AND PHASE = '" + ph + "' AND CAT_TYPE = '" + cat + "' ORDER BY matter, upper_unit ");

//**Charge- End
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			
		Tariff tariff = new Tariff();
		//System.out.println("converted-"+	rs.getString(1).replaceAll("\\s","").substring(0, 4).toLowerCase());
		if(rs.getString(1).replaceAll("\\s","").toLowerCase().substring(0, 4).matches("gove")){
			head=rs.getString(1);
			consumption=rs.getString(2);
			rate=rs.getDouble(3);
			tariff.setHead(head);
			tariff.setConsumption(consumption);
			tariff.setRate(String.format("%.2f", rate));
			//System.out.println("Rate-"+rate);
			//System.out.println("Rate-"+rs.getDouble("RATE"));
			feedData.add(tariff);
		}
		else{
			System.out.println("Rate-"+rs.getDouble("RATE"));
			head=rs.getString(1);
			consumption=rs.getString(2);
			rate=rs.getDouble(3);
			tariff.setHead(head);
			tariff.setConsumption(consumption);
			tariff.setRate("Rs "+String.format("%.2f", rate));
			feedData.add(tariff);
		}
		
		
		
		}
		return feedData;
		}
		
		catch(SQLException e)
		{
		e.printStackTrace();
		}
	
	return feedData;
}


public ArrayList<BillHistory> billHistory(String conNo) 
{
	ArrayList<BillHistory> feedData = new ArrayList<BillHistory>();
		try
		{
		
		
		Connection conn=new ConnDB().make_connection();	
		PreparedStatement ps = conn.prepareStatement("SELECT con_no,party_code,name,MONTH,last_read,curr_read,mf,meter_status,unit,bill_amount,DATE_FORMAT(due_date1,'%d-%m-%Y') AS due_date1,DATE_FORMAT(due_date2,'%d-%m-%Y') AS due_date2 FROM v_last_3_bill WHERE con_no='"+conNo+"' ORDER BY bill_month DESC LIMIT 3");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		BillHistory feedObject = new BillHistory();
		feedObject.setConNo(rs.getString("con_no"));
		feedObject.setPartyCode(rs.getString("party_code"));
		feedObject.setName(rs.getString("name"));
		feedObject.setBillMonth(rs.getString("month"));
		feedObject.setLastRead(rs.getString("last_read"));
		feedObject.setCurrRead(rs.getString("curr_read"));
		feedObject.setMf(rs.getString("mf"));
		feedObject.setMeterStatus(rs.getString("meter_status"));
		feedObject.setUnit(rs.getString("unit"));
		feedObject.setBillAmount(rs.getString("bill_amount"));
		feedObject.setDueDate1(rs.getString("due_date1"));
		feedObject.setDueDate2(rs.getString("due_date2"));
		feedData.add(feedObject);
		}
		return feedData;
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return feedData;
}

public String conPattern(String conNo) 
{
	ArrayList<ConsumptionPattern> feedData = new ArrayList<ConsumptionPattern>();
	StringBuilder str = new StringBuilder();
		try
		{
				
		Connection conn=new ConnDB().make_connection();	
		PreparedStatement ps = conn.prepareStatement("SELECT DATE_FORMAT(STR_TO_DATE(bill_month,'%Y%m'),'%M-%y') AS bill_month,CAST(unit AS CHAR) AS unit  FROM v_last_3_bill  WHERE con_no='"+conNo+"' ORDER BY STR_TO_DATE(bill_month,'%Y%m') DESC LIMIT 3");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			if(str.length()>0)
			str.append("|"+rs.getString(1)+"|"+rs.getString(2));
			else
			str.append(rs.getString(1)+"|"+rs.getString(2));	
			
		}
		
		
		return str.toString();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return str.toString();
}

public String updateEmail(String conNo,String emailId) 
{
	

//**Charge- Start

		try
		{
		 Connection conn=new ConnDB().make_connection();	
		 Statement stmt=conn.createStatement();
		 stmt.executeUpdate("update consdb.m_party set email_id='"+emailId+"' where party_code='"+conNo+"'");
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return "SUCCESS";

//**Charge- End

}


public String updateMobile(String conNo,String mobile) 
{
	
//**Charge- Start

		try
		{
		 Connection conn=new ConnDB().make_connection();	
		 Statement stmt=conn.createStatement();
		 stmt.executeUpdate("update consdb.m_party set mob_no='"+mobile+"' where party_code='"+conNo+"'");
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return "SUCCESS";

//**Charge- End	

}



public String calculateBill(String conNo,String unit) 
{
	
	
	double billAmt=0.0;
	String phase=null;
	double load=0.0;
	double energyCharge=0.0;
	double fixedCharge=0.0;
	double meterRent=0.0;
	double mvca=0.0;
	double dutyPer=0.0;
	double dutyAmt=0.0;
	String billAmtAsString=null;
	String ph=null;
	String phname=null;
	String mnth1=null;
	String mnth2=null;
	String cat=null;
	String catname=null;
	String fy=null;
	String mtr=null;

	
//**Charge- Start

		double unitAsDouble=0;
	
		try{
		     unitAsDouble=Double.parseDouble(unit);
		}catch(NumberFormatException ex){
		
			ex.printStackTrace();
		}


		try
		{

			
			
			
			//change- new Start

			
			

			Connection conn=new ConnDB().make_connection();	
			PreparedStatement ps1 = conn.prepareStatement("SELECT ph, phase, month1, month2, cat_type, category, fin_year, meter_no, con_load FROM v_login WHERE con_no='"+conNo+"'");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				
				ph=rs1.getString(1);
				phname=rs1.getString(2);
				mnth1=rs1.getString(3);
				mnth2=rs1.getString(4);
				cat=rs1.getString(5);
				catname=rs1.getString(6);
				fy=rs1.getString(7);
				mtr=rs1.getString(8);
				load=rs1.getDouble(1);
			}


	//change- new End
		/*Connection conn=new ConnDB().make_connection();	
		PreparedStatement ps = conn.prepareStatement("SELECT con_load FROM v_login WHERE con_no='"+conNo+"'");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			load=rs.getDouble(1);
			
		}

*/		Statement stmt=conn.createStatement();
		//ResultSet rsBill=stmt.executeQuery("SELECT matter, LOWER_UNIT, UPPER_UNIT, ADD_AMOUNT,RATE FROM v_tariff WHERE con_no = '"+conNo+"' AND upper_unit >= '"+unit+"' GROUP BY matter ORDER BY upper_unit" );
//sql-new-st


ResultSet rsBill=stmt.executeQuery("SELECT matter, LOWER_UNIT, UPPER_UNIT, ADD_AMOUNT, RATE FROM consdb.p_rate WHERE CAT_TYPE = '" + cat + "' AND FIN_YEAR = '" + fy + "' AND upper_unit >= '"+unit+"' GROUP BY matter UNION SELECT 'V' AS MATTER,1 AS LOWER_UNIT,999999 AS UPPER_UNIT,0 AS ADD_AMOUNT, RATE FROM consdb.p_vrate WHERE `month` = '" + mnth1 + "' UNION SELECT 'M' AS MATTER,0 AS LOWER_UNIT,999999 AS UPPER_UNIT,(1-2) AS ADD_AMOUNT, AMOUNT AS RATE FROM consdb.p_mrent WHERE FIN_YEAR = '" + fy + "' AND METER_TYPE = 'E' AND PHASE = '" + ph + "' AND CAT_TYPE = '" + cat + "' " );

//sql-new-en


 		while(rsBill.next())
		{	
 			
 			System.out.println("Matter-"+rsBill.getString(1)+"| L U-"+rsBill.getDouble(2)+"| AA-"+rsBill.getDouble(4)+"| Rate- "+rsBill.getDouble(5));

			if(rsBill.getString(1).matches("E")){
				energyCharge=rsBill.getDouble(4) + (unitAsDouble - rsBill.getDouble(2) + 1)*rsBill.getDouble(5);
			}	

			if(rsBill.getString(1).matches("D")){
				dutyPer=rsBill.getDouble(5);
			}

			if(rsBill.getString(1).matches("X")){
				fixedCharge=load*rsBill.getDouble(5);
			}	
	
			if(rsBill.getString(1).matches("V")){
				mvca=unitAsDouble*rsBill.getDouble(5);
			}

			if(rsBill.getString(1).matches("M")){
				meterRent=rsBill.getDouble(5);
			}
			
			

		}

 		
 		
//**Charge- End
			 
			 
			 dutyAmt=(energyCharge+mvca+fixedCharge)*dutyPer/100;
			 
			 double meterRentAmt=Double.valueOf(meterRent);
			 
			 billAmt=energyCharge+meterRentAmt+fixedCharge+mvca+dutyAmt;
			 
			 
			 billAmtAsString=String.valueOf(Math.round(billAmt))+"|"+String.valueOf(Math.round(energyCharge))+"|"+String.valueOf(Math.round(meterRent))+"|"+String.valueOf(Math.round(fixedCharge))+"|"+String.valueOf(Math.round(mvca)+"|"+String.valueOf(Math.round(dutyAmt)));
			 System.out.println("bill amt-"+billAmtAsString);	 
		
			 
			 
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return String.valueOf(billAmtAsString);
}


public String fetchEmail(String conNo) 
{
	String email=null;

	
	
		try
		{
		
		Connection conn=new ConnDB().make_connection();	
//**Charge- Start

		PreparedStatement ps = conn.prepareStatement("SELECT email_id from consdb.m_party where party_code ='"+conNo+"'");


//**Charge- End
		ResultSet rs = ps.executeQuery();
				int counter=0;
		while(rs.next())
		{
			counter++;
			email=rs.getString(1);
			
			
		}
		 if(counter==0){
			 
			 
			 return "NA";
		 }
		 
		 else{
			 
			 return email;
		 }
		
		
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return email;
}


public String fetchMobile(String conNo) 
{
	String mobile=null;

	
	
		try
		{
		
		Connection conn=new ConnDB().make_connection();	
//**Charge- Start

		PreparedStatement ps = conn.prepareStatement("SELECT mob_no AS mobile_no from consdb.m_party where party_code ='"+conNo+"' AND LENGTH(mob_no)>=10");


//**Charge- End

		ResultSet rs = ps.executeQuery();
				int counter=0;
		while(rs.next())
		{
			counter++;
			mobile=rs.getString(1);
			
			
		}
		 if(counter==0){
			 
			 
			 return "NA";
		 }
		 
		 else{
			 
			 return mobile;
		 }
		
		
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}finally{
		
		}
		return mobile;
}





}