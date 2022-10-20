package co.uk.bpdts.challenge.service.base;

import co.uk.bpdts.challenge.exception.BpdtsException;
import co.uk.bpdts.challenge.model.Location;
import co.uk.bpdts.challenge.model.User;

import java.util.Set;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */
public interface CityBaseService extends BaseService {

    Set<User> getUserWithDistanceFromLocation() throws BpdtsException;
    Double    calculateDistanceFromLocation(final Location location) throws BpdtsException;
    Boolean   checkDistanceFromLondon(final Location city) throws BpdtsException;
}