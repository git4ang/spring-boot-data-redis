package ang.neggaw.redis.services.implementations;

import ang.neggaw.redis.entities.RoleApp;
import ang.neggaw.redis.services.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:27
 */

@Service
@Log4j2
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final String KEY = "RoleApp";

    private final RedisTemplate<String, RoleApp> redisTemplate;
    private HashOperations<String, String, RoleApp> hashOperations;

    @PostConstruct
    private void init() { hashOperations = redisTemplate.opsForHash(); }


    @Override
    public RoleApp createRole(RoleApp role) {
//        hashOperations.put(KEY, UUID.randomUUID().toString(), role);
        hashOperations.put(KEY, role.getIdRole(), role);

        return hashOperations.get(KEY, role.getIdRole());
    }

    @Override
    public RoleApp updateRole(RoleApp role) {
        hashOperations.put(KEY, role.getIdRole(), role);

        return hashOperations.get(KEY, role.getIdRole());
    }

    @Override
    public Map<String, RoleApp> allRoles() {
        return hashOperations.entries(KEY);
    }

    @Override
    public RoleApp getRoleById(String idRole) {
        return hashOperations.get(KEY, idRole);
    }

    @Override
    public void deleteRoleById(String idRole) {
        hashOperations.delete(KEY, idRole);
    }
}

