package br.com.jera.tads.apimanutencaoequipamento.services;

import br.com.jera.tads.apimanutencaoequipamento.commom.Util;
import br.com.jera.tads.apimanutencaoequipamento.exceptions.ValidationException;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.cliente.ClienteDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.dto.cliente.ClienteFormDTO;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.Cliente;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.Role;
import br.com.jera.tads.apimanutencaoequipamento.models.entity.User;
import br.com.jera.tads.apimanutencaoequipamento.repositories.ClienteRepository;
import br.com.jera.tads.apimanutencaoequipamento.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Transactional(rollbackOn = Exception.class)
    public ClienteDTO save(ClienteFormDTO clienteDTO) throws Exception{
        Cliente cliente = new Cliente(clienteDTO);
        validaDadosCliente(cliente);
        cliente.setRole(Role.CLIENTE);
        String senha = generateRandomPassword();
        cliente.setSenha(senha);
        cliente = clienteRepository.save(cliente);
        emailService.sendHtmlEmail(cliente.getEmail(), "Novo cadastro de usuário" , GenerateEmailHtmlService.generatePasswordEmailTemplate(cliente.getUsername(), senha));
        return new ClienteDTO(cliente);
    }

    public void validaDadosCliente(Cliente cliente) throws ValidationException {
        if(cliente.getCep() != null)
            cliente.setCep(Util.onlyNumbers(cliente.getCep()));
        cliente.setCpf(Util.onlyNumbers(cliente.getCpf()));

        Optional<User> email = userRepository.findByEmail(cliente.getEmail());
        if(email.isPresent()) {
            throw new ValidationException("o Email já consta na base de dados");
        }
        Optional<Cliente> cpf = clienteRepository.findByCpf(cliente.getCpf());
        if(cpf.isPresent()){
            throw new ValidationException("o Cpf já consta na base de dados");
        }
    }

    public static String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        int randomNum = 1000 + random.nextInt(9000);
        return String.valueOf(randomNum);
    }
}
