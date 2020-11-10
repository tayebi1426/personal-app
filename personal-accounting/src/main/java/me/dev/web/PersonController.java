package me.dev.web;

import me.dev.dto.PersonDto;
import me.dev.dto.datagrid.DataSourceResponse;
import me.dev.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody @Validated PersonDto personDto) {
        Integer id = personService.save(personDto);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/list")
    public ResponseEntity<DataSourceResponse<PersonDto>> list() {
        List<PersonDto> personList = personService.list();
        return ResponseEntity.ok(new DataSourceResponse<>(personList.size(), personList));
    }
}
