package ang.neggaw.redis.entities;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

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
@RedisHash(value = "user_redisHash")
public class UserApp implements Serializable {

    @Id
    private String idUser;

    private String username;

    private String password;

    private String email;

    private boolean enabled;

    private List<RoleApp> roles;
}