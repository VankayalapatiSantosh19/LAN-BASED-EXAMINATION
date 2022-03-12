import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class client {

	public static void main(String[] args){
		
		try {
			
			Socket client1 = new Socket("localhost",1080);
			
			DataInputStream input = new DataInputStream(client1.getInputStream());
			DataOutputStream output = new DataOutputStream(client1.getOutputStream());
			
			String servermsg = input.readUTF();
			System.out.println(servermsg);
			System.out.println("YOUR EXAM STARTED");
			
			
			output.writeUTF("start exam");
			boolean examover = true;
			while(examover) {
				String ques = input.readUTF();
				System.out.println(ques);
				if(ques.equalsIgnoreCase("EXAMOVER")) {
					System.out.println(input.readUTF());
					examover = false;
				}else {
					Scanner in = new Scanner(System.in);
					String ans=in.nextLine();
					output.writeUTF(ans);
				}
			}
			
			output.flush();
			input.close();
			output.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
