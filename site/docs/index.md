# The meuh programming language

## Introduction
The goal of this project is to implement a programming language which can permit any
programmer to work easier without ruminating bad injury about used language.  
On the second hand, this can be a hobby for a time.

## Kind of language

The language adopts the philosophy of [write once, compile anywhere][woca]
and [KISS][kiss].

It is a general purpose [Turing Complete][Turing] language with a least those paradigms :

- Imperative
- Object-Oriented
- Procedural
- Concurrent
- Generic Programming
- Reflection

The next features will also be implemented :

- Thread multiplexing with [LLVM coroutines][coroutines] like in go with the [goroutine][goroutine]
- [Anonymous functions][lambda] called as Lambda expressions
- ... to be continued

## Source code example

```javascript
package io.meuh.test;

import meuh.lang.Number;
import meuh.lang.Integer;

public class IntegerCalculator extends Calculator implement PolynomialResolver {
  public int main(const String[] &amp;argv) throws PolynomialException {
    if (argv.length &lt; 1) {
      System.stdout.println("Need arguments");
      return 0;
    }
    return resolve(new Number[]{
      Integer.decodeString(argv[1]),
      Integer.decodeString(argv[2]),
    }).toInt();
  }

  protected Number resolve(const Number[] &amp;numbers) throws PolynomialException {
    if (numbers.length != 2) {
      throw new IllegalArgumentException("Only 2 numbers are expected, not: " + numbers.length);
    }
    return resolve(numbers[0], numbers[1]);
  }

  /** Solve a*x+b=0 */
  public Integer polynome(const Integer &amp;a, const Integer &amp;b) throws PolynomialException {
    if (a == 0) {
      throw new PolynomialException("The value of a is zero");
    }
    return -b/a;
  }
}
```

## The toolchain

The compiler [front-end][front-end] will be part of this project, and [LLVM][llvm]
will be used for the [back-end][back-end].

Compilation phases per compilation unit :

1. **Lexical Analyzer**: Produce tokens.
2. **Syntax Analyzer**: Produce an [Abstract Syntax Tree][ast] by the usage of an hand written [Recursive Descent Parser][rdp].
3. **Semantic Analyzer**: Check languages rules.
4. **SSA Converter**: Convert the [AST][ast] tree into a [SSA][ssa] tree.
5. **LLVMifier**: Convert the [SSA][ssa] tree into LLVM assembly language.
6. **[llvm-as][llvm-as]**: Translate LLVM assembly language into LLVM bitcode.
7. **[llvm-link][llvm-link]**: Link all compilation units together.
8. **[opt][opt]**: Run global optimization
9. **[llc][llc]**: Compile optimized LLVM bytecode into a native object file
10. **[lld][lld]**: Use the LLVM linker to link the native object file into an executable binary. [^1]

Optionally, the 9th and 10th step can be replaced with [lli][lli] to directly execute program from LLVM bitcode.

## License

```plain
Copyright © 2019-2021 VERDOÏA Laurent <verdoialaurent@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
```

[^1]: On macOS, only the host linker is supported

[ast]: https://en.wikipedia.org/wiki/Abstract_syntax_tree
[back-end]: https://en.wikipedia.org/wiki/Compiler#Back_end
[coroutines]: http://llvm.org/docs/Coroutines.html
[front-end]: https://en.wikipedia.org/wiki/Compiler#Front_end
[goroutine]: https://golang.org/doc/effective_go.html#goroutines
[kiss]: https://en.wikipedia.org/wiki/KISS_principle
[lambda]: https://en.wikipedia.org/wiki/Anonymous_function
[llc]: https://llvm.org/docs/CommandGuide/llc.html
[lld]: https://lld.llvm.org/
[llvm]: https://llvm.org/
[lli]: https://llvm.org/docs/CommandGuide/lli.html
[llvm-as]: https://llvm.org/docs/CommandGuide/llvm-as.html
[llvm-link]: https://llvm.org/docs/CommandGuide/llvm-link.html
[opt]: https://llvm.org/docs/CommandGuide/opt.html
[rdp]: https://en.wikipedia.org/wiki/Recursive_descent_parser
[ssa]: https://en.wikipedia.org/wiki/Static_single_assignment_form
[Turing]: https://en.wikipedia.org/wiki/Turing_completeness
[woca]: https://en.wikipedia.org/wiki/Write_once,_compile_anywhere
