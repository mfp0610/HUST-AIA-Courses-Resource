/*****************
问题描述：设计一个一元稀疏多项式简单计算器
基本要求：输入并建立多项式；
		  按顺序输出多项式；
		  多项式相加、相减、相乘
数据结构：用普通结构体表示项的系数和指数，用链表表示多项式
******************/

#include<stdio.h>
#include<stdlib.h>
#include"polynomial.h"
#include"database.h"

int main()
{
	LinkList L1,L2;
	int n1,n2;
	
	printf("请输入多项式L1的项数：");
	scanf("%d",&n1);
	CreatPolyn(L1,n1);
	printf("请输入多项式L2的项数：");
	scanf("%d",&n2);
	CreatPolyn(L2,n2);
	
	printf("\n多项式L1:  ");
	visitList(L1);
	printf("\n多项式L2:  ");
	visitList(L2);
	
	LinkList add,sub,multiply;
	InitList(add);
	InitList(sub);
	InitList(multiply);
	
	addPolyn(add,L1,L2);
	SubtracatPolyn(sub,L1,L2);
	multiplyPolyn(multiply,L1,L2);
	
	printf("\nL1 + L2:   ");
	visitList(add);
	printf("\nL1 - L2:   ");
	visitList(sub);
	printf("\nL1 * L2:   ");
	visitList(multiply);
}


void InitList(LinkList &L)
{
	//初始化链表
	L= (polynomial*)malloc(sizeof(polynomial));//头结点
	L->term.coef=0.0;
	L->term.expn=-1;
	L->next=NULL;
}

int cmp(Term a,Term b)
{
	//比较结点的系数大小函数
	if(a.expn>b.expn) return -1;
	else if(a.expn==b.expn) return 0;
	else return 1;
}

void insertNode(LinkList &L,Term e)//按照降幂顺序进行项的插入
{
	//将结点插入多项式链表的适当位置，可以同时起到创建链表和多项式相加的功能
	
	polynomial* q=L;//链表指针q用于跑来跑去，进行定位
	
	while(q->next!=NULL)//当q不是尾结点时
	{
		if(cmp(q->next->term,e)<0)//如果当前结点q的下一个结点的指数 大于 要插入的结点的指数
			q=q->next;//q指向下一个结点
		else break;//此时， q.term.expn>e.expn >=q->next->term.expn
	}
	//上述几行代码用于确定q的位置
	
	if(q->next!=NULL && cmp(q->next->term,e)==0)   //指数相同，系数相加
	{
		q->next->term.coef+=e.coef;
	}
	else
	{
		polynomial* node =(polynomial*) malloc(sizeof(polynomial));//申请一个新结点
		node->term.coef=e.coef;
		node->term.expn=e.expn;
		//下面5行代码就是经典的链表结点插入操作
		if(q->next==NULL)
			node->next=NULL; //如果q结点为尾结点，则node的指针域设为NULL
		else
			node->next=q->next; //否则node的指针域指向q的下一个结点
		q->next=node;//将node结点插入链表中
	}
}

void CreatPolyn(LinkList &L,int m)
{
	//输入m项的系数和指数，建立表示一元多项式的有序链表L
	Term e;
	InitList(L);
	for(int i=1; i<=m; i++)
	{
		printf("\n第%d项的系数和指数（空格隔开，回车确认）：",i);
		scanf("%f%d",&e.coef,&e.expn);
		insertNode(L,e);
	}
}

void addPolyn(LinkList &L,LinkList L1,LinkList L2)
{
	//用L返回L1+L2的结果
	polynomial* q;
	for(q=L1->next; q!=NULL; q=q->next)
	{
		insertNode(L,q->term);//将L1的每一项插入到L中
	}
	for(q=L2->next; q!=NULL; q=q->next)   //将L2的每一项插入到L中
	{
		insertNode(L,q->term);
	}
}

void SubtracatPolyn(LinkList &L,LinkList L1,LinkList L2)
{
	//用L返回L1-L2的结果
	polynomial* q;
	for(q=L1->next; q!=NULL; q=q->next)
	{
		insertNode(L,q->term);//将L1的每一项插入到L中
	}
	for(q=L2->next; q!=NULL; q=q->next)
	{
		q->term.coef = -(q->term.coef); //把系数变成相反数,再进行相加操作，即为L1-L2
		insertNode(L,q->term);//将L2的每一项插入到L中
	}
}

void multiplyPolyn(LinkList &L,LinkList L1,LinkList L2)
{
	//用L返回L1*L2的结果
	polynomial *p,*q;
	Term term;//一个起temp作用的项
	term.coef=0.0;
	term.expn=0;
	for(q=L1->next; q!=NULL; q=q->next)
	{
		for(p=L2->next; p!=NULL; p=p->next)
		{
			term.coef=(q->term.coef)*(p->term.coef);//系数相乘
			term.expn=(q->term.expn)+(p->term.expn);// 指数相加
			insertNode(L,term);
		}
	}
}

void visitList(LinkList L)
{
	//以类数学表达式的形式打印输出一元多项式L，
	//即指数或者系数为1的情况下 省略1
	polynomial* q=L;
	int flag;//用flag记录指数为0和系数为1的特殊情况，正常情况下flag为1
	while(q->next!=NULL)
	{
		q=q->next;
		flag=1;
		if(q->term.coef==0) continue;//系数为0 不输出
		if(q->term.expn==0&&flag==1)   //指数为0
		{
			if(q->term.coef>0)
				printf("+%.2f",q->term.coef);
			else
				printf("%.2f",q->term.coef);
			flag=0;
		}
		if((q->term.coef==1||q->term.coef==-1)&&flag==1)   //系数为1
		{
			if(q->term.expn==1)
			{
				if(q->term.coef==1)
					printf("+X");
				else
					printf("-X");
			}
			else
			{
				if(q->term.coef==1)
					printf("+X^%d",q->term.expn);
				else
					printf("-X^%d",q->term.expn);
			}
			flag=0;
		}
		if(flag==1)
		{
			if(q->term.coef>0)
				printf("+%.2fX^%d",q->term.coef,q->term.expn);
			else
				printf("%.2fX^%d",q->term.coef,q->term.expn);
		}

	}
	printf("\n");
}
