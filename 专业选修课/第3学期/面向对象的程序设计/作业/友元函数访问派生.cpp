#include <iostream> 
#include <math.h>
using namespace std;
class Circle;
class Point 
{
  int x ,y;
public :
  Point(int xi, int  yi)
  { x = xi;  y = yi; }
  void show()
  {
	cout<<"the x,y of point"<<x<<y<<endl;
  }
  friend double Distance(Circle&, Circle&);//派生类的形参，父类友元声明
};
class Circle : public Point 
{
  int  radius;
public :
  Circle(int x1, int y1, int r): Point(x1, y1)
  { 
	radius = r;
  }
  void show()
  {
	cout<<"the radius of circle"<<radius<<endl;
  }
}; 
double Distance(Circle &a, Circle &b)
{  
   double dx = a.x - b.x;				//父类继承下来的可以访问
   double dy = a.y - b.y;
//   double dr = a.radius - b.radius;   		//派生类的新增成员不能访问
   return sqrt(dx * dx + dy * dy);
//   return sqrt(dx*dx + dy*dy + dr*dr);
} 
void main( )
{ 
  Circle k(0,0,1) , r(1,1,2);     
  double dc = Distance(k , r);
  cout<<dc<<endl;
} 