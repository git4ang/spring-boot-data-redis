package ang.neggaw.redis.services;

import ang.neggaw.redis.entities.RoleApp;

import java.util.Map;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:25
 */

public interface RoleService {
    void createRole(RoleApp role);
    void updateRole(RoleApp role);
    Map<String, RoleApp> allRoles();
    RoleApp getRoleById(String idRole);
    void deleteRoleById(String idRole);
}
