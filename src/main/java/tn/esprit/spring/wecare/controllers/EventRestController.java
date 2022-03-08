package tn.esprit.spring.wecare.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Event;
import tn.esprit.spring.wecare.entities.EventDt;
import tn.esprit.spring.wecare.entities.Eventdto;
import tn.esprit.spring.wecare.entities.typef;
import tn.esprit.spring.wecare.iservices.EventIService;

@RestController
@RequestMapping("/event")
public class EventRestController {
	
	@Autowired
	EventIService eventIservice;
	
	// http://localhost:8089/wecare/event/get-all-events
	@GetMapping("/get-all-events")
	public List<Event> getallEvent(){
		return eventIservice.getallEvent();}
	
	// http://localhost:8089/wecare/event/get-event-by-id/{id}
	@GetMapping("/get-event-by-id/{id}")
	public Event getEventById(@PathVariable("id") Long id) {
		return eventIservice.getEventById(id);}
	
	// http://localhost:8089/wecare/event/create-event
	@PostMapping("/create-event")
	public void addEvent(@RequestBody Event event) {
		eventIservice.addEvent(event);}
	
	// http://localhost:8089/wecare/event/delete-event/{id}
	@DeleteMapping("/delete-event/{id}")
	public void deleteEvent(@PathVariable("id") Long id) {
		eventIservice.deleteEvent(id);
	}
	
	// http://localhost:8089/wecare/event/update-event/{id}
	@PutMapping("/update-event/{id}")
	public void updateEvent(@RequestBody Event event,@PathVariable("id") Long id) {
		eventIservice.updateEvent(event, id);
	}
	
	// http://localhost:8089/wecare/event/event-superieur-note
	@GetMapping("/event-superieur-note")
	public Eventdto EventNoteSuperieur(){
		return eventIservice.EventNoteSuperieur();}
	
	// http://localhost:8089/wecare/event/budget/{id}
	@GetMapping("/budget/{id}")
	public float budgetEvent(@PathVariable("id") Long id) {
		return   eventIservice.budgetEvent(id);
	}
	
	// http://localhost:8089/wecare/event/best-profit-event
	@GetMapping("/best-profit-event")
	public EventDt affichermeilleurprofit() {
		return eventIservice.affichermeilleurprofit();
	}
	
	// http://localhost:8089/wecare/event/deletebynote

	@DeleteMapping("/deletebynote")
	public void deleteEvent() {
		eventIservice.deleteEventBynote();
		}
	
	// http://localhost:8089/wecare/event/events-same-interest
	@GetMapping("/events-same-interest/{id-user}")
	public List<Event> eventTypique(@PathVariable("id-user")long id){
		return eventIservice.eventTypique(id);
	}
	
	// http://localhost:8089/wecare/event/type-event-plusparticipe
	@GetMapping("/type-event-plusparticipe/{id-user}")
	public typef typeplusparticipe(@PathVariable("id-user")long id) {
		return eventIservice.typeplusparticipe(id);
	}


}
