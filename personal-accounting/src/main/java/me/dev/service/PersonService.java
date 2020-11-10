package me.dev.service;

import me.dev.dto.PersonDto;

import java.util.List;

public interface PersonService {

    Integer save(PersonDto personDto);

    List<PersonDto> list();
}
