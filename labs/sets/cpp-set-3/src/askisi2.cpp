#include <iostream>
#include <string>
using namespace std;
//Για περισσοτερα σχολια στα πεδια που δεν αναφερονται ανατρεξτε τον αμεσως πιο πανω κωδικα
class Vehicle{
	private:
		string model;
		int  km;
	    double  hours;
	    
	    
	public:
		
		bool operator > (const Vehicle& b)//Υπερφορτωνουμε τον τελεστη > για να μπορουμε να τον χρησιμοποιησουμε να συγκρινουμε 2 αντικειμενα.Δηλαδη θα κανει την δουλεια της isFasterThan.Την εχουμε δηλωσει ως Boolean γιατι μας επιστρεφει Boolean τιμες
	{
 		if(this->km/this->hours > b.km/b.hours  )//βαζουμε βελος με this για να παιρνουμε τις τορινες τιμες του κάθε αντικειμενου
 		{
 			return true;
		 }
		 else
		 {
		 	return false;
		 }
  	}

		void input()
		{
			string remainder;
			cout << "Please enter model and plate: ";
 			getline(cin, model);
		    cout << "Please enter distance in km: ";
 			cin >> km;
 			cout << "Please enter time spent in hours: ";
 			cin >> hours;
 			getline(cin, remainder);
		}
	  friend void show(Vehicle a);//Με αυτό τον τροπο καταφερνουμε να καλουμε την show με ειδικο τροπο αλλα και να την γραψουμε ως μια global μεθοδο
};

void show(Vehicle a)//Εδώ φτιαχνουμε το σωμα της show
{
	 cout<<a.model<< " (speed: " << a.km/a.hours << "km/h )\n";
}




int main()
{
 Vehicle v1;
 v1.input();
 bool more = true;
 while (more)
 {
 Vehicle v2;
 v2.input();
 if(v2>v1) v1 = v2;//Συγκρινουμε τα δυο αντικειμενα και αν το v2 είναι πιο γρηγορο από το v1 τοτε το v1 παιρνει τις τιμες του v2
 cout << "More data? (y/n) ";
 string answer;
 getline(cin, answer);
 if (answer != "y") more = false;
 }
 cout << "The fastest vehicle is: ";
 show(v1);//Εδώ βλεπουμε ότι καλουμε την μεθοδο show με έναν διαφορετικο τροπο.
 return 0;
}
