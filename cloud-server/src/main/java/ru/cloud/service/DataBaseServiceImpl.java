package ru.cloud.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.cloud.entity.auth.UserCloud;
import ru.cloud.entity.db.UserTable;

import java.util.Optional;
import java.util.Set;

@Service
public class DataBaseServiceImpl {
    private static final Set<UserTable> usersTable = Set.of(
            new UserTable("admin", "qwerty1234", System.getProperty("user.dir") + "/server/src/main/resources/storage/admin"),
            new UserTable("user1", "user1", System.getProperty("user.dir") + "/server/src/main/resources/storage/user")
    );

    public static Optional<UserTable> userIsReal(@NotNull final UserCloud userCloud) {
       return usersTable.stream().filter(o -> o.login().equals(userCloud.login()) & o.pass().equals(userCloud.pass())).findFirst();
    }
}
