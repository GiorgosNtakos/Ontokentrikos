#include <iostream>
using namespace std;
class Kouti
{
 private:
 double length;
 double breadth;
 double height;

 public:
 		Kouti operator+(const Kouti& b)
 {
 Kouti kouti;
 kouti.length = this->length + b.length;
 kouti.breadth = this->breadth + b.breadth;
 kouti.height = this->height + b.height;
 return kouti;
 }

 void	setMikos(double m)
 	{
 		length=m;
	 }
 void	 setIpsos(double y)
	 {
	 	height=y;
	 }
 void	 setPlatos(double p)
	 {
	 	breadth=p;
	 }
 	double calculateOgkos()
	 {
	 	return length*height*breadth;
	  }
};

main()
{
	Kouti KoutiA;
	Kouti KoutiB;
	Kouti KoutiC;

	KoutiA.setMikos(2.0);
	KoutiA.setPlatos(3.2);
	KoutiA.setIpsos(6.0);

	KoutiB.setMikos(2.5);
	KoutiB.setPlatos(4.0);
	KoutiB.setIpsos(5.0);

    cout<<"O ogkos toy  antikeimenoy Kouti A einai: "<<KoutiA.calculateOgkos()<<endl;
    cout<<"O ogkos toy  antikeimenoy Kouti B einai: "<<KoutiB.calculateOgkos()<<endl;

    KoutiC=KoutiA+KoutiB;
    cout<<"O ogkos toy  antikeimenoy Kouti C einai: "<<KoutiC.calculateOgkos()<<endl;
}
