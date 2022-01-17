#include <iostream>
using namespace std;
class A{
public:
  virtual void Print(int a, int b)
  { cout << "a = " << a << " , b = " 
          << b << endl; }
};
class B : public A {
public:
  virtual void Print(int a, double d)
  { cout << "a = " << a << " , d = " 
          << d << endl; }
};
void Show(A * p)
{
	p -> Print(3.3, 5.8);    
} 

void main( )
{
    A * pa = new A;
    B * pb = new B;
    B m_b;
    m_b.A::Print(3.3,5.5);//call A::Print()
    m_b.Print(3.3, 5.5);//Call B::Print( )
    Show(pa);        //Call A::Print( )
    Show(pb);        //Call A::Print( )
    delete pa;
    delete pb;
}
