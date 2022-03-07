package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Event;
import tn.esprit.spring.wecare.entities.EventDt;
import tn.esprit.spring.wecare.entities.Eventdto;
import tn.esprit.spring.wecare.entities.typef;

public interface EventIService {
	
	
	public List<Event> getallEvent();
	public Event getEventById(Long id);
	public void addEvent(Event event);
	public void deleteEvent(Long id);
	public void updateEvent(Event event,Long id);
	public void deleteEventBynote();
	
	public Eventdto EventNoteSuperieur();
	public void AcceptEvent(Long idEvent,Long idUser);
	public float budgetEvent(Long id);
	public EventDt affichermeilleurprofit();
	public List<Event> eventTypique(long id);
	public typef typeplusparticipe(long id);

}
