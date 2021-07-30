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
package io.github.meuhlang.meuh.llvm.bootstrap;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.io.InputStream;

public abstract class BootStrap {
    private final String os;
    private final String architecture;

    public BootStrap(final String os, final String architecture) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(os));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(architecture));
        this.os = os;
        this.architecture = architecture;
    }

    public String getOs() {
        return os;
    }

    public String getArchitecture() {
        return architecture;
    }

    public abstract String getTargetDataLayout();

    public abstract String getTargetTriple();

    public abstract InputStream getBootstrap();

    public abstract InputStream getSyscall();
}
