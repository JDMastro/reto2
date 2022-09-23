package com.reto.demo.service;

import com.reto.demo.domain.Users;
import com.reto.demo.repository.UsersRepository;
import com.reto.demo.service.interfaces.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase tipo Servicio para el manejo del usuario
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
@Service
public class UsersService implements IUsers {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUser(String id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users saveOrUpdateUser(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    }
}
