import java.util.Scanner;

public class EmailMenu {
	Scanner reader = new Scanner(System.in);
	MessagingSystem mailSystem = new MessagingSystem();
	private boolean loggedIn, hasMessages;
	private String user;
	private int userIndex;
	
	public void stage1(){
		System.out.println("Log I)n  S)end message  R)ead messages  Log O)ut  Q)uit");
		String input = reader.nextLine();
		if(input.equalsIgnoreCase("i")){
			if(loggedIn)
				System.out.println("You are already logged in!");
			else
				logIn();
		}else if(input.equalsIgnoreCase("s")){
			if(loggedIn)
				sendMessage();
			else
				System.out.println("You must log in first!");
		}else if(input.equalsIgnoreCase("r")){
			if(loggedIn)
				readMessages();
			else
				System.out.println("You must log in first!");
		}else if(input.equalsIgnoreCase("o")){
			logOut();
		}else if(input.equalsIgnoreCase("q")){
			System.exit(0);
		}else{
			System.out.println("Invalid Input");
		}
	}//close printMenu
	
	public void sendMessage(){
		System.out.print("Mail to: ");
		String inputName = reader.nextLine();
		System.out.println("Enter text, blank line to end:");
		String inputMessage = reader.nextLine();
		inputMessage += "\n" + reader.nextLine();

		if(mailSystem.checkForUser(inputName))
			mailSystem.createMessage(new Message(user, inputName, inputMessage));
		else{
			mailSystem.addMailbox(new Mailbox(inputName));
			mailSystem.createMessage(new Message(inputMessage, user, inputName));
		}
	}
	
	public void readMessages(){
		mailSystem.readMail(user);
	}
	
	public void logIn(){
		System.out.print("User name: ");
		String input = reader.nextLine();
		if(mailSystem.checkForUser(input)){
			loggedIn = true;
			user = input;
			userIndex = 0;
		}
		else{
			mailSystem.addMailbox(new Mailbox(input));
			loggedIn = true;
			user = input;
		}
	}
	
	public void logOut(){
		if(loggedIn){
			loggedIn = false;
			user = null;
		}
		else
			System.out.println("You aren't logged in!");
	}
}
