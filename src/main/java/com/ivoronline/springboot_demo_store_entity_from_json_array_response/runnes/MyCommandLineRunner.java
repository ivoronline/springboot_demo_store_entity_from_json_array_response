package com.ivoronline.springboot_demo_store_entity_from_json_array_response.runnes;

import com.ivoronline.springboot_demo_store_entity_from_json_array_response.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

  @Autowired
  private PersonService personService;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    personService.getPerson();
    personService.getPersons();
  }

}

