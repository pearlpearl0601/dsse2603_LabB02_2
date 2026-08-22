package com.fsse2603.labB02_2.controller;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.PersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.dto.request.UpdatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.dto.response.CreatePersonResponseDto;
import com.fsse2603.labB02_2.data.person.dto.response.GetAllPeopleResponseDto;
import com.fsse2603.labB02_2.data.person.dto.response.PersonResponseDto;
import com.fsse2603.labB02_2.mapper.person.PersonDataMapper;
import com.fsse2603.labB02_2.mapper.person.PersonDtoMapper;
import com.fsse2603.labB02_2.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
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
    @ResponseStatus(HttpStatus.CREATED)
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
    public List<GetAllPeopleResponseDto> getAllPeople(){
        List<GetAllPeopleResponseData> responseDataList = personService.getAllPeople();

        List<GetAllPeopleResponseDto> responseDtoList = personDtoMapper.toGetAllPeopleResponseDtoList(responseDataList);

        return responseDtoList;
    }

    @PutMapping("/people")
    public PersonResponseDto updatePerson(@Valid @RequestBody UpdatePersonRequestDto requestDto){
        UpdatePersonRequestData updatePersonRequestData = personDataMapper.toUpdatePersonRequestData(requestDto);

        PersonResponseData responseData = personService.updatePerson(personDataMapper.toUpdatePersonRequestData(requestDto));

        PersonResponseDto responseDto = personDtoMapper.toPersonResponseDto(responseData);

        return responseDto;
    }

    @DeleteMapping("/people/{hkid}")
    public PersonResponseDto deletePerson(@PathVariable @NotBlank String hkid){
        PersonResponseData responseData = personService.deletePerson(hkid);
        PersonResponseDto responseDto = personDtoMapper.toPersonResponseDto(responseData);
        return responseDto;
    }
}
