package com.ivoronline.springboot_demo_store_entity_from_json_array_response.services;

import com.ivoronline.springboot_demo_store_entity_from_json_array_response.entities.Person;
import com.ivoronline.springboot_demo_store_entity_from_json_array_response.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;
import java.util.Arrays;

@Component
public class PersonService {

  @Autowired PersonRepository personRepository;

  //===============================================================
  // GET PERSON
  //===============================================================
  public void getPerson() {

    //GET PERSON FROM SERVER
    Person person = WebClient.create("http://localhost:8085")
                             .get()
                             .uri("/GetPerson")
                             .retrieve()
                             .bodyToMono(Person.class)
                             .block(Duration.ofSeconds(3));

    //STORE PERSON
    personRepository.save(person);

    //DISPLAY PERSON
    System.out.println("getPerson ()");
    System.out.println(person.getId() + " " + person.getName()+ " " + person.getAge());

  }

  //===============================================================
  // GET PERSONS
  //===============================================================
  public void getPersons() {

    //GET PERSON FROM SERVER
    Person[] persons = WebClient.create("http://localhost:8085")
                                .get()
                                .uri("/GetPersons")
                                .retrieve()
                                .bodyToMono(Person[].class)
                                .block(Duration.ofSeconds(3));

    //STORE PERSONS
    personRepository.saveAll(Arrays.asList(persons));

    //DISPLAY PERSONS
    System.out.println("getPersons()");
    for (Person person : persons) {
    System.out.println(person.getId() + " " + person.getName()+ " " + person.getAge());
    }

  }

}
