package service;

import model.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClients();
    Client saveClient(Client client);

    Client updateClient(Long id, Client convertDtoToModel);

    void deleteClient(Long id);
}