package co.uk.bpdts.challenge.service;

import co.uk.bpdts.challenge.exception.BpdtsException;
import co.uk.bpdts.challenge.model.Location;
import co.uk.bpdts.challenge.model.User;
import co.uk.bpdts.challenge.service.base.CityBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */

@Service
public class CityService implements CityBaseService {

    @Autowired
    private UserService userService;

    @Value("${distance}")
    private double minimumDistance;

    @Value("${city.name}")
    private String city;

    @Override
    public Set<User> getUserWithDistanceFromLocation() throws BpdtsException {
        final Set<User> users = new HashSet<>();
        final List<User> allUsers = userService.getAllUsers();

        for (final User user : allUsers) {
            final Location location = new Location();
            location.setLongitude(user.getLongitude());
            location.setLatitude(user.getLatitude());

            if (this.checkDistanceFromLondon(location)){
                users.add(user);
            }
        }
        // Add all users from London
        users.addAll(userService.getAllUsersFromCity(city));
        return users;
    }

    @Override
    public Boolean checkDistanceFromLondon(final Location location) {
        double distanceFromLondon = this.calculateDistanceFromLocation(location);
        return distanceFromLondon <= minimumDistance;
    }

    @Override
    public Double calculateDistanceFromLocation(final Location location) {
        final Location city = new Location();
        city.setLatitude(location.getLatitude());
        city.setLongitude(location.getLongitude());

        double theta = location.getLongitude() - city.getLongitude();
        double distance = Math.sin(Math.toRadians(location.getLatitude())) * Math.sin(Math.toRadians(city.getLatitude())) +
                          Math.cos(Math.toRadians(location.getLatitude())) * Math.cos(Math.toRadians(city.getLatitude())) *
                          Math.cos(Math.toRadians(theta));

        distance = Math.toDegrees(Math.acos(distance));
        return (distance * 60 * 1.1515);
    }
}