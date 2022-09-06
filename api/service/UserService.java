package com.example.spring.data.jpa.api.service;

import com.example.spring.data.jpa.api.dao.UserRepository;
import com.example.spring.data.jpa.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
@PostConstruct
    public void initDB(){

        List<User> users = new ArrayList<>();

        users.add(new User(121, "basant", "IT", 34));
        users. add(new User(88,"sham","IT", 24));
        users. add(new User(232,"mahak","CIVIL", 23));
        users. add(new User(112,"anuj","IT", 24));
        repository.saveAll(users);
    }

    public List<User> getUser()
    {
    return repository.findAll();
    }
    public List<User> getUserByProfession(String profession)
    {
    return  repository.findByProfession(profession);
    }
    public Integer getAgeCount(int age)
    {
        return repository.countByAge(age);
    }
    public List<User> getDeletedUser(String name)
    {
    return repository.deleteByName(name);
    }
    public List<User> getUserByNameAndProfession(String name, String profession)
    {
    return repository.findByNameAndProfession(name, profession);
    }
    public List<User> getUserCustomQuery()
    {
    return repository.getUserCustomQuery();
    }
}
