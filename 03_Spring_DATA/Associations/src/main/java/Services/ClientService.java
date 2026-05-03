package Services;

import Entity.Client;
import repositories.ClientRepositories;

import java.util.List;

public class ClientService implements IClientService {

    ClientRepositories clientRepositories;
    @Override
    public List<Client> retieveAllClients() {
        return clientRepositories.findAll();
    }

    @Override
    public Client addclient(Client e) {
        return clientRepositories.save(e);
    }

    @Override
    public Client updateClient(Client e) {
        return clientRepositories.save(e);
    }

    @Override
    public Client retieveClient(Long idClient) {
        return clientRepositories.findById(idClient).get(idClient);
    }

    @Override
    public void removeClient(Long idClient) {
    return clientRepositories.deleteById(idClient);
    }

    @Override
    public List<Client> addClients(List<Client> Clients) {
        return clientRepositories.saveAll(Clients);
    }
}
