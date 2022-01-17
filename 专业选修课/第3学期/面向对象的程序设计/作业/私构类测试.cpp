/**********************************************
说明：
主函数的1，2，3，4选项，任选一个去掉注释，可分别编译
测试空指针调用生成法，友元函数调用生成法，私构类的派生类
以及含有私构类成员对象的容器类的测试，大家可以在自己的
平台和环境下测试一下，vs2010测试运行是没有问题的。
***********************************************/
#include <iostream>
using namespace std;
class A{
private:
    int a;
	A(int aa):a(aa)	{	cout<<"A的一般构函被调用"<<endl; }
	A(const A& m) 
	{  
		cout<<"A的复制构函被调用"<<endl;  
		a=m.a; 
	}
public:	
	void show( )	  { 	cout<<"a="<<a<<endl;	}
	friend A* create_1(int m);
	A* create_2(int m);
	friend class C;
	friend class B;
	~A(){ cout<<"A的析构被调用"<<endl; }
};

A* create_1(int m)
{
	A* pa=new A(m);
	return pa;
}

A* A::create_2(int m)  
{
	A* pa=new A(m);
	return pa;
}

class B:public A//私构类派生
{
	int b;
public:
	B(int aa,int bb):A(aa),b(bb) {    }
	void show( )	{ 	cout<<"a="<<a<<endl<<"b="<<b<<endl;	}
};

class C     //私构类做成员对象
{
	int c;
	A m_c;
public:
	C(int aa,int cc):c(cc),m_c(aa) {      }
	void show( ) {cout<<m_c.a<<endl<<c<<endl;}
};

void main(void)
{  
///*//（1）空指针调用成员函数生成
	A* pa=NULL;
	pa=pa->create_2(2);
	pa->show();
	delete pa;
//*/
/*/////(2) 友元函数调用发
    A* pa=create_1(1);
	pa->show();
	delete pa;
*/
/*/////(3)容器类实例化对象变量
	C m(1,2);
	m.show();
*/
/*////(4)派生类实例化对象变量
	B n(3,4);
	n.show();
*/
}
