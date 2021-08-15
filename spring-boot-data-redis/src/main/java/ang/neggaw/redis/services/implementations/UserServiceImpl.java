package ang.neggaw.redis.services.implementations;

import ang.neggaw.redis.entities.RoleApp;
import ang.neggaw.redis.entities.UserApp;
import ang.neggaw.redis.services.RoleService;
import ang.neggaw.redis.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:25
 */

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String KEY = "UserApp";

    private final RedisTemplate<String, UserApp> redisTemplate;
    private final BCryptPasswordEncoder passwordEncoder;
    private HashOperations<String, String, UserApp> hashOperations;


    private final RoleService roleService;

    @PostConstruct
    private void init() { hashOperations = redisTemplate.opsForHash(); }

    @Override
    public Boolean createUser(UserApp user) {
        RoleApp role = roleService.getRoleById(user.getIdRole());
        if (role != null ) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(role));
            //hashOperations.put(KEY, UUID.randomUUID().toString(), user);
            hashOperations.put(KEY, user.getIdUser(), user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(UserApp user) {
        hashOperations.putIfAbsent(KEY, user.getIdUser(), user);
        return true;
    }

    @Override
    public Map<String, UserApp> allUsers() {
        return hashOperations.entries(KEY);
    }

    @Override
    public UserApp getUserById(String idUser) {
        return hashOperations.get(KEY, idUser);
    }

    @Override
    public void deleteUserById(String idUser) {
        hashOperations.delete(KEY, idUser);
    }
}
