> 🇬🇷 Ελληνική έκδοση: [README_GR.md](./README_GR.md)

# CEID E-Shop — Object Oriented Programming Project 2019 - 2020 (Java)


![MIT License](https://img.shields.io/badge/License-MIT-green.svg)
![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Version](https://img.shields.io/badge/Version-1.0-blue.svg)
![GitHub contributors](https://img.shields.io/github/contributors/GiorgosNtakos/Ontokentrikos)
![Last Commit](https://img.shields.io/github/last-commit/GiorgosNtakos/Ontokentrikos)
![Repo Size](https://img.shields.io/github/repo-size/GiorgosNtakos/Ontokentrikos)
![Code Size](https://img.shields.io/github/languages/code-size/GiorgosNtakos/Ontokentrikos)

A full Java console application simulating an online shop system, developed for the Object-Oriented Programming course (CEID – University of Patras).  
All code was implemented entirely by the two contributors according to the official project specification.

---

## 📌 Project Overview
This project implements a functional E-Shop simulation using OOP principles in Java.  
It includes:

- Owner and Buyer roles  
- Product hierarchy with subclasses  
- Shopping cart management  
- Stock, bonus points, and buyer category system  
- Category-based product browsing  
- Checkout and courier cost logic  
- Custom exceptions for illegal operations  
- Multi-level console menus with “Back” navigation

---

## 📦 Features

### ✔ User System
- Abstract base class: `User`
- Subclasses: `Owner` and `Buyer`
- Login using email
- New Buyer account creation (name + email)
- Separate menus for Owner and Buyer

### ✔ Item Hierarchy
- Abstract class `Item`
- Subclasses: `Pen`, `Pencil`, `Notebook`, `Paper`
- Each class implements `getDetails()`
- Unique IDs, description, price, and stock handling

### ✔ E-Shop Core
- Class `EShop` stores:
  - All items
  - All buyers
  - The owner
- Checks for duplicate item IDs and duplicate buyer emails  
- Displays categories and items by category
- Shows buyer status (bonus, category, personal details)

### ✔ Shopping Cart
Each Buyer has one `ShoppingCart` with:

- Add item  
- Remove item  
- Change quantity (add / subtract)  
- Clear cart  
- Stock reservation and return  
- Calculation of:
  - Net value
  - Courier cost (depending on buyer category)
  - Final total

Checkout:
- Confirms purchase  
- Awards **10% bonus points**  
- Empties the cart  

### ✔ Buyer Categories & Bonus
- Bronze: 0–99 points
- Silver: 100–199 points
- Gold: 200+ points

Courier cost:
- Bronze → 2% (min €3)
- Silver → 50% discount
- Gold → free shipping

### ✔ Exception Handling
Custom exceptions:

- `OutOfStock`
- `NegativeStock`
- `WrongID`
- `DuplicateItemIDException`
- `DuplicateBuyerEmailException`

Used as required by the specification (instead of extensive if-else checks).

### ✔ Console Menu System
- Fully text-based interface  
- Clear separation of Owner and Buyer actions  
- Multi-level browsing  
- Back navigation in every submenu  
- Strict input validation  

---

## 📁 Project Structure

src/
 ├── Main.java  
 ├── Menu.java  
 ├── EShop.java  
 ├── User.java  
 ├── Owner.java  
 ├── Buyer.java  
 ├── ShoppingCart.java  
 ├── Item.java  
 ├── ItemOrdered.java  
 ├── Pen.java  
 ├── Pencil.java  
 ├── Paper.java  
 ├── Notebook.java  
 └── exceptions/  
      ├── OutOfStock.java  
      ├── NegativeStock.java  
      ├── WrongID.java  
      ├── DuplicateItemIDException.java  
      └── DuplicateBuyerEmailException.java  

---

## 👥 Contributors
Project fully implemented by the two students as part of the CEID OOP course.
