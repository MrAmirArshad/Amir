import java.util.*;
import java.io.*;
import java.text.*;

public class binToStr{
   	public static void main(String args[]) throws Exception
	{
      		File bin = new File("binTxt.bin");

      		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("txtStr2.txt")));
	
		Scanner scanner = new Scanner(bin);
		String words = scanner.nextLine();

		String[] code = words.split(" ");
		String str = "";
		for(int i = 0; i < code.length; i++)
			str += (char)Integer.parseInt(code[i],2);
		
		System.out.println("Binary to String. Success.");
		String reverse = new StringBuffer(str).reverse().toString();
		
		output.println(reverse);
		System.out.println("String Reversed. Success.");
		scanner.close();
		output.close();
	}
}
