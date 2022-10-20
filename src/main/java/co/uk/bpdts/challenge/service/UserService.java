package co.uk.bpdts.challenge.service;

import co.uk.bpdts.challenge.exception.BpdtsException;
import co.uk.bpdts.challenge.model.User;
import co.uk.bpdts.challenge.service.base.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */

@Service
public class UserService implements UserBaseService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.users.url}")
    private String API_USERS_URL;

    @Value("${api.user.location.url}")
    private String API_USER_LOCATION_URL;

    @Override
    public List<User> getAllUsers() throws BpdtsException {
        return restTemplate.exchange(
                API_USERS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>(){}).getBody();
    }

    @Override
    public List<User> getAllUsersFromCity(final String city) throws BpdtsException {
        final String location = API_USER_LOCATION_URL + city + "/users";
        return restTemplate.exchange(
                location,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>(){}).getBody();
    }
}