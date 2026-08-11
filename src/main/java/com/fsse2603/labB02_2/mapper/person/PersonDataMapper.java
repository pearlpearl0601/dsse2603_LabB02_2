package com.fsse2603.labB02_2.mapper.person;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component   //become Spring beans and will take care of instance life cycle
public class PersonDataMapper {
    public CreatePersonRequestData toCreatePersonRequestData (CreatePersonRequestDto createPersonRequestDto){
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData();
        createPersonRequestData.setFirstName(createPersonRequestDto.getFirstName());
        createPersonRequestData.setLastName(createPersonRequestDto.getLastName());
        createPersonRequestData.setHkid(createPersonRequestDto.getHkid());

        return createPersonRequestData;
    }

    public CreatePersonResponseData toCreatePersonResponseData(PersonEntity personEntity){
        CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
        createPersonResponseData.setFirstName(personEntity.getFirstName());
        createPersonResponseData.setLastName(personEntity.getLastName());
        createPersonResponseData.setHkid(personEntity.getHkid());

        return createPersonResponseData;
    }

    public GetAllPeopleResponseData toGetAllPeopleResponseData (PersonEntity personEntity){
        GetAllPeopleResponseData getAllPeopleResponseData = new GetAllPeopleResponseData();
        getAllPeopleResponseData.setFirstName(personEntity.getFirstName());
        getAllPeopleResponseData.setLastName(personEntity.getLastName());
        getAllPeopleResponseData.setHkid(personEntity.getHkid());

        return getAllPeopleResponseData;
    }
// this method used to change object into a list
    public List<GetAllPeopleResponseData> toGetAllPeopleResponseDataList(List<PersonEntity> personEntityList){
        List<GetAllPeopleResponseData> responseDataList = new ArrayList<>();

        for(PersonEntity personEntity: personEntityList){
            GetAllPeopleResponseData getAllPeopleResponseData = toGetAllPeopleResponseData(personEntity);
            responseDataList.add(getAllPeopleResponseData);
        }

        return responseDataList;


    }
}
