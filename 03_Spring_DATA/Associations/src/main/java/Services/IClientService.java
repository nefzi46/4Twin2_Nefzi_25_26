package Services;

import Entity.Client;

import java.util.List;

public interface IClientService {
    List<Client> retieveAllClients();

    Client addclient(Client e);
    Client updateClient(Client e);
    Client retieveClient(Long idClient);
    void removeClient(Long idClient);
    List<Client> addClients (List<Client>Clients);

}
