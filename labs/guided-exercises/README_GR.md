# Guided Exercises — Java (1–6) & C++ (1–2)

Το repository περιέχει τις τελικές λύσεις των **Guided / Lab Exercises** του μαθήματος
**Οντοκεντρικός Προγραμματισμός** σε **Java** και **C++**.  
Στόχος των ασκήσεων είναι η σταδιακή εξάσκηση σε βασικές και ενδιάμεσες έννοιες
αντικειμενοστρεφούς προγραμματισμού, μέσα από μικρά καθοδηγούμενα παραδείγματα. 

---

## 🟦 Guided Exercises — Java

Οι Java ασκήσεις (1–6) υλοποιούνται στα αντίστοιχα αρχεία και καλύπτουν
εισαγωγικές έννοιες Java/OOP, κληρονομικότητα, συλλογές, I/O και εξαιρέσεις.

### Άσκηση 1 — Βασική δημιουργία project, είσοδος/έξοδος
Σκοπός:
- Δημιουργία νέου Java project στο BlueJ και εκτέλεση κώδικα.
- Εξάσκηση σε είσοδο δεδομένων από γραμμή εντολών και εμφάνιση αποτελεσμάτων. :contentReference[oaicite:1]{index=1}  
Αρχείο:
- `age.java`

---

### Άσκηση 2 — Κλάση `Window`, constructors, `this`
Σκοπός:
- Δημιουργία κλάσης με instance variable (`size`).
- Constructor overloading (default & με όρισμα).
- Κατανόηση της σκίασης μεταβλητών (local vs instance) και χρήσης του `this`.  
Αρχείο:
- `Window.java`  
(η άσκηση εξελίσσει σταδιακά την ίδια κλάση, μέχρι την τελική μορφή που παραδίδεται)

---

### Άσκηση 3 — Κληρονομικότητα `Window → MWindow` & χρήση `super`
Σκοπός:
- Επέκταση της `Window` σε υποκλάση `MWindow`.
- Χρήση `protected` μεταβλητών, constructor chaining με `super(...)`.
- Overriding μεθόδων, πρόσβαση σε πεδία/μεθόδους υπερκλάσης.
- Επίδειξη συμπεριφοράς με casting και διαφορετικούς τρόπους πρόσβασης στο `size`.   
Αρχεία:
- `Window.java`
- `MWindow.java`
- `RunWindow.java`

---

### Άσκηση 4 — Κλάσεις `Person` / `MarriedPerson`, overriding & Collections
Σκοπός:
- Δημιουργία βασικής κλάσης `Person` και υποκλάσης `MarriedPerson`.
- Προσθήκη νέων πεδίων (π.χ. φύλο, αριθμός παιδιών) και προσαρμογή constructors.
- Υλοποίηση `printInfo()` στην `Person` και **overriding** στην `MarriedPerson`
  με χρήση `super.printInfo()`.
- Πειραματισμός με πίνακες αντικειμένων, `ArrayList`, `Iterator`,
  και κατανόηση Generics.   
Αρχεία:
- `Person.java`
- `MarriedPerson.java`
- `MyTester.java`

---

### Άσκηση 5 — File I/O και εγγραφή σε αρχείο
Σκοπός:
- Εξοικείωση με ροές αρχείων (FileWriter / BufferedWriter).
- Εγγραφή διαφορετικών τύπων δεδομένων σε αρχείο (π.χ. `test.log`)
  και έλεγχος του περιεχομένου του αρχείου. :contentReference[oaicite:4]{index=4}  
Αρχείο:
- `IO_Tester.java`

---

### Άσκηση 6 — Εξαιρέσεις & custom exception
Σκοπός:
- Κατανόηση runtime εξαιρέσεων (π.χ. διαίρεση με μηδέν).
- Προσθήκη `try/catch` για ασφαλή εκτέλεση.
- Δημιουργία δικής μας εξαίρεσης (`DivideByZeroException`)
  και χρήση `throw` / `catch` όπου χρειάζεται. :contentReference[oaicite:5]{index=5}  
Αρχεία:
- `Exception_Tester.java`
- `DivideByZeroException.java`

---

## 🟥 Guided Exercises — C++

Στο C++ φυλλάδιο υπάρχουν 2 ασκήσεις που εισάγουν τη γλώσσα και βασικές OOP τεχνικές.

### Άσκηση 1 — Βασική σύνταξη C++, κλάσεις & operator overloading
Σκοπός:
- Δημιουργία και εκτέλεση C++ προγράμματος (Code::Blocks).
- Είσοδος/έξοδος με `cin/cout`, χρήση `for` loops.
- Εξοικείωση με κλάσεις μέσω της `Kouti`:
  setters για διαστάσεις, υπολογισμός όγκου.
- Υπερφόρτωση τελεστή `+` για άθροιση διαστάσεων δύο αντικειμένων.   
Αρχείο:
- `askisi1.cpp`

---

### Άσκηση 2 — Κληρονομικότητα σχημάτων & πολυμορφισμός
Σκοπός:
- Δημιουργία υπερκλάσης `Polygon` και υποκλάσεων (π.χ. `Rectangle`, `Triangle`)
  με κοινό interface υπολογισμού εμβαδού.
- Χρήση `virtual` μεθόδου `area()` για **late binding / δυναμική διασύνδεση**.
- Κλήση μεθόδων μέσω pointer σε υπερκλάση ώστε να φανεί η πολυμορφική συμπεριφορά.   
Αρχείο:
- `askisi2.cpp`

---

## Μαθησιακοί στόχοι (Guided Exercises)

Με την ολοκλήρωση όλων των ασκήσεων, ο φοιτητής εξασκείται σε:

- βασική σύνταξη Java & C++,
- σχεδίαση/υλοποίηση κλάσεων,
- constructors & overloading,
- κληρονομικότητα και overriding,
- this / super (Java),
- virtual και dynamic dispatch (C++),
- συλλογές και iterators (Java),
- βασικό File I/O (Java),
- exception handling και custom exceptions.
