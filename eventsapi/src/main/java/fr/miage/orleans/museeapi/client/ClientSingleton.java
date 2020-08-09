package fr.miage.orleans.museeapi.client;

public class ClientSingleton {
    private static final ServiceClient instance  = new ServiceClient();

    public static final ServiceClient getInstance(){
        return instance;
    }
}
