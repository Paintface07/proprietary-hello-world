package org.innovation.day.mappers;

import org.apache.ibatis.annotations.Select;
import org.innovation.day.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kondrak on 8/25/17.
 */
@Repository
public interface PersonDao {

    @Select("SELECT PERSON_TOKEN_NR as personToken, FIRST_NM as firstName, LAST_NM as lastName FROM TESTDB.PERSON;")
    List<Person> getAllPeople();
}
