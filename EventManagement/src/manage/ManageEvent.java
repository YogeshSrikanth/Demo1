package manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import bean.Event;
import exception.MyException;

public class ManageEvent {
	
	
	
	public ManageEvent() {
			super();
	}

	public void storeEvent() throws IOException, ParseException {
		
			int i = 1;
			ArrayList<Event> eventList= new ArrayList<>();
			
			while(i!=0) {
				
					System.out.println("Enter Event Id: ");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					int eventId = Integer.parseInt(reader.readLine());
					System.out.println("Enter Event Title: ");
					String eventTitle = reader.readLine();
					System.out.println("Enter Event Description: ");
					String eventDescription = reader.readLine();
					System.out.println("Enter Event Date: ");
					String eventDate1 = reader.readLine();
					
					Date eventDate= new SimpleDateFormat("dd/MM/yyyy").parse(eventDate1);
					Event event = new Event(eventId, eventDescription, eventTitle, eventDate);
					eventList.add(event);
					
					System.out.println("Please enter 0 to exit or any other numeric key to add more events\n");
					i = Integer.parseInt(reader.readLine());
			}
			
			Collections.sort(eventList);
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("events.csv"),true));
			
			for(Event j : eventList) {
				pw.print(j);
				pw.println();
			}
			
			pw.close();		
	}
	
	
	public void retrieveEvent() throws IOException, MyException {
			System.out.println("Enter Event Id: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String eventId = reader.readLine();
			BufferedReader br = new BufferedReader(new FileReader("events.csv"));
			String line = br.readLine();
			boolean found = false;
			while(line!=null) {
					String[] s1 = line.split(",");
					if(s1[0].equals(eventId)) {
						found = true;
						System.out.println(line);
					}
					line = br.readLine();
					if(found) {
						break;
					}
			}
					br.close();
					throw new MyException("Object NOT Found");
	}
}
