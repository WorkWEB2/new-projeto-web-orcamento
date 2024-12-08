package br.com.jera.tads.apimanutencaoequipamento.repositories;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmailAndStatus(String email, boolean i);

    Optional<User> findByEmail(String email);

}