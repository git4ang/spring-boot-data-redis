package ang.neggaw.redis.entities;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:23
 */

@Log4j2
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value = "role_redisHash")
public class RoleApp implements Serializable {

    @Id
    private String idRole;

    private String roleName;

    private Collection<UserApp> users;
}
