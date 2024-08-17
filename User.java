import java.util.ArrayList;
import java.util.Random;

public class User {
	private static final Random random = new Random();
	private int userId;
	private int index;
	private int password;
	private String message;
	private ArrayList<int[]> messages = new ArrayList<>();
	private int N;
	private int e;
	private int d;
	private User[] users;

	public User(int userId, int N, int e, int d) {
		this.userId = userId;
		this.N = N;
		this.e = e;
		this.d = d;
	}
	
	public User[] getUsers() {
		return this.users;
	}
	
	public void SetUsers(User[] users) {
		this.users = users;
	}

	public int getUserId() {
		return userId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public ArrayList<int[]> getMessages() {
		return messages;
	}

	public int getN() {
		return N;
	}

	public int getE() {
		return e;
	}

	public int getD() {
		return d;
	}
	
	private void generateIndex() {
	}
	
	private void generatePassword() {
		
	}
	
	public void generateMessage() {
		String binaryPassword = String.format("%2s", Integer.toBinaryString(password)).replace(' ', '0');
		String binaryIndex = String.format("%2s", Integer.toBinaryString(index)).replace(' ', '0');

		this.message = binaryIndex + binaryPassword;

		System.out.println("User:" + this.userId);
		System.out.println("Binary index: " + binaryIndex);
		System.out.println("Binary password: " + binaryPassword);
		System.out.println("Message (plain): " + binaryIndex + binaryPassword);
		System.out.println("\n-------------------------------------\n");
	}

	public void sendMessage(User dstUser, int N, int e) {
		int[] encrypted_password = Util.encrypt(Integer.parseInt(this.message, 2), N, e);

		dstUser.getMessages().add(encrypted_password);
		System.out.println("-----------------");
		System.out.println("Message Sent...");
		System.out.println("From User: " + this.userId);
		System.out.println("To User: " + dstUser.getUserId());
		System.out.println("Encrypted Message: [" + encrypted_password[0] + ", " + encrypted_password[1] + "]\n");
		System.out.println("\n-------------------------------------\n");
	}
	
	public String generateGlobalPassword() {
		return "";
//		String[] plain_messages = new String[3];
//		
//		for (int i = 0; i < messages.size(); i++) {
//			int C = messages.get(i)[0];
//			int S = messages.get(i)[1];
//			
//			
//			System.out.println("C = " + C + " S = " + S);
//			int plain_message = Util.decrypt(C, S, this.N, this.d);
//			
//			System.out.println("plain message: " + plain_message);
//			int index = plain_message & 0b1100;
//			int password = plain_message & 0b0011;
//			System.out.println(index + " " + password );
//			plain_messages[index] = String.format("%2s", Integer.toBinaryString(password)).replace(' ', '0');
//		}
		
//		return String.join("-", plain_messages);
	}

}
