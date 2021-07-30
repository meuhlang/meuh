package io.github.meuhlang.meuh.llvm.commands;

import com.google.common.collect.ImmutableList;

public class LlvmLink {
    public LlvmLink(final String output, final String... inputs) {

    }

    public static abstract class Args {
        public abstract String output();
        public abstract ImmutableList<String> inputs();
        public abstract boolean verbose();

        public ImmutableList<String> toArgsList() {
            var builder = new ImmutableList.Builder();
            builder.add("-o", output());
            builder.addAll(inputs());


            return builder.build();
        }
    }
}
