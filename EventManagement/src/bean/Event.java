package bean;

import java.util.Date;

public class Event implements Comparable<Event>{
		private int eventId;
		private String eventDescription;
		private String eventTitle;
		private Date eventDate;
		
		public Event() {
				super();
		}
	
		public Event(int eventId, String eventDescription, String eventTitle, Date eventDate) {
				super();
				this.eventId = eventId;
				this.eventDescription = eventDescription;
				this.eventTitle = eventTitle;
				this.eventDate = eventDate;
		}
	
		public int getEventId() {
				return eventId;
		}
	
		public void setEventId(int eventId) {
				this.eventId = eventId;
		}
	
		public String getEventDescription() {
				return eventDescription;
		}
	
		public void setEventDescription(String eventDescription) {
				this.eventDescription = eventDescription;
		}
	
		public String getEventTitle() {
				return eventTitle;
		}
	
		public void setEventTitle(String eventTitle) {
				this.eventTitle = eventTitle;
		}
	
		public Date getEventDate() {
				return eventDate;
		}
	
		public void setEventDate(Date eventDate) {
				this.eventDate = eventDate;
		}
	
		@Override
		public String toString() {
				return   eventId + "," + eventDescription + "," + eventTitle + "," + eventDate;
		}
	
		@Override
		public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
				result = prime * result + ((eventDescription == null) ? 0 : eventDescription.hashCode());
				result = prime * result + eventId;
				result = prime * result + ((eventTitle == null) ? 0 : eventTitle.hashCode());
				return result;
		}
	
		@Override
		public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Event other = (Event) obj;
				if (eventDate == null) {
					if (other.eventDate != null)
						return false;
				} 
				else if (!eventDate.equals(other.eventDate)) 
				{
					return false;
				}
				if (eventDescription == null) {
					if (other.eventDescription != null)
						return false;
				} 
				else if (!eventDescription.equals(other.eventDescription))
					return false;
				if (eventId != other.eventId)
					return false;
				if (eventTitle == null) {
					if (other.eventTitle != null)
						return false;
				} else if (!eventTitle.equals(other.eventTitle)) {
					return false;
				}
				return true;
		}
	
		@Override
		public int compareTo(Event o) {
				if (getEventDate() == null || o.getEventDate() == null)
				      return 0;
				return getEventDate().compareTo(o.getEventDate());
		}
}
