package br.com.jera.tads.apimanutencaoequipamento.services;

import br.com.jera.tads.apimanutencaoequipamento.models.entity.User;
import br.com.jera.tads.apimanutencaoequipamento.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById (Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Erro ao buscar usuário"));
    }

    public User findByEmail (String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("usuário não encontrado : " + email));
    }

   /* public int getUltimoAcesso(User user) {
		Optional<User> userOpt = userRepository.findByEmail(user.getEmail());

		if (userOpt.isPresent()) {
			return userRepository.verificaPrimeiroAcesso(userOpt.get().getId());
		} else {
			return 0;
		}
	} */

    public boolean validateUser(User user, boolean status) {

        Optional<User> userOpt = userRepository.findByEmailAndStatus(user.getEmail(), true);
        if (userOpt.isPresent()) {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            if (status) {
                if (user.getPassword().equals(userOpt.get().getPassword())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (bc.matches(user.getPassword(), userOpt.get().getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }


}