import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.net.*;

public class Server {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1080);
			Socket serverclient1 = server.accept();
			
			DataInputStream input = new DataInputStream(serverclient1.getInputStream());
			DataOutputStream output = new DataOutputStream(serverclient1.getOutputStream());
			
			output.writeUTF("server started...");
			
			String msg = input.readUTF();
			
			if(msg.equalsIgnoreCase("start exam")) {
				GenerateQuestion gq = new GenerateQuestion();
				int res=0;
				for(int i=0;i<gq.q.length;i++) {
					output.writeUTF(gq.q[i].question);
					String ans=input.readUTF();
					if(ans.equalsIgnoreCase(gq.q[i].answer))
						res++;
				}
				output.writeUTF("EXAMOVER");
				output.writeUTF("Exam is over... your result is " + res + " out of 5");
				
				output.flush();
				input.close();
				output.close();
				serverclient1.close();
			}else {
				throw new Exception("Exam not started...... please enter start exam");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
