package ang.neggaw.redis.restControllers;

import ang.neggaw.redis.entities.RoleApp;
import ang.neggaw.redis.services.RoleService;
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
@RequestMapping(value = "/api/roles")
public class RoleRestController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleApp> createRole(@RequestBody RoleApp role) {

        RoleApp r = roleService.createRole(role);
        if(r != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(r);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(value = "/{idRole}")
    public ResponseEntity<RoleApp> updateRole(@PathVariable(value = "idRole") String idRole, @RequestBody RoleApp role) {

        if (role.getIdRole() != idRole)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        RoleApp r = roleService.updateRole(role);
        if (r != null)
            return ResponseEntity.status(HttpStatus.OK).body(r);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(value = "/{idRole}")
    public RoleApp getRoleById(@PathVariable(value = "idRole") String idRole) {
        return roleService.getRoleById(idRole);
    }

    @GetMapping
    public Map<String, RoleApp> allRoles(){
        return roleService.allRoles();
    }

    @DeleteMapping(value = "/{idRole}")
    public void deleteRoleById(@PathVariable(value = "idRole") String idRole) {
        roleService.deleteRoleById(idRole);
    }
}