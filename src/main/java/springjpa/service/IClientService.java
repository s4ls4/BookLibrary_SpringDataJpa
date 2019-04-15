package springjpa.service;

import springjpa.domain.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClients();
    void saveClient(Client client);

    void update(Client client);

    void delete(Long id);
}
