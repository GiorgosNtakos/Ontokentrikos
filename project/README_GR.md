# CEID E-Shop — Project Αντικειμενοστραφούς Προγραμματισμού 2019- 2020 (Java)

![MIT License](https://img.shields.io/badge/License-MIT-green.svg)
![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Version](https://img.shields.io/badge/Version-1.0-blue.svg)
![Contributors](https://img.shields.io/badge/Contributors-2-lightgrey.svg)
![Repo Size](https://img.shields.io/github/repo-size/GiorgosNtakos/Ontokentrikos)
![Code Size](https://img.shields.io/github/languages/code-size/GiorgosNtakos/Ontokentrikos)

Πλήρης υλοποίηση συστήματος ηλεκτρονικού καταστήματος σε Java (console), στο πλαίσιο του μαθήματος ΑΠ (CEID – Πανεπιστήμιο Πατρών).  
Όλος ο κώδικας υλοποιήθηκε εξολοκλήρου από τους δύο φοιτητές σύμφωνα με την επίσημη εκφώνηση.

---

## 📌 Περιγραφή
Το πρόγραμμα προσομοιώνει ένα **ηλεκτρονικό κατάστημα (E-Shop)** με πλήρη λειτουργικότητα:

- Ρόλοι Owner και Buyer  
- Ιεραρχία προϊόντων  
- Διαχείριση καλαθιού  
- Stock, bonus και κατηγορίες αγοραστών  
- Browsing ανά κατηγορία  
- Λειτουργία checkout & courier  
- Εξαιρέσεις για κάθε παράνομη ενέργεια  
- Πολυεπίπεδο μενού με “Back” επιλογή

---

## 📦 Χαρακτηριστικά

### ✔ Σύστημα Χρηστών
- Abstract κλάση: `User`
- Υποκλάσεις: `Owner` και `Buyer`
- Είσοδος με email  
- Δημιουργία νέου Buyer (όνομα + email)
- Διαφορετικό μενού για Owner και Buyer

### ✔ Ιεραρχία Προϊόντων
- Abstract `Item`
- Υποκλάσεις: `Pen`, `Pencil`, `Notebook`, `Paper`
- Υλοποίηση `getDetails()` σε κάθε κλάση
- Μοναδικά IDs, περιγραφή, τιμή, stock

### ✔ EShop
Αποθηκεύει:
- Όλα τα προϊόντα  
- Όλους τους αγοραστές  
- Τον Owner  
- Έλεγχος για διπλότυπο ID προϊόντος  
- Έλεγχος για διπλότυπο email αγοραστή  

Παρέχει επιλογές προβολής:
- Κατηγοριών
- Προϊόντων ανά κατηγορία
- Κατάστασης Buyers

### ✔ Shopping Cart
Κάθε Buyer έχει `ShoppingCart` με δυνατότητες:

- Προσθήκη προϊόντος  
- Αφαίρεση  
- Αλλαγή ποσότητας  
- Καθαρισμός  
- Επιστροφή/δέσμευση stock  
- Υπολογισμός:
  - Καθαρής αξίας  
  - Courier  
  - Συνολικού ποσού  

Checkout:
- Επιβεβαίωση  
- Έκδοση bonus (10%)  
- Εκκαθάριση καλαθιού  

### ✔ Bonus & Κατηγορίες Buyer
- Bronze: 0–99
- Silver: 100–199
- Gold: 200+

Courier:
- Bronze → 2% (ελάχιστο €3)
- Silver → -50%
- Gold → δωρεάν

### ✔ Κλάσεις Εξαιρέσεων
Υλοποιήθηκαν:

- `OutOfStock`
- `NegativeStock`
- `WrongID`
- `DuplicateItemIDException`
- `DuplicateBuyerEmailException`

Οι εξαιρέσεις χρησιμοποιούνται αντί για μεγάλα if-else.

### ✔ Console Menu
- Καθαρός διαχωρισμός Owner/Buyer επιλογών  
- Πλοήγηση πολλαπλών επιπέδων  
- Επιλογή `Back` παντού  
- Έλεγχος λανθασμένων επιλογών  

---

## 📁 Δομή Project
```
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
```
---

## 👥 Συντελεστές

**`Giorgos Ntakos`**

**`Asimomytis Damianos`**

Το project υλοποιήθηκε πλήρως από τους δύο φοιτητές στο πλαίσιο του μαθήματος Αντικειμενοστραφούς Προγραμματισμού (CEID).
