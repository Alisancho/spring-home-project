package ru.cloud.entity.data;

import akka.util.ByteString;
import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;
import ru.cloud.entity.NettyMess;
import ru.cloud.entity.TaskType;


public record OneTask(@NotNull TaskType task,
                      @NotNull Option<String>fileName,
                      @NotNull Option<ByteString> byteString,
                      @NotNull Option<String>path) implements NettyMess {

}
