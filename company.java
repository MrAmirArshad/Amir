import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


class Server
{
	public static void main(String argv[]) throws Exception
	{

		Connection c = null;
      		Statement stmt = null;
     		 try {
        		 Class.forName("org.postgresql.Driver");
        		 c = DriverManager.getConnection("jdbc:postgresql://localhost:6789/companydb", "root", "1234");
       			c.setAutoCommit(false);
		         System.out.println("Opened database successfully");

		         stmt = c.createStatement();
        		 String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
        		 stmt.executeUpdate(sql);
        		 c.commit();

		         ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
        		 while ( rs.next() ) {
            			int id = rs.getInt("id");
            			String  name = rs.getString("name");
            			int age  = rs.getInt("age");
           			 String  address = rs.getString("address");
           			 float salary = rs.getFloat("salary");
           			 System.out.println( "ID = " + id );
          			  System.out.println( "NAME = " + name );
          			  System.out.println( "AGE = " + age );
          			  System.out.println( "ADDRESS = " + address );
          			  System.out.println( "SALARY = " + salary );
          			  System.out.println();
         		}
       			  rs.close();
   		      stmt.close();
       			  c.close();
     			 } catch ( Exception e ) {
    			     System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    			     System.exit(0);
    			  }
    				  System.out.println("Operation done successfully");		

				String clientSentence;
				String capitalizedSentence;

				ServerSocket welcomeSocket = new ServerSocket(6789);

				System.out.println("Waiting data from Client ..");
	
				while(true)
				{
					Socket connectionSocket = welcomeSocket.accept();
			
                  		      BufferedReader inFromClient =
					
					new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
   					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
					clientSentence = inFromClient.readLine();
 			
					System.out.println("From Client: " + clientSentence);
					capitalizedSentence = clientSentence.toUpperCase() + '\n';
					outToClient.writeBytes(capitalizedSentence);
		}

	}
}