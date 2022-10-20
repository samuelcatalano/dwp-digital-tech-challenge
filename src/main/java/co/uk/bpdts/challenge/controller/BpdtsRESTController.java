package co.uk.bpdts.challenge.controller;

import co.uk.bpdts.challenge.exception.BpdtsException;
import co.uk.bpdts.challenge.json.ErrorMessage;
import co.uk.bpdts.challenge.model.User;
import co.uk.bpdts.challenge.service.CityService;
import co.uk.bpdts.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */

@RestController
@RequestMapping("/api/user")
public class BpdtsRESTController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/users-city/{city}", produces = "application/json")
    public ResponseEntity<?> getAllUsersFromCity(@PathVariable final String city) {
        try {
            final List<User> users = this.userService.getAllUsersFromCity(city);
            return ResponseEntity.ok(users);
        } catch (final BpdtsException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage()
                            .code(500)
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.name()));
        }
    }

    @GetMapping(value = "/all-users", produces = "application/json")
    public ResponseEntity<?> getUserWithDistanceFromLocation() {
        try {
            final Set<User> users = this.cityService.getUserWithDistanceFromLocation();
            return ResponseEntity.ok(users);
        } catch (BpdtsException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage()
                            .code(500)
                            .message(e.getMessage())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.name()));
        }
    }
}