#include <iostream>
using namespace std;

class A{
        int a;
		const int b;	
		static int c;
		static const  int d=10;
		int &e; 
		int f[d];
public:
    A(int aa,int bb,int &ee):a(aa),b(bb),e(ee)
	{
		memset(f,0,4*d);
	}
	void plus()	  {	e++;	}
	void show()
	{
		cout<<"a="<<a<<endl;
		cout<<"b="<<b<<endl;
		cout<<"c="<<c<<endl;
		cout<<"d="<<d<<endl;		
		cout<<"e="<<e<<endl;
	    cout<<"f[3]="<<f[3]<<endl;
	}
};
int A::c=3;
void main(void)
{        
		int ee=111;
		A m_a(1,2,ee);
		m_a.show();
		ee++;
		m_a.show();
		m_a.plus();
		m_a.show();
		cout<<"ee="<<ee<<endl;
		cout<<sizeof(A)<<endl<<sizeof(m_a)<<endl;
}
