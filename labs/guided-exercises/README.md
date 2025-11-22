> 🇬🇷 Ελληνική έκδοση: [README_GR.md](./README_GR.md)

## README (EN)

# Guided Exercises — Java (1–6) & C++ (1–2)

This repository contains the final solutions for the **Guided / Lab Exercises**
of the course **Object-Oriented Programming**, implemented in **Java** and **C++**.
The exercises are designed as step-by-step practice on core and intermediate OOP concepts,
through small guided examples. 

---

## 🟦 Guided Exercises — Java

Java exercises (1–6) cover introductory Java/OOP features, inheritance,
collections, file I/O, and exception handling.

### Exercise 1 — Creating a project, basic input/output
Goal:
- Create and run a Java project in BlueJ.
- Practice command-line input and console output. :contentReference[oaicite:9]{index=9}  
File:
- `age.java`

---

### Exercise 2 — `Window` class, constructors, and `this`
Goal:
- Build a class with an instance field (`size`).
- Use constructor overloading (default and parameterized).
- Understand variable shadowing (local vs instance) and the role of `this`.  
File:
- `Window.java`  
(the class is refined through sub-questions, ending in the provided final version)

---

### Exercise 3 — Inheritance `Window → MWindow` and `super`
Goal:
- Extend `Window` into `MWindow`.
- Use `protected` members and constructor chaining with `super(...)`.
- Override methods and access parent state/behavior.
- Demonstrate field/method access differences using casting.   
Files:
- `Window.java`
- `MWindow.java`
- `RunWindow.java`

---

### Exercise 4 — `Person` / `MarriedPerson`, overriding, and Collections
Goal:
- Implement base class `Person` and subclass `MarriedPerson`.
- Add extra fields (e.g., sex, children) and adjust constructors accordingly.
- Implement `printInfo()` in `Person` and **override** it in `MarriedPerson`
  using `super.printInfo()`.
- Practice arrays of objects, `ArrayList`, `Iterator`,
  and understand the use of Generics.   
Files:
- `Person.java`
- `MarriedPerson.java`
- `MyTester.java`

---

### Exercise 5 — File I/O and writing to a log file
Goal:
- Work with file streams (FileWriter / BufferedWriter).
- Write values of different types into a file (e.g., `test.log`)
  and inspect the produced file content. :contentReference[oaicite:12]{index=12}  
File:
- `IO_Tester.java`

---

### Exercise 6 — Exceptions and custom exception class
Goal:
- Understand runtime exceptions (e.g., division by zero).
- Use `try/catch` to keep execution safe.
- Create and use a custom exception (`DivideByZeroException`)
  with `throw` / `catch`. :contentReference[oaicite:13]{index=13}  
Files:
- `Exception_Tester.java`
- `DivideByZeroException.java`

---

## 🟥 Guided Exercises — C++

The C++ handout includes 2 exercises introducing the language
and basic object-oriented techniques.

### Exercise 1 — C++ basics, classes & operator overloading
Goal:
- Create and run a C++ program in Code::Blocks.
- Practice console I/O (`cin/cout`) and `for` loops.
- Implement class `Kouti` with setters and volume calculation.
- Overload operator `+` to add dimensions of two objects.   
File:
- `askisi1.cpp`

---

### Exercise 2 — Shape inheritance & polymorphism
Goal:
- Create a base class `Polygon` and derived classes (e.g., `Rectangle`, `Triangle`)
  sharing a common area interface.
- Use a `virtual area()` method to demonstrate **late binding / dynamic dispatch**.
- Call methods via a base-class pointer to show polymorphic behavior.   
File:
- `askisi2.cpp`

---

## Learning Outcomes (Guided Exercises)
After completing all guided exercises, students practice:

- Java and C++ core syntax,
- class design and implementation,
- constructors and overloading,
- inheritance and method overriding,
- this / super usage in Java,
- virtual methods and dynamic dispatch in C++,
- collections and iterators in Java,
- file I/O in Java,
- exception handling and custom exceptions.
