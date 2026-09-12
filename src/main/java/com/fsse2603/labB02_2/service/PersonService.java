package com.fsse2603.labB02_2.service;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.PersonResponseData;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData);

    List<GetAllPeopleResponseData> getAllPeople();

    PersonResponseData updatePerson(UpdatePersonRequestData requestData);

    PersonResponseData deletePerson(String hkid);

    List<PersonResponseData> getByLastName(String lastName);

    PersonEntity getEntityByHkid(String hkid);
}
