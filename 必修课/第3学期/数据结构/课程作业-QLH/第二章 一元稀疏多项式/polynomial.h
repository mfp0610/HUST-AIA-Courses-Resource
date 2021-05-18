#ifndef _POLYNOMIAL_H
#define _POLYNOMIAL_H

#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2

#include"database.h"

void InitList(LinkList &L);

int cmp(Term a,Term b);

void insertNode(LinkList &L,Term e);

void CreatPolyn(LinkList &L,int m);

void addPolyn(LinkList &L,LinkList L1,LinkList L2);

void SubtracatPolyn(LinkList &L,LinkList L1,LinkList L2);

void multiplyPolyn(LinkList &L,LinkList L1,LinkList L2);

void visitList(LinkList L);


#endif
