package ru.dkovkov.pp_3_1_2_sptingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dkovkov.pp_3_1_2_sptingboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
