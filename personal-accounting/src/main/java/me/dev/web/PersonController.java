package me.dev.web;

import me.dev.dto.EmployeeDto;
import me.dev.dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/save")
    public String save(@RequestBody PersonDto personDto) {
        System.out.println(personDto);
        return "Ok";
    }
}
