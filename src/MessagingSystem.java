import java.util.ArrayList;

public class MessagingSystem {

	private ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
	
	public MessagingSystem(){}
	
	public boolean checkForUser(String aUsername){
		if(mailboxes.contains(new Mailbox("aUsername")))
			return true;
		return false;
	}
	
	public void addMailbox(Mailbox m){
		mailboxes.add(m);
	}
	
	public void createMessage(Message m){
		String receiver = m.getReceiver();
		int index = Math.abs(mailboxes.indexOf(new Mailbox("receiver")));
		mailboxes.get(index).addMessage(m);
	}
	
	public void readMail(String user){
		int index = Math.abs(mailboxes.indexOf(new Mailbox("receiver")));
		mailboxes.get(index).readMessages();
	}
}
