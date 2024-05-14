package fr.piroxxi.ruel_li_2.user;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {
    User save(User person);

    Optional<User> findById(String id);
}
