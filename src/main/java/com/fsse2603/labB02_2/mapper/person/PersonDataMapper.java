package com.fsse2603.labB02_2.mapper.person;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.PersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.dto.request.UpdatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDataMapper {
    //    RequestDate
    public CreatePersonRequestData toCreatePersonRequestData(CreatePersonRequestDto requestDto) {
        CreatePersonRequestData requestData = new CreatePersonRequestData();
        requestData.setFirstName(requestDto.getFirstName());
        requestData.setLastName(requestDto.getLastName());
        requestData.setHkid(requestDto.getHkid());
        return requestData;
    }

    public UpdatePersonRequestData toUpdatePersonRequestData(UpdatePersonRequestDto requestDto) {
        UpdatePersonRequestData requestData = new UpdatePersonRequestData();
        requestData.setFirstName(requestDto.getFirstName());
        requestData.setLastName(requestDto.getLastName());
        requestData.setHkid(requestDto.getHkid());
        return requestData;
    }

    //    ResponseData
    public CreatePersonResponseData toCreatePersonResponseData(PersonEntity personEntity) {
        CreatePersonResponseData responseData = new CreatePersonResponseData();
        responseData.setFirstName(personEntity.getFirstName());
        responseData.setLastName(personEntity.getLastName());
        responseData.setHkid(personEntity.getHkid());
        return responseData;
    }

    public GetAllPeopleResponseData toGetAllPeopleResponseData(PersonEntity personEntity) {
        GetAllPeopleResponseData responseData = new GetAllPeopleResponseData();
        responseData.setFirstName(personEntity.getFirstName());
        responseData.setLastName(personEntity.getLastName());
        responseData.setHkid(personEntity.getHkid());
        return responseData;
    }

    public List<GetAllPeopleResponseData> toGetAllPeopleResponseDataList(List<PersonEntity> personEntityList) {
        List<GetAllPeopleResponseData> responseDataList = new ArrayList<>();

        for (PersonEntity personEntity : personEntityList) {
            GetAllPeopleResponseData responseData = toGetAllPeopleResponseData(personEntity);
            responseDataList.add(responseData);
        }

        return responseDataList;
    }

    public PersonResponseData toPersonResponseData(PersonEntity personEntity) {
        PersonResponseData responseData = new PersonResponseData();
        responseData.setFirstName(personEntity.getFirstName());
        responseData.setLastName(personEntity.getLastName());
        responseData.setHkid(personEntity.getHkid());
        return responseData;
    }

    public List<PersonResponseData> toPersonResponseDataList(List<PersonEntity> entityList) {
        List<PersonResponseData> responseDataList = new ArrayList<>();

        for (PersonEntity entity : entityList) {
            responseDataList.add(toPersonResponseData(entity));
        }

        return responseDataList;
    }
}