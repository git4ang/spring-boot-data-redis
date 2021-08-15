package ang.neggaw.redis.restControllers;

import ang.neggaw.redis.entities.UserApp;
import ang.neggaw.redis.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:34
 */

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserApp> createUser(@RequestBody UserApp user) {
        if (userService.createUser(user))
            return ResponseEntity.status(HttpStatus.CREATED).body(getUserById(user.getIdUser()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(value = "/{idUser}")
    public ResponseEntity<UserApp> updateUser(@PathVariable(value = "idUser") String idUser, @RequestBody UserApp user) {
        if (user.getIdUser().equals(idUser)) {
            if (userService.updateUser(user))
                return ResponseEntity.status(HttpStatus.OK).body(getUserById(idUser));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/{idUser}")
    public UserApp getUserById(@PathVariable(value = "idUser") String idUser) {
        return userService.getUserById(idUser);
    }

    @GetMapping
    public Map<String, UserApp> allUsers(){
        return userService.allUsers();
    }

    @DeleteMapping(value = "/{idUser}")
    public void deleteUserById(@PathVariable(value = "idUser") String idUser) {
        userService.deleteUserById(idUser);
    }
}