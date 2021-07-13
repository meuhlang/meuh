# A MeuhLang Tour

!!! note ""
    :warning: This section is still in progress

## Your first program

This is the revisited traditional first program :

```swift
func main() {
    println("Hello, world!")
}
```

Every program entry point should start with the `main()` function.
You don't need to write semicolons at the end of every statement.

This tour gives you enough information to start writing software in Meuh
and let you understand the spirit of this language.

## Simple Values

### Variables and Mutability

By default all variables are **immutable**.

This means that once you assign a value to an immutable variable,
you cannot change the value in a later assignment.

```rust
var x = 5
println("The value of x is %{x}.")
x = 6
println("The value of x is %{x}.")
```

The above example cannot compile since on line 3, we are trying to set another value to `x`.

In way to take off the **immutable** facet of the variable, we can you the `mut` keyword.

```rust
var mut x = 5
println("The value of x is %{x}.")
x = 6
println("The value of x is %{x}.")
// Prints:
// The value of x is 5.
// The value of x is 6.
```

### Constants

Use `const` to make a constant and `var` to make a variable.
The value of a constant doesn't need to be known at compile tile, but you must assign
it a value at declaration time.  
This means you can use constants to name a wheel known value that you determine once but use in many places.

```c++
const myConstant = 42
var mut myVariable = 42
myVariable = 24
```

### Type inference

A constant or variable must have the same type as the value you want to assign to.
If you do not write the type, the compiler will infer its type.
When the initial declaration or assignment doesn't provide enough information,
specify the type by writing it after the variable, separated by a colon.

```swift
const implicitInteger = 42
const implicitDouble = 42.0
const explicitDouble: double = 42
```

On the above example, without an explicit type declaration `double`,
the constant `explicitDouble` would have been inferred as an integer.

### Casting

With the type safety policy in MeuhLang, value are never implicitly converted to another type.
You should use an explicit casting operator whenever a conversion is needed.

```swift
var text = "Your age is: "
var age = 42
var dialog = text + string(age)
```

### Simple Text formatting

A simple way to formatting is to directly insert value inside a string, enclosed inside a `%{}`.

```swift
var age = 42
var yearsText = "You are %{age} years old"
var monthText = "You are %{age*12} months old"
var name = "John Doe"
var greeting = "Hello, my name is \"%{name}\".\nHow are you ?"
```

Multiple line text can be written within the three double quotation marks `"""`.
To keep source code well-formed, indentation of the text is removed, as long as it matches the
indentation of the closing three double quotation marks.

```swift
var name = "John Doe"
var multilineGreeting = """
Hello,my name is "%{name}".
How are you ?
"""
```

On the above examples, `greeting` and `multilineGreeting` have the same value.

### Array and Slice

Both **array** and **slice** permit keeping data indexed with a positive continuous set of
integer, starting at 0.
Array size must be defined during declaration when this is not needed for slice.
This permit slice to growth and shrink on demand at runtime.

```swift
var emptyArray: [42]string
var emptySlice: []string
var populatedArray: [3]string = ["Air", "Fire", "Water"]
var mut populatedSlice = ["Air", "Fire"]
populatedSlice += "Water"
var remark = "populatedArray length is %{populatedArray.length()}"
```

On the above example, after the execution, `populatedArray` and `populatedSlice` contains the same
values.

### Optional values

Optional values are immutables.  
An optional either contains a value or contains `nil` to indicate that a value is missing.

The question mark `?` operator permit to declare a type as optional.

```swift
var optionalString string? = "The optional value"
var emptyOptionalInteger int?
```

```swift
class RGBColor {
    public var red: int8
    public var green: int8
    public var blue: int8

    func __constructor__(red int8, green int8, blue int8) {
        self.red = red
        self.green = green
        self.blue = blue
    }
}

var yellow = RGBColor(255, 255, 0)
var cyan = RGBColor(0, 255, 255)
var magenta = RGBColor(255, 0, 255)

var optionalColor: RGBColor? = yellow
var optionalMutableColor: mut RGBColor? = RGBColor(0, 128, 255)
optionalMutableColor?.red = 42
```

You can use the `??` to use a default value when the value is missing.

```swift
var optionalName: String?
print("Hello: '%{optionalName ?? "No Body..."}'")
// Prints "Hello: No Body..."
```

You can use the `!` to raise an error if the value is missing.

```swift
var optionalName: String?
print("Hello: '%{optionalName!}'")
// Error is raised
```

### Conditional

This can be usefull to be used as condition.

```swift
var serverResponse: String?
if var userName = serverResponse? {
    println("Username: %{userName}")
} else {
    println("User not found")
}
```

### Chaining

You can also take leverage of chaining.

```swift
var serverResponse: ServerResponse?
if var adminId = serverResponse?group?admin?id? {
    println("Admin user id: %{adminId}")
} else {
    println("Admin ID not found")
}
```

## Control Flow

Use `if` and `switch` to make conditionals, use `for-in`, `while`, and `repeat-while` to make loops,
use `select` to wait for `send` or `receive` operations.
Parentheses around the condition or loop variable are optional. Braces around the body are required.

### The `if` conditional

The `if` conditional permit to execute one set of instructions or the other depending on the given
condition.

```swift
var hour = 9
if hour < 12 {
    print("Morning")
} else {
    print("Afternoon")
}
// Prints "Morning"
```
You can use `if` and `var` together to restain variable scope to the body of the `if` statement.

```go
func getName() -> String {
    return "John Doe"
}

if var name = getName(); !name.isEmpty() {
    print("Hello %{name}")
}
// Prints "Hello John Doe"
```

You can use `if` to work with optionals.

```swift
var optionalName: String? = "John Doe"
if var name = optionalName {
    print(name)
}
// Prints John Doe
```

### The `for-in` loop

```swift
var interestingNumbers = [
    "Prime": [2, 3, 5, 7, 11, 13],
    "Fibonacci": [1, 1, 2, 3, 5, 8],
    "Square": [1, 4, 9, 16, 25],
]
var largest = 0
for (_, numbers) in interestingNumbers {
    for number in numbers {
        if number > largest {
            largest = number
        }
    }
}
print(largest)
// Prints "25"
```

```swift
var total = 0
for i in 0..<4 {
    total += i
}
print(total)
// Prints "6"
```

### The `while` loop

```swift
var n = 2
while n < 100 {
    n *= 2
}
print(n)
// Prints "128"
```
### The `repeat-while` loop

```swift
var n = 2
repeat {
    n *= 2
} while n < 100
print(m)
// Prints "128"
```

### The `select` operation

Please refer to the spirit of the [select](https://golang.org/ref/spec#Select_statements) statement in Go.

## Functions

```swift
func noReturnValue() {
    print("Hello")
}

func withReturnValue() -> String {
    return "Hello"
}

func multipleReturnValues() -> (String, int) {
    return "Hello", 5
}

func withArgument(name: String) -> String {
    return "Hello %{name}"
}

withArgument(name: "John")

func unnamedArgument(_ name: String) -> String {
    return "Hello %{name}"
}

unnamedArgument("John")
```

```swift
func constExpression() constexpr -> int {
    return 3.0 + 0.14
}

const PI = constExpression()
```

```swift
func makeIncrementer() -> ((Int) -> Int) {
    func addOne(number: Int) -> Int {
        return 1 + number
    }
    return addOne
}
var increment = makeIncrementer()
increment(7)
```

## Structures

```swift
struct Card {
    var rank: Rank
    var suit: Suit
    func simpleDescription() -> String {
        return "The %{rank.simpleDescription()} of %{suit.simpleDescription()}"
    }
}
var threeOfSpades = Card(rank: .three, suit: .spades)
var threeOfSpadesDescription = threeOfSpades.simpleDescription()
```

## Objects and Classes

Classes are like structures but have a constructor and a destructor.

```swift
class NamedShape {
    var numberOfSides: int = 0
    var mut name: String

    func __constructor__(name: String) {
        self.__constructor__(name: name, numberOfSides: 0)
    }

    func __constructor__(name: String, numberOfSides: int) {
        setName(name)
        self.numberOfSides = numberOfSides
    }

    mut func setName(_ name: String) {
        self.name = name
    }

    func simpleDescription() const -> String {
        return "A shape with %{numberOfSides} sides."
    }
}

ns = NamedShape(name: "square", numberOfSides: 4)

class Square : NamedShape {
    var mut sideLength: double { get set }

    func __constructor__(sideLength: double) {
        self.sideLength = sideLength
        super.__constructor__(name: "square")
    }

    func area() -> double {
        return sideLength * sideLength
    }

    override func simpleDescription() -> String {
        return "A square with sides of length %{sideLength}."
    }
}

s = Square(3)
print(s.area())
// Prints "9"
s.setSideLength(14)
print(s.area())
// Prints "196"
```

## Enumerations

## Error Handling

## Generics
