package io.github.meuhlang.meuh.llvm.commands;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.inferred.freebuilder.FreeBuilder;

public class As extends AbstractCommand{
    public As(final Args args) {
        super(Preconditions.checkNotNull(args).toArgsList());
    }

    @FreeBuilder
    public static abstract class Args {
        public abstract String input();

        public abstract String output();

        public ImmutableList<String> toArgsList() {
            return ImmutableList.of(
                    "-o", output(),
                    input()
            );
        }

        static class Builder extends As_Args_Builder {

            @Override
            public Builder input(final String input) {
                Preconditions.checkArgument(!Strings.isNullOrEmpty(input));
                return super.input(input);
            }

            @Override
            public Builder output(final String output) {
                Preconditions.checkArgument(!Strings.isNullOrEmpty(output));
                return super.output(output);
            }

        }

    }

}
