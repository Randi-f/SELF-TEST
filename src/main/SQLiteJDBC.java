package main;
import java.sql.*;
public class SQLiteJDBC {
	Connection c = null;
    Statement stmt = null;
	public SQLiteJDBC() {
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:database.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");
		      stmt = c.createStatement();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void closeConnection() {
		 try {
			 stmt.close();
			 c.commit();
			 c.close();
			 System.out.println("successfully close the database");
	      }
		 catch ( Exception e ) {
		      System.err.println("error occurs when closing db." );
		      System.exit(0);
		    }
	}
	public String login(String myID, String myName) {
		String loginResult="";
		try {
		String sql="SELECT * FROM user WHERE ID = '"+ myID +"' AND name = '"+ myName + "';";
	    ResultSet rs=stmt.executeQuery(sql);

	    while ( rs.next() ) {
	          String id = rs.getString("ID");
	          String  name = rs.getString("name");
	          int score  = rs.getInt("score");
	          System.out.println( "ID = " + id );
	          System.out.println( "NAME = " + name );
	          System.out.println( "SCORE = " + score );
	          //System.out.println();
	          loginResult+=id+"--"+name+"--"+score;
	       }
		}
		catch( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		return loginResult;
		
	}
	public static void main( String args[] ) {
		SQLiteJDBC myJDBC= new SQLiteJDBC();
		String ii=myJDBC.login("001", "Shihan Fu");
		if(ii.equals("")) {
			System.out.println("not found");
		}
		else {
			System.out.println("ii is:"+ii);
		}
		
		myJDBC.closeConnection();
		//Connection c = null;
	   // Statement stmt = null;
		//String myID="000";
		//String myName="Shihan Fu";
		
	   
	    System.out.println("SAFE");
		
	}
	/*
	 * *输出数据
	 */
	/*
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      //String sql = "INSERT INTO user  " +
	      //             "VALUES ('000', 'Shihan Fu', 0);"; 
	      //stmt.executeUpdate(sql);
	      String sql="SELECT * FROM user;";
	      ResultSet rs=stmt.executeQuery(sql);
	      while ( rs.next() ) {
	          String id = rs.getString("ID");
	          String  name = rs.getString("name");
	          int score  = rs.getInt("score");

	          System.out.println( "ID = " + id );
	          System.out.println( "NAME = " + name );
	          System.out.println( "SCORE = " + score );
	          System.out.println();
	       }

	     

	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	  }*/
	/*
	 * *建立表
	 */
	/*
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE user " +
	                   "(ID CHAR(50) PRIMARY KEY     NOT NULL," +
	                   " name           TEXT    NOT NULL, " + 
	                   " score         INT)"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }*/
	
	
	/*
	 * *生成数据库
	 */
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:database.db");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Opened database successfully");
	}*/

}
