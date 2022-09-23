package com.reto.demo.repository;

import com.reto.demo.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Users
 *
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
}
