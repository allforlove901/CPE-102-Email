import java.util.ArrayList;

public class Mailbox {

	private String userName;
	private ArrayList<Message> messages = new ArrayList<Message>();
	
	public Mailbox(String aUserName)
	{
		userName = aUserName;
	}
	
	public void addMessage(Message m)
	{
		messages.add(m);
	}
	
	public ArrayList<Message> getMessages()
	{
		return messages;
	}
	
	public boolean equals(Mailbox otherbox){
		if (this.userName.equals(otherbox.userName))
			return true;
		return false;
	}
	
	public void readMessages(){
		for(Message message: messages)
		System.out.print(message);
		System.out.println("\n");
	}
}
