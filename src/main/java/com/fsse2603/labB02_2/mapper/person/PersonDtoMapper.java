package com.fsse2603.labB02_2.mapper.person;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.PersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.response.CreatePersonResponseDto;
import com.fsse2603.labB02_2.data.person.dto.response.GetAllPeopleResponseDto;
import com.fsse2603.labB02_2.data.person.dto.response.PersonResponseDto;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDtoMapper {
    public CreatePersonResponseDto toCreatePersonResponseDto(CreatePersonResponseData createPersonResponseData) {
        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto();
        createPersonResponseDto.setFirstName(createPersonResponseData.getFirstName());
        createPersonResponseDto.setLastName(createPersonResponseData.getLastName());
        createPersonResponseDto.setHkid(createPersonResponseData.getHkid());

        return createPersonResponseDto;

    }

    public GetAllPeopleResponseDto toGetAllPeopleResponseDto(GetAllPeopleResponseData getAllPeopleResponseData) {
        GetAllPeopleResponseDto getAllPeopleResponseDto = new GetAllPeopleResponseDto();
        getAllPeopleResponseDto.setFirstName(getAllPeopleResponseData.getFirstName());
        getAllPeopleResponseDto.setLastName(getAllPeopleResponseData.getLastName());
        getAllPeopleResponseDto.setHkid(getAllPeopleResponseData.getHkid());

        return getAllPeopleResponseDto;
    }

    public List<GetAllPeopleResponseDto> toGetAllPeopleResponseDtoList(List<GetAllPeopleResponseData> getAllPeopleResponseDataList) {
        List<GetAllPeopleResponseDto> responseDtoList = new ArrayList<>();

        for (GetAllPeopleResponseData getAllPeopleResponseData : getAllPeopleResponseDataList) {
            GetAllPeopleResponseDto getAllPeopleResponseDto = toGetAllPeopleResponseDto(getAllPeopleResponseData);
            responseDtoList.add(getAllPeopleResponseDto);
        }

        return responseDtoList;
    }

    public PersonResponseDto toPersonResponseDto(PersonResponseData responseData) {
        PersonResponseDto responseDto = new PersonResponseDto();
        responseDto.setFirstName(responseData.getFirstName());
        responseDto.setLastName(responseData.getLastName());
        responseDto.setHkid(responseData.getHkid());

        return responseDto;

    }

    public List<PersonResponseDto> toPersonResponseDtoList(List<PersonResponseData> responseDataList) {
        List<PersonResponseDto> responseDtoList = new ArrayList<>();

        for (PersonResponseData responseData : responseDataList) {
            PersonResponseDto getAllPeopleResponseDto = toPersonResponseDto(responseData);
            responseDtoList.add(getAllPeopleResponseDto);
        }

        return responseDtoList;
    }

}
