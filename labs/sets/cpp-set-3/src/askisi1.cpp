include <iostream>
#include <string>
#include <vector>

using namespace std;
class Animal //οριζουμε την κλαση animal
{
	private://τα ορισματα αυτα ειναι προσπελασιμα μονο απο την κλαση Animal
		int legs;
		string sound;
		protected://ο κατασκευαστης που βρισκεται στο πεδιο protected ειναι προσπελασιμο μονο απο την Animal και τις υποκλασεις της 
			Animal(int l, string s)//ο κατασκευαστης της κλασης
			{
				legs=l;//η legs παιρνει την τιμη που θα δωσουμε στο οριμσα l σε μια αρχικοποιησει ενος αντικειμενου
				sound=s;//η sound παιρνει την τιμη που θα δωσουμε στο οριμσα s σε μια αρχικοποιησει ενος αντικειμενου
			}
		
		public://αυτο το πεδιο ειναι προσπελασιμο απο οποιαδηποτε μεθοδο και κλαση
			Animal()//ενας κατασκευαστης τον οποιο μπορουμε να καλεσουμε σε οποιαδηποτε κλαση η μεθοδο χωρις ορισματα βεβαια
			{
			}
			
			virtual string getClass()//εικονικη string μεθοδος που μας επιστρεφει την κλαση του αντικειμενου.Ετσι επιτυγχανουμε μηχανισμο late binding
			{
				return "Animal";
			}
			
			 void printInfo()//Μεθοδο που μου τυπωνει το νουμερο των ποδιων και τον ηχο του καθε αντικειμενου
			{
				cout <<"This is a "<<getClass()<<". It has "<<legs<<" legs and sound: "<<sound<<"\n";
 			}

			int getLegs()//επιστρεφει τον αριθμο ποδιων
			{
				return legs;
			}
			string getSound()//επιστρεφει τον ηχο καθε ζωου
			{
				return sound;
			}
};
//κλαση Bird που ειναι υποκλαση της Animal
class Bird:public Animal{
	public:
		//Ο κατασκευαστης της Bird καλει τον κατασκευαστη της animal ωστε να δωσει τα καταλληλα ορισματα
		Bird(): Animal(2, "chirp")
		{
		}
		
		string getClass()//επιστρεφει την κλαση του ζωου
		{
			return "Bird";
		}
};
//κλαση Dog που ειναι υποκλαση της Animal
class Dog:public Animal{
	public:
		//Ο κατασκευαστης της Dog καλει τον κατασκευαστη της Animal ωστε να δωσει τα καταλληλα ορισματα
		Dog(): Animal(4, "bark")
		{
		}
		
		string getClass()//επιστρεφει την κλαση του ζωου
		{
			return "Dog";
		}
};
//κλαση Fish που ειναι υποκλαση της Animal
class Fish:public Animal{
	public:
		//Ο κατασκευαστης της Fish καλει τον κατασκευαστη της Animal ωστε να δωσει τα καταλληλα ορισματα
		Fish(): Animal(0, "blop")
		{
		}
		
		string getClass()//επιστρεφει την κλαση του ζωου
		{
			return "Fish";
		}
};

main()
{
	int i;
 Animal *a1 = new Animal;//δημιουργουμε εναν δεικτη τυπου Animal στον οποιο αναθετουμε ενα αντικειμενο τυπου Animal
 Animal *a2 = new Dog;//δημιουργουμε εναν δεικτη τυπου Animal στον οποιο αναθετουμε ενα αντικειμενο τυπου Dog
 Animal *a3 = new Bird;//δημιουργουμε εναν δεικτη τυπου Animal στον οποιο αναθετουμε ενα αντικειμενο τυπου Bird
 Animal *a4 = new Fish;//δημιουργουμε εναν δεικτη τυπου Animal στον οποιο αναθετουμε ενα αντικειμενο τυπου Fish
 
 vector <Animal*> vec;//δημιουργουμε ενα διανυσμα τυπου Animal που θα περιεχει του δεικτες τυπου Animal
 vec.push_back(a1);//εισερχεται το 1ο στοιχειο μεσα στο διανυσμα
 vec.push_back(a2);//εισερχεται το 2ο στοιχειο μεσα στο διανυσμα
 vec.push_back(a3);//εισερχεται το 3ο στοιχειο μεσα στο διανυσμα
 vec.push_back(a4);//εισερχεται το 4ο στοιχειο μεσα στο διανυσμα
 
 //Με μια for Διατρεχουμε το διανυσμα vec ωστε να προσπελασουμε τα στοιχεια του
 for(i=0; i<vec.size(); i++)
 vec[i]->printInfo();//για καθε στοιχειο που παιρνουμε του λεμε να καλεσει την printfInfo()
 
return 0;
}
