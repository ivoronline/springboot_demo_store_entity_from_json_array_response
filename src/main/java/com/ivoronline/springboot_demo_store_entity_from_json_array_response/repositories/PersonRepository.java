package com.ivoronline.springboot_demo_store_entity_from_json_array_response.repositories;

import com.ivoronline.springboot_demo_store_entity_from_json_array_response.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> { }
