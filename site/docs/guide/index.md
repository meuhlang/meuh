# The MeuhLang Guide

!!! note ""
    :warning: This section is still in progress

## Your first program

This is the revisited tradional first program :

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

### Variable + Constants

```swift
let myConstant = 42
var myVariable = 42
myVariable = 24
```

### Type inferance

```swift
let implicitInteger = 314
let implicitDouble = 3.14159
let explicitDouble: double = 3.14159
```

### Casting

```swift
let text = "Your age is: "
let age = 42
let dialog = text + String(age)
```

### Text formating

```swift
let age = 42
let yearsText = "You arge %{age} years old"
let monthText = "You arge %{age*12} months old"
```

### Array and slices

```swift
var emptyArray: [42]String
var emptySlice: []String
let populatedSlice = ["Solid", "Liquid", "Gas"]
populatedSlice.append("Plasma")
```
