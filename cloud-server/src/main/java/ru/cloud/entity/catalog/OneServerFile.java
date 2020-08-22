package ru.cloud.entity.catalog;

import org.jetbrains.annotations.NotNull;
import ru.cloud.entity.NettyMess;

public record OneServerFile(@NotNull FileType fileType,
                            @NotNull String nameFile,
                            @NotNull String sizeFile) implements NettyMess {
}
