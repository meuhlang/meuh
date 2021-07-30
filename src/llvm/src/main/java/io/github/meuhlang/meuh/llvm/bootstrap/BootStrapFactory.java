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

public abstract class BootStrapFactory {

    private BootStrapFactory() {}

    public static BootStrap build(final String os, final String architecture) throws UnsupportedPlatformException {
        if ("linux".equals(os) && "x86_64".equals(architecture)) {
            return new io.github.meuhlang.meuh.llvm.bootstrap.linux.x86_64.Bootstrap(os, architecture);
        } else if ("darwin".equals(os) && "x86_64".equals(architecture)) {
            return new io.github.meuhlang.meuh.llvm.bootstrap.darwin.x86_64.Bootstrap(os, architecture);
        }

        throw new UnsupportedPlatformException(os, architecture);
    }

}
