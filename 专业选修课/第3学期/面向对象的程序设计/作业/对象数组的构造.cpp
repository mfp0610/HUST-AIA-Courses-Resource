#include <iostream>
using namespace std;           
#include <string.h>
class B {
  char name[10];
  double b;
public :
  static int count;
  B(char * s, double n)  {  
	  strcpy(name, s);   
	  b = n;
	  cout << "调用一般构造函数, count : " << ++count << endl; 
  }
  B( ) {  
	  cout << "调用无参数构造函数,count: " << ++count << endl; 
  }
  ~B( ) {  cout << "调用析构函数撤消对象 " << name << "后, count : " << --count << endl;}
 void Getb(char * s, double & n)
 {  strcpy(s, name);  n = b; }
};
int B::count = 0;
void main( )
{
	B * p;     
	double d;   
	char str[30];
    p = new B[3];
	cout << "初始化对象数组p[ ] !\n";  
    p[0] = B("ma", 4.8);   
    p[1] = B("wang", 3.6); 
    p[2] = B("li", 3.1);
    for(int i = 0; i < 3; i++) {
	  p[i].Getb(str, d);
	  cout << str << " , " << d << endl;  
	}
   delete[]  p;
}
