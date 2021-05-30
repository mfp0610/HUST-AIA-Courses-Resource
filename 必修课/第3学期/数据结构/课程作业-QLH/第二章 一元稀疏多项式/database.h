#ifndef _DATABASE_H
#define _DATABASE_H

//每个项都用一个结构体表示
typedef struct
{
	float coef;//系数，注意要用float
	int expn;//指数
} Term;

//用链表来表示多项式
typedef struct polynomial
{
	Term term;
	polynomial* next;
} polynomial,*LinkList;

#endif