import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(1, 1159, 19, 739));
		users.add(new User(2, 1189, 37, 333));
		users.add(new User(3, 1111, 47, 383));
		
		users.get(0).SetUsers(new User[] {users.get(1), users.get(2)});
		users.get(1).SetUsers(new User[] {users.get(0), users.get(2)});
		users.get(2).SetUsers(new User[] {users.get(0), users.get(1)});

		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < users.size(); i++) {
			int password = 0;
			int index = 0;
			boolean isValidInput = false;
			while (!isValidInput) {
				System.out.println("Enter index for message (number between 0-2)");
				index = s.nextInt();

				System.out.println("Enter password  for user " + users.get(i).getUserId() + " (number between 0-3):");
				password = s.nextInt();

				if (indexes.contains(index) || index < 0 || index > 2 ) {
					System.out.println("You must choose another index");
				} else if (password < 1 || password > 3) {
					System.out.println("Password must be number betwenn 0-3");
				} else {
					indexes.add(index);
					users.get(i).setIndex(index);
					users.get(i).setPassword(password);
					users.get(i).generateMessage();
					isValidInput = true;
				}
			}
		}
		
		System.out.println();

		for (int i = 0; i < users.size() - 1; i++) {
			User srcUser = users.get(i);
			User dstUser = users.get(2);
			srcUser.sendMessage(dstUser, dstUser.getN(), dstUser.getE());
		}
		
		users.get(2).generateGlobalPassword();

	}

}
