/*
内联函数首先是函数，有参数校验，类型转换，数据赋值，没有程序指针跳转
对于表达式参数，内联函数是运算后付给参数，宏只是简单替换，所以对于一些++运算符，变量的计算次数会不一样。
简单参数替换，会导致表达式替换的时候运算顺序变化，所以会给宏参数加上括号
内联函数有返回值，宏命令没有
一个是编译之前预处理，一个是编译的时候的替换处理
*/
#include <iostream>
using namespace std;
#define Add(a,b) a+b

inline float add(float a ,float b)
{
	return a+b;
}

void main()
{
	float m=3.5;
	float n=4.2;
	cout<<Add(m++,n)<<endl;
	cout<<add(m++,n)<<endl;
}