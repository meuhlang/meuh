package io.github.meuhlang.meuh.llvm.commands;

import com.google.common.collect.ImmutableList;

abstract class AbstractCommand {

    private final ImmutableList<String> args;

    AbstractCommand(final ImmutableList<String> args) {
        this.args = args;
    }

    public boolean run() throws Exception {
        var builder = new ProcessBuilder(args);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectInput(ProcessBuilder.Redirect.DISCARD);

        var process = builder.start();
        var status = process.waitFor();

        return status == 0;
    }
}
