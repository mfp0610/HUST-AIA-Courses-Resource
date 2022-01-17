#include <iostream>
using namespace std;
class Counter
{
	int count;
public:
	static int num;
	Counter():count(0)   {  };//构函不能是虚函数
	void increment()
	{
		cout<<++count<<endl;
	}
	static void Getnum()//静态成员函数不能虚函数
	{
		cout<<num<<endl;
	}
virtual	void show()//虚函数后不能空指针调用
	{
		cout<<"I am a couter!"<<endl;
	}
	void Readnum()
	{
		cout<<num<<endl;
	}
};
int Counter::num=10; 
void main()
{
	Counter* m=NULL;
	m->show();
}