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
package io.github.meuhlang.meuh.llvm.bootstrap.darwin.x86_64;

import io.github.meuhlang.meuh.llvm.bootstrap.BootStrap;

import java.io.InputStream;

public class Bootstrap extends BootStrap {
    public Bootstrap(String os, String architecture) {
        super(os, architecture);
    }

    @Override
    public InputStream getBootstrap() {
        return getClass().getClassLoader().getResourceAsStream("bootstrap.llvm");
    }

    @Override
    public InputStream getSyscall() {
        return getClass().getClassLoader().getResourceAsStream("syscall.llvm");
    }

    @Override
    public String getTargetDataLayout() {
        return "e-m:o-i64:64-f80:128-n8:16:32:64-S128";
    }

    @Override
    public String getTargetTriple() {
        return "x86_64-apple-darwin16.6.0";
    }
}
