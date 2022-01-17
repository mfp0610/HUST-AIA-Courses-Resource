#include <iostream>
using namespace std;
class A
{
public:
    A( ) {cout << "A structor is called.\n"; f( );}
virtual void f( )
{
	cout << "A::f( )is called.\n";  
}
void h( )  {  f( );   }
};

class B: public A
{
public :
    B( )    {  cout << "B structor is called.\n";  f( );}
	void f( ) {	cout << "B::f( )is called.\n"; }
    void g( )  {  f( );   }
};

class C: public B
{
public :
    C( ) { cout <<"C structor is called.\n";f( );}
    void f( )   {  cout << "C::f( )is called.\n";  }
};
void main( )
{
    C c;
    c.g( );
	c.h();
}
