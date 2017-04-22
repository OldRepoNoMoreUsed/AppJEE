package app.services;

/**
 * Created by nolvulon on 22.04.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
