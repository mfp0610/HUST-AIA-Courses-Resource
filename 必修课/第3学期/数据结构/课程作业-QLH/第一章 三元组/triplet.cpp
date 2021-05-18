#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"triplet.h"

#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2

typedef int elemtype;//数据元素种类不一定要是int，可在此处直接修改
typedef elemtype* triplet;//triplet定义为一个指针即可，具体几元由malloc决定

int main(void)
{
	triplet T;
	init_triplet(T, 3, 4, 2);
	int num1, num2, num3; //用来存放抽象数据类型数据元素
	get(T, 1, num1);
	get(T, 2, num2);
	get(T, 3, num3);
	print_triplet(T);//打印三元组
	put(T, 2, 1);
	print_triplet(T); 
	if (is_ascending(T))
		printf("抽象数据类型triplet由小到大排列！\n");
	else if (is_descending(T))
		printf("抽象数据类型triplet由大到小排列！\n");
	else
		printf("排列大小无规则\n");
	int big, small;//记录最大值与最小值
	max(T, big);
	min(T, small);
	printf("最大值为：%d，最小值为：%d\n", big, small);
	printf("敲击任意键对三元组进行销毁\n"); 
	getchar();
	destory_triplet(T);
	return 0;
}

int init_triplet(triplet &T,elemtype v1,elemtype v2,elemtype v3)
{
	T = (elemtype*)malloc(3*sizeof(elemtype));
	if(T == NULL)
	{
		printf("no enough memory");
		exit(OVERFLOW);
	}
	T[0] = v1;
	T[1] = v2;
	T[2] = v3;
	return OK;
}

int destory_triplet(triplet &T)
{
	free(T);
	T = NULL;
	printf("三元组销毁成功"); 
	return OK;
}

int get(triplet T,int i,elemtype e)
{
	if(i<1 || i>3)
	{
		return ERROR;
	}
	e = T[i-1];
	return OK;
}

int put(triplet &T,int i,elemtype e)
{
	if(i<1 || i>3)
	{
		return ERROR;
	}
	T[i-1] = e;
	return OK;
}

int is_ascending(triplet T)
{
	return (T[0]<=T[1])&&(T[1]<=T[2]);//逻辑符&&的妙用，好！
}

int is_descending(triplet T)
{
	return (T[0]>=T[1])&&(T[1]>=T[2]);
}

int max(triplet T,elemtype &e)
{
	e = (T[0] > T[1] ? T[0] : T[1]) > (T[1] > T[2] ? T[1] : T[2]) ? (T[0] > T[1] ? T[0] : T[1]) : (T[1] > T[2] ? T[1] : T[2]);
	return OK;
}

int min(triplet T,elemtype &e)
{
	e = (T[0] < T[1] ? T[0] : T[1]) < (T[1] > T[2] ? T[1] : T[2]) ? (T[0] < T[1] ? T[0] : T[1]) : (T[1] < T[2] ? T[1] : T[2]);
	return OK;
}

int print_triplet(triplet T)
{
	int i = 0;
	printf("抽象数据类型triplet：");
	for (i = 0; i < 3; i++)
		printf("%d ", T[i]);
	printf("\n");
	return OK;
}
