package com.projet1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SuperMarket  
{
	
	void menu() 
	{
		try
		{
			
			System.out.println("1. List All Items"+
			    	           "\n\t 2. Add New Item"+
			    	           "\n\t 3. Remove Existing Item."+

			    	           "\n\t Please Enter Your Choice .??");
			Scanner sc=new Scanner(System.in);
			byte ch=sc.nextByte();
			
			if(ch==1)
				showItem();
			else if(ch == 2)
				addItem();
			else if(ch == 3)
				removeItem();
			else if(ch > 3)
			{
				System.out.println("Invalid input");
				menu();
			}
			sc.close();
		
		}
		
		catch(Exception e) 
		{
			System.out.println("Invalid input");
			menu();
		}
	}
	
	
    String line=null;
	void showItem() {
		try
		{
            FileReader fileReader = new FileReader("C:\\Users\\Garvit gupta\\eclipse-workspace\\SuperMarket\\Menu.txt");
            
            // always wrap the FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            
            // always close the file after its use
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
		}
	
	
	void addItem() {
		
	        // Assigning the content of the file
			try {
				FileWriter fw= new FileWriter("C:\\Users\\Garvit gupta\\eclipse-workspace\\SuperMarket\\Menu.txt",true);
			
		  
		        //illustrating write() method
				System.out.println("Enter the name, quantity, date of the item");
		        Scanner sc=new Scanner(System.in);
		        
		        String b=sc.nextLine();
		        fw.write(b);
		        fw.write(System.lineSeparator());
		       
		        fw.close();
		        sc.close();
			}
			
			 catch(IOException ex)
	        {
	            System.out.println("\nError occurred");
	            System.out.println("Exception Name: " +ex);
	        }
		
	}
	void removeItem() throws Exception {
		try {
			String filePath = "Menu.txt";
		      String result = fileToString(filePath);
		     System.out.println(result);
		      //Replacing the word with desired one
		      System.out.println("enter name,quantity,date");
		      Scanner sc=new Scanner(System.in);
		      String str=sc.next();
		      result = result.replaceAll(str, "");
		      //Rewriting the contents of the file
		      PrintWriter writer = new PrintWriter(new File(filePath));
		      writer.append(result);
		      writer.flush();
		      System.out.println("Contents of the file after replacing the desired word:");
		      System.out.println("\n\t"+fileToString(filePath));
              sc.close();
		} 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
	
		
	}
	 public static String fileToString(String filePath) throws Exception{
	      String input = null;
	      Scanner sc;
		
			sc = new Scanner(new File(filePath));
		
	      StringBuffer sb = new StringBuffer();
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	         sb.append(input);
	      }
	      
	   
		
		return sb.toString();
	 }
	public static void main(String args[]) {
		
		SuperMarket c= new SuperMarket();
		c.menu();

	}
}
