package com.fsse2603.labB02_2.controller;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.dto.response.CreatePersonResponseDto;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import com.fsse2603.labB02_2.serivce.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService; //use interface here, to control the data

    //Constructor injection
    public PersonController(PersonService personService){
        this.personService = personService;
    }


    @PostMapping("/people")
    public CreatePersonResponseDto createPerson(@RequestBody CreatePersonRequestDto createPersonRequestDto){
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData();
        createPersonRequestData.setFirstName(createPersonRequestDto.getFirstName());
        createPersonRequestData.setLastName(createPersonRequestDto.getLastName());
        createPersonRequestData.setHkid(createPersonRequestDto.getHkid());

        PersonEntity createPersonResponseData = personService.createPerson(createPersonRequestData);

        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto();
        createPersonResponseDto.setFirstName(createPersonResponseData.getFirstName());
        createPersonResponseDto.setLastName(createPersonResponseData.getLastName());
        createPersonResponseDto.setHkid(createPersonResponseData.getHkid());

        return createPersonResponseDto;
    }

}