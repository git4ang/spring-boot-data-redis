package ang.neggaw.redis.services;

import ang.neggaw.redis.entities.UserApp;

import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:25
 */

public interface UserService {
    Boolean createUser(UserApp user);
    Boolean updateUser(UserApp user);
    Map<String, UserApp> allUsers();
    UserApp getUserById(String idUser);
    void deleteUserById(String idUser);
}
