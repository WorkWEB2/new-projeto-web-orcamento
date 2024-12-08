package br.com.jera.tads.apimanutencaoequipamento.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioEditDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.funcionario.FuncionarioFormDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.Funcionario;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.Role;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.User;
import br.com.jera.tads.apimanutencaoequipamento.exceptions.ValidationException;
import br.com.jera.tads.apimanutencaoequipamento.repositories.FuncionarioRepository;
import br.com.jera.tads.apimanutencaoequipamento.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Funcionario save(FuncionarioFormDTO funcionarioDTO) throws ValidationException {
        Funcionario funcionario = new Funcionario(funcionarioDTO);
        validaDadosFuncionario(funcionario);
        funcionario.setRole(Role.FUNCIONARIO);
        funcionario = repository.save(funcionario);
        return funcionario;
    }

    @Transactional(rollbackOn = Exception.class)
    public Funcionario update(FuncionarioEditDTO funcionarioDTO , Long id) {
        Funcionario funcionarioExists = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
        funcionarioExists.setDtNascimento(funcionarioDTO.dtNascimento());
        funcionarioExists.setNome(funcionarioDTO.nome());
        funcionarioExists.setEmail(funcionarioDTO.email());
        funcionarioExists = repository.save(funcionarioExists);
        return funcionarioExists;
    }

    public void validaDadosFuncionario(Funcionario entity) throws ValidationException {
        Optional<User> email = userRepository.findByEmail(entity.getEmail());
        if(email.isPresent()) {
            throw new ValidationException("o email já consta na base de dados");
        }
    }

    public Boolean delete(Long id) throws ValidationException {
        Funcionario user = (Funcionario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId().equals(id)) {
            throw new  ValidationException("O funcionário não pode excluir a si mesmo");
        }
        Funcionario funcionarioExists = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
        funcionarioExists.setStatus(false);
        funcionarioExists = repository.save(funcionarioExists);
        return true;
    }

    public Funcionario findById(Long id) {
        return repository.findByIdAndStatus(id ,true).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    public List<FuncionarioDTO> findAll() {
        Funcionario user = (Funcionario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByStatus(true).stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

}