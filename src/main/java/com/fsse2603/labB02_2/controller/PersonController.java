package com.fsse2603.labB02_2.controller;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.dto.response.CreatePersonResponseDto;
import com.fsse2603.labB02_2.mapper.person.PersonDataMapper;
import com.fsse2603.labB02_2.mapper.person.PersonDtoMapper;
import com.fsse2603.labB02_2.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService; //use interface here, to control the data
    private final PersonDataMapper personDataMapper;  //dependency injection of spring bean
    private final PersonDtoMapper personDtoMapper;

    //Constructor injection
    public PersonController(PersonService personService, PersonDataMapper personDataMapper, PersonDtoMapper personDtoMapper){
        this.personService = personService;
        this.personDataMapper = personDataMapper;
        this.personDtoMapper = personDtoMapper;
    }


    @PostMapping("/people")
    public CreatePersonResponseDto createPerson(@RequestBody CreatePersonRequestDto createPersonRequestDto){
        //Lv1
        // CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData();
        //createPersonRequestData.setFirstName(createPersonRequestDto.getFirstName());
        //createPersonRequestData.setLastName(createPersonRequestDto.getLastName());
        //createPersonRequestData.setHkid(createPersonRequestDto.getHkid());

        //Lv2 (not recommended)
        //CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData(
                //createPersonRequestDto.getFirstName(),
                //createPersonRequestDto.getLastName(),
                //createPersonRequestDto.getHkid()
        //);

        //Lv2 (use mapper class)
        CreatePersonRequestData createPersonRequestData = personDataMapper.toCreatePersonRequestData(createPersonRequestDto);


        CreatePersonResponseData createPersonResponseData = personService.createPerson(createPersonRequestData);

//        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto();
//        createPersonResponseDto.setFirstName(createPersonResponseData.getFirstName());
//        createPersonResponseDto.setLastName(createPersonResponseData.getLastName());
//        createPersonResponseDto.setHkid(createPersonResponseData.getHkid());

        CreatePersonResponseDto createPersonResponseDto = personDtoMapper.toCreatePersonResponseDto(createPersonResponseData);
        return createPersonResponseDto;
    }

    @GetMapping("/people")
    public void getAllPeople(){
        List<GetAllPeopleResponseData> responseDataList = personService.getAllPeople();
    }
}
