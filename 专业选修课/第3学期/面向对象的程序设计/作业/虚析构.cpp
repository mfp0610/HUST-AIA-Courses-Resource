#include<iostream>
using namespace std;
class AA
{
	int   a;
	public :
	AA( ) {cout<<"Initualizing  AA!\n";}
	~AA( )  {cout<<"Destroying  AA!\n";}
//	virtual ~AA( )  {cout<<"Destroying  AA!\n";}
};

class BB:public AA
{
	int  b;
public :
	BB( )   {cout<<"Initualizing  BB!\n";}
	~BB( )  {cout<<"Destroying  BB!\n";}
};

void main( )
{
//	BB  X;
	AA* pa=new BB;
	delete pa;
	cout<<"Ending main!\n";
}
