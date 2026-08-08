package com.fsse2603.labB02_2.serivce.impl;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import com.fsse2603.labB02_2.serivce.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    public List<PersonEntity> personEntityList = new ArrayList<>();

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
       PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(createPersonRequestData.getFirstName());
        personEntity.setLastName(createPersonRequestData.getLastName());
        personEntity.setHkid(createPersonRequestData.getHkid());

       personEntityList.add(personEntity);

       CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData();
        createPersonResponseData.setFirstName(personEntity.getFirstName());
       createPersonResponseData.setLastName(personEntity.getLastName());
     createPersonResponseData.setHkid(personEntity.getHkid());
      return createPersonResponseData;
   }


}
