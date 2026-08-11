package com.fsse2603.labB02_2.mapper.person;

import com.fsse2603.labB02_2.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityMapper {
    public PersonEntity toPersonEntity(CreatePersonRequestData createPersonRequestData){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(createPersonRequestData.getFirstName());
        personEntity.setLastName(createPersonRequestData.getLastName());
        personEntity.setHkid(createPersonRequestData.getHkid());

        return personEntity;
    }
}
