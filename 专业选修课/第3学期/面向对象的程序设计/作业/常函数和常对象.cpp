/*
常对象只能调用常成员函数
常成员函数只能调用常成员函数
普通对象和普通成员函数可以调用常函数
*/
#include <iostream>
using namespace std;
class Test
{
public:
	int a;

	void Show() const
	{
		cout << "Hello,Const!" << endl;
		print();
	}
	void Show()
	{
		cout << "Hello!" << endl;
		print();
	}
	void print() const 
	{

	}
};
int main()
{
	Test t1;
	t1.Show();
	Test  t2;
	t2.Show();
	return 0;
}