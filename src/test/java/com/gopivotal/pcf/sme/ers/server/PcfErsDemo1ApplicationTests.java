package com.gopivotal.pcf.sme.ers.server;

import io.pivotal.pcf.sme.ers.PcfErsDemo1Application;
import io.pivotal.pcf.sme.ers.server.model.Attendee;
import io.pivotal.pcf.sme.ers.server.repo.AttendeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PcfErsDemo1Application.class)
public class PcfErsDemo1ApplicationTests {
	
	@Autowired
	private AttendeeRepository attendeeRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void attendeeRepository() throws ParseException {
		
		attendeeRepository.deleteAll();
		
		Attendee a1 = new Attendee();
		a1.setFirstName("Phil");
		a1.setLastName("Berman");
		attendeeRepository.save(a1);
		
		a1 = new Attendee();
		a1.setFirstName("Marcelo");
		a1.setLastName("Borges");
		attendeeRepository.save(a1);
		
		List<Attendee> attendees = attendeeRepository.findAll();
		assertThat(attendees.size(), is(2));
		
	}

}
