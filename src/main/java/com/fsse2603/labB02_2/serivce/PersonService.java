package com.fsse2603.labB02_2.serivce;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;

public interface PersonService {
    PersonEntity createPerson(CreatePersonRequestData createPersonRequestData);
}

