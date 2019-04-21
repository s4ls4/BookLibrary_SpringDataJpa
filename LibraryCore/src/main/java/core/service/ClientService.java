package service;

import model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private static final Logger log =
            LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        log.trace("getAllClients --- method entered");

        List<Client> result = clientRepository.findAll();

        log.trace("getAllClients: result={}", result);

        return result;
    }

    @Override
    public Client saveClient(Client client) {
        log.trace("-----saveClient------ Client={}", client);

        Client savedClient = this.clientRepository.save(client);

        log.trace("saveClient: result={}", savedClient);

        return savedClient;
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        log.trace("updateClient: id={},Client={}", id, client);

        Optional<Client> optionalClient = clientRepository.findById(id);
        Client result = optionalClient.orElse(client);
        result.setSerialNumber(client.getSerialNumber());
        result.setName(client.getName());
        result.setSpent(client.getSpent());

        log.trace("updateClient: result={}", result);

        return result;
    }

    @Override
    public void deleteClient(Long id) {
        log.trace("deleteClient: id={}", id);

        clientRepository.deleteById(id);

        log.trace("deleteClient --- method finished");
    }
}
