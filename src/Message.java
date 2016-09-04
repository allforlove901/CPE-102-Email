
public class Message {

	private String text, sender, receiver;
	
	public Message(String someText, String aSender, String aReceiver){
		text = someText;
		sender = aSender;
		receiver = aReceiver;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public String getReceiver()
	{
		return receiver;
	}

	public String toString()
	{
		String output = "From: " + sender + "\n";
		output += "To: " + receiver + "\n";
		output += text + "\n";
		return output;
	}
}
