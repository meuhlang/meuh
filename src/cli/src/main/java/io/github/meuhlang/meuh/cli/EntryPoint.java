/*
 * Copyright (C) 2021 VERDOÏA Laurent
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.meuhlang.meuh.cli;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import io.github.meuhlang.meuh.llvm.bootstrap.BootStrapFactory;

import java.io.File;
import java.io.InputStream;

public class EntryPoint {
    public static void main(final String... args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: meuh <os> <arch>");
            System.out.println();
            System.out.println("Supported platforms:");
            System.out.println("  linux x86_64");
            System.out.println("  darwin x86_64");
            return;
        }

        final var bootstrap = BootStrapFactory.build(args[0], args[1]);

        System.out.println("OS: " + bootstrap.getOs());
        System.out.println("Architecture: " + bootstrap.getArchitecture());

        {
            final var output = File.createTempFile("bootstrap.", ".llvm");
            // output.deleteOnExit();
            System.out.println("Bootstrap: " + output.getAbsolutePath());
            Files.asByteSink(output).writeFrom(bootstrap.getBootstrap());
        }

        {
            final var output = File.createTempFile("syscall.", ".llvm");
            // output.deleteOnExit();
            System.out.println("Syscall: " + output.getAbsolutePath());
            Files.asByteSink(output).writeFrom(bootstrap.getSyscall());
        }

    }
}
