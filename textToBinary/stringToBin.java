import java.util.*;
import java.io.*;
import java.text.*;

public class stringToBin{
	public static void main(String args[]) throws IOException
	{
      		BufferedReader infile = new BufferedReader(new FileReader("txtStr.txt"));
          
      		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("binTxt.bin")));

		Scanner scanner = new Scanner( new File("txtStr.txt") );
		String text = scanner.useDelimiter("\\A").next();

      		byte[] bytes = text.getBytes();
	  	StringBuilder binary = new StringBuilder();
	  	for (byte b : bytes)
	  	{
			int val = b;
		     	for (int i = 0; i < 8; i++)
		     	{
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
		     	}
		     	binary.append(' ');
		}
		output.println(binary);
		output.close();
		System.out.println("String to Binary. Success.");
		scanner.close();
	}
}
