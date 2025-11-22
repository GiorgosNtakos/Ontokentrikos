# Οντοκεντρικός Προγραμματισμός — Sets 1–3 (Java & C++)

## Περιγραφή
Το repository περιλαμβάνει τις τελικές λύσεις για **τρία σετ εργαστηριακών ασκήσεων** του μαθήματος *Οντοκεντρικός Προγραμματισμός* (Ακαδ. Έτος 2019–2020).  
Καλύπτονται έννοιες αντικειμενοστρεφούς σχεδίασης και προγραμματισμού σε **Java (Set 1–2)** και **C++ (Set 3)**.  
Οι κώδικες που παρατίθενται είναι οι **τελικές εκδόσεις** κάθε set (δηλ. έχουν προσαρμοστεί/ενοποιηθεί σύμφωνα με τα επόμενα ερωτήματα των εκφωνήσεων). 

---

## Περιεχόμενα / Sets

### Set 1 — Java: Βασική Σύνταξη, Κλάσεις & Κληρονομικότητα
Το Set 1 εστιάζει σε θεμελιώδεις έννοιες Java και OOP. 

**Κύρια σημεία:**
- Ερωτήσεις πολλαπλών επιλογών για σύνταξη, τύπους, πίνακες και τελεστές.
- Υλοποίηση κλάσης `Kouti` (ορθογώνιο παραλληλεπίπεδο) με:
  - μεταβλητές διαστάσεων,
  - υπερφόρτωση constructors,
  - μεθόδους υπολογισμού όγκου/επιφάνειας,
  - override της `toString()`.
- Υποκλάση `Kyvos` που εξειδικεύει το `Kouti` σε κύβο με override μεθόδων.
- Υποκλάση `Spirtokouto` που προσθέτει επιπλέον ιδιότητα (βάρος).
- `RunMe` ως driver για δημιουργία αντικειμένων, έλεγχο εγκυρότητας και εκτυπώσεις.

**Έννοιες που εξασκούνται:**
constructors, overloading, inheritance, overriding, `super`, polymorphism, basic exceptions.

---

### Set 2 — Java: Αφηρημένες Κλάσεις, Πολυμορφισμός, Συλλογές, Εξαιρέσεις & Αρχεία
Το Set 2 επεκτείνει τις OOP έννοιες σε πιο “ρεαλιστικά” σενάρια. 

**Άσκηση 1 — Ιεραρχία Εργαζομένων & Εταιρεία**
- Abstract υπερκλάση `Worker` με στοιχεία εργαζομένου και **αυτόματη μοναδική ανάθεση κωδικού `wCode`** κατά τη δημιουργία.
- Υποκλάσεις:
  - `PermanentWorker` (μισθωτός) → πληρωμή = salary.
  - `NonPermanentWorker` (ωρομίσθιος) → πληρωμή = hoursWorked × hourlyPayment.
- `Company` που διατηρεί `ArrayList<Worker>` και προσθέτει εργαζομένους μέσω `addWorker()`.
- `Main` που κατασκευάζει αντικείμενα, τα αποθηκεύει και τυπώνει πληρωμές με πολυμορφισμό.

**Άσκηση 2 — Ασφαλής Είσοδος & Handling Εξαιρέσεων**
- Ανάγνωση τιμών από stdin με `try/catch`.
- Χειρισμός `NumberFormatException` και `ArithmeticException` ώστε η εκτέλεση να παραμένει σταθερή.

**Άσκηση 3 — Διαχείριση Αρχείων**
- Ανάγνωση από `input.txt`, επεξεργασία κειμένου (μετρήσεις/αντικαταστάσεις) και εγγραφή σε `output.txt`.
- Επίδειξη ροών I/O και κατάλληλου exception handling.

**Έννοιες που εξασκούνται:**
abstract classes, late binding, collections (`ArrayList`, iterators, enhanced for), method overriding/overloading, file I/O, checked/unchecked exceptions.

---

### Set 3 — C++: Ιεραρχίες, Polymorphism, Operators, STL
Το Set 3 μεταφέρει τις OOP έννοιες σε C++ με έμφαση στη δυναμική διασύνδεση και STL. 

**Άσκηση 1 — Ιεραρχία Animal**
- Υπερκλάση `Animal` με private μέλη `legs`, `sound` και protected constructor για αρχικοποίηση.
- Υποκλάσεις `Dog`, `Bird`, `Fish` που αρχικοποιούν τις κληρονομούμενες ιδιότητες μέσω constructor chaining.
- `virtual getClass()` για επίδειξη **late binding**.
- Χρήση `Animal*` δεικτών σε **vector<Animal*>** και κλήση `printInfo()` για πολυμορφική συμπεριφορά. :contentReference[oaicite:5]{index=5}

**Άσκηση 2 — Vehicle, friend & operator overloading**
- Κλάση `Vehicle` που μοντελοποιεί όχημα με στοιχεία διαδρομής.
- `friend show(Vehicle)` για εκτύπωση δεδομένων.
- Υπερφόρτωση τελεστή `>` ώστε να συγκρίνει ταχύτητα οχημάτων, ισοδύναμα με `isFasterThan()`. :contentReference[oaicite:6]{index=6}

**Έννοιες που εξασκούνται:**
constructors & access specifiers, virtual methods, pointers to base class, dynamic dispatch, STL `vector`, friend functions, operator overloading.
