package com.fsse2603.labB02_2.service;

import com.fsse2603.labB02_2.data.person.domainObject.GetAllPeopleResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.request.UpdatePersonRequestData;
import com.fsse2603.labB02_2.data.person.domainObject.response.CreatePersonResponseData;
import com.fsse2603.labB02_2.data.person.domainObject.response.PersonResponseData;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData);

    List<GetAllPeopleResponseData> getAllPeople();

    PersonResponseData updatePerson(UpdatePersonRequestData updatePersonRequestData);

    PersonResponseData deletePerson(String hkid);
}

