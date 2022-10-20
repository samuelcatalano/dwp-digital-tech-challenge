package co.uk.bpdts.challenge.service.base;

import co.uk.bpdts.challenge.exception.BpdtsException;
import co.uk.bpdts.challenge.model.User;
import java.util.List;

public interface UserBaseService extends BaseService {

    List<User> getAllUsers() throws BpdtsException;
    List<User> getAllUsersFromCity(final String city) throws BpdtsException;
}