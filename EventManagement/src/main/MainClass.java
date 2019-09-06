package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import exception.MyException;
import java.text.ParseException;
import manage.ManageEvent;

public class MainClass {
	
	public static void main(String[] args) throws IOException, ParseException, MyException {
			System.out.println("1) Do you want to add the event?");
			System.out.println("2) Do you want to retrieve the event?");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String action = reader.readLine();
			ManageEvent mng = new ManageEvent();
			switch (action){
				   case "1" :
					   mng.storeEvent();
				      break; 
				   
				   case "2" :
				      mng.retrieveEvent();
				      break; 
				      
				   default : 
					   System.out.println("Incorrect Input");
			}
			System.out.println("End");
	}

}
