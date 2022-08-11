package br.com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bank.model.User;
import br.com.bank.repository.UserRepository;
import br.com.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository UserRepo;

    @Override
    public void save(User user) {
        UserRepo.save(user);
    } 

    

}
