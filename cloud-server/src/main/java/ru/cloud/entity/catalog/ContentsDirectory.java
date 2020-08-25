package ru.cloud.entity.catalog;

import org.jetbrains.annotations.NotNull;
import ru.cloud.entity.NettyMess;


import java.util.Set;

public record ContentsDirectory(@NotNull Set<OneServerFile> files) implements NettyMess {
}
