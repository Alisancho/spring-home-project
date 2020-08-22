package ru.cloud.entity.auth;

import org.jetbrains.annotations.NotNull;
import ru.cloud.entity.NettyMess;

public record UserCloud(@NotNull String login,
                        @NotNull String pass) implements NettyMess {}