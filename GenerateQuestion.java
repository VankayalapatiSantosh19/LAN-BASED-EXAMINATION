import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class GenerateQuestion {

	Question[] q;
	
	public GenerateQuestion() {
		q= new Question[5];
		
		Question q1 = new Question("What is captial of India","DELHI");
		
		Question q2 = new Question("What is captial of USA","NEWYORK");

		Question q3 = new Question("What is captial of UK","LONDAN");

		Question q4 = new Question("What is captial of China","BEJING");

		Question q5 = new Question("What is captial of Russia","MASCOW");

		q[0]=q1;
		q[1]=q2;
		q[2]=q3;
		q[3]=q4;
		q[4]=q5;
		
	}

}
