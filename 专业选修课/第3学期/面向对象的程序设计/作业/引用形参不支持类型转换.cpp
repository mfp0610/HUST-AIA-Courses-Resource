#include <iostream>
using namespace std;
class Complex {
	int r,i;
public:
	Complex( )       {r=0;i=0;}
	Complex(int t)   {r=t;i=0;}
	Complex(int t,int m):r(t),i(m){    }
//friend Complex operator + (Complex&, Complex&);//不支持 c3=c3 + 1; 
friend Complex operator + (Complex, Complex);//支持   c3=c3 + 1; 
friend ostream& operator << (ostream&,Complex&);
};
/*
Complex operator + (Complex& t1,Complex& t2)
{
	return Complex(t1.r+t2.r,t1.i+t2.i);
}
*/

Complex operator + (Complex t1,Complex t2)
{
	return Complex(t1.r+t2.r,t1.i+t2.i);
}

ostream& operator << (ostream &output,Complex &t)
{
	if(t.i>0)
		output<<t.r<<"+"<<t.i<<"i"<<endl;
	else if(t.i==0)
		output<<t.r<<endl;
	else if(t.i<0)
		output<<t.r<<t.i<<"i"<<endl;
	return output;
}
int main()
{
	Complex c1(1,1),c2(2,2),c3;
	c3=c1+c2;
	cout<<c3;
	c3=c3 + 1; //引用不能类型转化，形参改为值传递就可以
	cout<<c3;
}