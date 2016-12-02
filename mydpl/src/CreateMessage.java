
public class CreateMessage {

	String msg=null;
	
	public String createMessage(String merchantID,String consNo,String na,String billAmt,String currency,String typeField1,String securityID,String typeField2,String tranDate,String category,String referenceNo,String billMonth,String remarks,String ru){
		
		msg=merchantID+"|"+consNo+"|"+na+"|"+billAmt+"|"+na+"|"+na+"|"+na+"|"+currency+"|"+na+"|"+typeField1+"|"+securityID+"|"+na+"|"+na+"|"+typeField2+"|"+tranDate+"|"+category+"|"+referenceNo+"|"+billMonth+"|"+remarks+"|"+na+"|"+na+"|"+ru;
		return msg;
	}
	
}
