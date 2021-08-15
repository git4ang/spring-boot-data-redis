package ang.neggaw.redis.services.implementations;

import ang.neggaw.redis.entities.UserApp;
import ang.neggaw.redis.services.UserService;

import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:25
 */

public class UserServiceImpl implements UserService {


    @Override
    public Boolean createUser(UserApp user) {
        return null;
    }

    @Override
    public Boolean updateUser(UserApp user) {
        return null;
    }

    @Override
    public Map<String, UserApp> allUsers() {
        return null;
    }

    @Override
    public UserApp getUserById(String idUser) {
        return null;
    }

    @Override
    public void deleteUserById(String idUser) {

    }
}
