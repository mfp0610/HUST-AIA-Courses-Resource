#include <iostream>
using namespace std;
class A
{
public:
    friend class F;
    A(int ii) :i(ii) {  }
    A() :i(5) {   }
private:
    int i;
};
class B: public A
{
public:
    B(int jj):j(jj) {   }
private:
    int j;
};
class F
{
public:
    int mem(A a) { return a.i; }
    int mem(B b) { return b.i; }//此处改为return b.j 就不可行
};
void main()
{
    A m_a(10);
    B m_b(20);
    F m_f;
    cout << m_f.mem(m_a) << endl<< m_f.mem(m_b) << endl;
}