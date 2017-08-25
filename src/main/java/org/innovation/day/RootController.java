package org.innovation.day;

import org.innovation.day.mappers.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RootController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/")
    List<Person> getRootPage() {
        List<Person> people = personDao.getAllPeople();
        if(null != people)
        return people;
        return new ArrayList<Person>();
    }
}
