package com.athem.cms.service.cms_service.repository;
import com.athem.cms.service.cms_service.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

    @Repository
    public interface UserRepository extends CrudRepository<User, Integer> {
        Optional<User> findByEmail(String email);
    }
