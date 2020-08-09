package fr.miage.orleans.museeapi.services;

import fr.miage.orleans.museeapi.dao.*;

import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class EventsInitServiceImpl implements IEventsServiceInit {
	
	private UserRepository userRepository;
	private EventRepository eventRepository;
	private CountryRepository countryRepository;
	
	@Override
	public void initUsers() {
		/*
		 * museeRepository.findAll().forEach(musee->{ for(int i=0;i<=20;i++) { Salle
		 * salle =new Salle(); salle.setNom("Salle" +(i+1)); salle.setMusee(musee);
		 * salleRepository.save(salle);
		 * 
		 * } });
		 */
		
	}

	@Override
	public void initEvents() {
		/*
		 * DateFormat df=new SimpleDateFormat("dd/MM/YYYY"); double[]prices=new double[]
		 * {30,38,46,56,60}; museeRepository.findAll().forEach(musee->{
		 * musee.getSalles().forEach(salle->{
		 * oeuvreRepository.findAll().forEach(oeuvre->{ Exposition exposition=new
		 * Exposition(); exposition.setDateDebutExposition(new Date());
		 * exposition.setOeuvre(oeuvre); exposition.setPrix(prices[new
		 * Random().nextInt(prices.length)]); exposition.setSalle(salle);
		 * expositionRepository.save(exposition); }); }); });
		 */
		
	}

	@Override
	public void initCountries() {
		/*
		 * Stream.of("Monaliza","l art rare","beau paysage","l oeil de tigre"
		 * ,"miracle de moïse") .forEach(nomOeuvre->{ Oeuvre oeuvre=new Oeuvre();
		 * oeuvre.setNom(nomOeuvre); });
		 */
		
	}


}
