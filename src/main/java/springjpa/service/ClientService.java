package springjpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springjpa.domain.Client;
import springjpa.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);


    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        log.trace("getAllClient --- method entered");

        List<Client> result = clientRepository.findAll();

        log.trace("getAllClients: result={}", result);

        return result;
    }

    @Override
    public void saveClient(Client client) {
        log.trace("saveClient: client={}", client);

        clientRepository.save(client);

        log.trace("saveClient --- method finished");
    }

    @Override
    @Transactional
    public void update(Client client) {
        log.trace("update: client={}", client);

        clientRepository.findById(client.getId())
                .ifPresent(client1 -> {
                    client1.setSerialNumber(client.getSerialNumber());
                    client1.setName(client.getName());
                    client1.setSpent(client.getSpent());
                    log.debug("update --- client updated? --- " +
                            "client={}", client1);
                });

        log.trace("update --- method finished");
    }

    @Override
    public void delete(Long id) {
        log.trace("delete: id={}", id);

        clientRepository.deleteById(id);

        log.trace("delete --- method finished");
    }
}
