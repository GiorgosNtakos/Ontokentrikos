> 🇬🇷 Ελληνική έκδοση: [README_GR.md](./README_GR.md)

# Object-Oriented Programming — Sets 1–3 (Java & C++)

## Overview
This repository contains the final solutions for **three lab exercise sets** of the course *Object-Oriented Programming* (Academic Year 2019–2020).  
The assignments cover OOP design and implementation in **Java (Sets 1–2)** and **C++ (Set 3)**.  
All source files reflect the **final versions** after subsequent questions required modifications and refinements. 

---

## Contents / Sets

### Set 1 — Java: Core Syntax, Classes & Inheritance
Set 1 focuses on fundamental Java and OOP concepts. 

**Main topics:**
- Multiple-choice questions on Java syntax, types, arrays, and operators.
- Implementation of `Kouti` (rectangular box) with:
  - dimension fields,
  - constructor overloading,
  - volume/surface area methods,
  - overridden `toString()`.
- `Kyvos` subclass modeling a cube with specialized method overrides.
- `Spirtokouto` subclass extending a box with an extra attribute (weight).
- `RunMe` driver for instantiation, validation, and output.

**Concepts practiced:**
constructors, overloading, inheritance, overriding, `super`, polymorphism, basic exceptions.

---

### Set 2 — Java: Abstract Classes, Polymorphism, Collections, Exceptions & Files
Set 2 extends OOP to more advanced use-cases. 

**Exercise 1 — Worker Hierarchy & Company**
- Abstract base class `Worker` holding employee data and assigning a **unique `wCode` automatically** upon creation.
- Subclasses:
  - `PermanentWorker` → payment equals salary.
  - `NonPermanentWorker` → payment equals hoursWorked × hourlyPayment.
- `Company` class maintaining an `ArrayList<Worker>` and adding employees via `addWorker()`.
- `Main` class showcasing polymorphic salary calculation and printing.

**Exercise 2 — Safe Input & Exception Handling**
- Reading values from stdin using `try/catch`.
- Handling `NumberFormatException` and `ArithmeticException` to keep execution robust.

**Exercise 3 — Text File Processing**
- Reads `input.txt`, performs text processing (counts/replacements), writes `output.txt`.
- Demonstrates Java I/O streams and checked exception handling.

**Concepts practiced:**
abstract classes, late binding, collections (`ArrayList`, iterators, enhanced for), overriding/overloading, file I/O, checked/unchecked exceptions.

---

### Set 3 — C++: Hierarchies, Polymorphism, Operators, STL
Set 3 revisits OOP in C++ with emphasis on dynamic dispatch and STL. 

**Exercise 1 — Animal Hierarchy**
- Base class `Animal` with private members `legs`, `sound` and a protected constructor.
- Derived classes `Dog`, `Bird`, `Fish` initialize inherited members via constructor chaining.
- `virtual getClass()` enabling **late binding**.
- Use of `Animal*` pointers stored in a **vector<Animal*>**, calling `printInfo()` polymorphically. :contentReference[oaicite:11]{index=11}

**Exercise 2 — Vehicle, friend & operator overloading**
- `Vehicle` class describing a vehicle trip.
- `friend show(Vehicle)` function for output.
- Overloaded `>` operator comparing vehicle speeds (equivalent to `isFasterThan()`). :contentReference[oaicite:12]{index=12}

**Concepts practiced:**
constructors & access control, virtual methods, base-class pointers, dynamic dispatch, STL `vector`, friend functions, operator overloading.
