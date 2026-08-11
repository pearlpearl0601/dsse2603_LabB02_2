package com.fsse2603.labB02_2.service.impl;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import com.fsse2603.labB02_2.mapper.person.PersonDataMapper;
import com.fsse2603.labB02_2.mapper.person.PersonEntityMapper;
import com.fsse2603.labB02_2.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service //@Component
public class PersonServiceImpl implements PersonService {
    private final PersonEntityMapper personEntityMapper;
    private final PersonDataMapper personDataMapper;

    public List<PersonEntity> personEntityList = new ArrayList<>();

    public PersonServiceImpl(PersonEntityMapper personEntityMapper, PersonDataMapper personDataMapper){
        this.personEntityMapper = personEntityMapper;
        this.personDataMapper = personDataMapper;
    }

//    @Override
//    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
//    Lv1
//       PersonEntity personEntity = new PersonEntity();
//        personEntity.setFirstName(createPersonRequestData.getFirstName());
//        personEntity.setLastName(createPersonRequestData.getLastName());
//        personEntity.setHkid(createPersonRequestData.getHkid());

//        personEntityList.add(personEntity);
//
//        CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
//        createPersonResponseData.setFirstName(personEntity.getFirstName());
//        createPersonResponseData.setLastName(personEntity.getLastName());
//        createPersonResponseData.setHkid(personEntity.getHkid());
//
//        return createPersonResponseData;
//    }

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
       PersonEntity personEntity = personEntityMapper.toPersonEntity(createPersonRequestData);


        personEntityList.add(personEntity);

//       CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
//        createPersonResponseData.setFirstName(personEntity.getFirstName());
//       createPersonResponseData.setLastName(personEntity.getLastName());
//     createPersonResponseData.setHkid(personEntity.getHkid());

       CreatePersonResponseData createPersonResponseData = personDataMapper.toCreatePersonResponseData(personEntity);
      return createPersonResponseData;
   }

   @Override
   public List<GetAllPeopleResponseData> getAllPeople(){
        List<GetAllPeopleResponseData> responseDataList = personDataMapper.toGetAllPeopleResponseDataList(personEntityList);
        return  responseDataList;
   }


}
