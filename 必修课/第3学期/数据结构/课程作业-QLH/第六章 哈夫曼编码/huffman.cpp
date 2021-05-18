/*****************
问题描述：设计huffman的编码器和解码器
基本要求：输入字符和权重，生成huffman树并进行编码解码操作
数据结构：编码和结点都用普通结构体来存储，结点会根据其权重生成一棵哈夫曼树
******************/
#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include"database.h"
#include"huffman.h"

//设置相关参数的边界
#define MAXBIT      100
#define MAXVALUE  10000
#define MAXLEAF     30 //叶子结点数=编码个数
#define MAXNODE    MAXLEAF*2 -1


int main(void)
{

	HNodeType HuffNode[MAXNODE];            /* 定义一个结点结构体数组 */
	HCodeType HuffCode[MAXLEAF],  cd;       /* 定义一个编码结构体数组， 同时定义一个临时变量来存放求解编码时的信息 */
	int i, j, c, p, n;
	char pp[100];
	printf ("输入编码的个数:\n");
	scanf ("%d", &n);
	HuffmanTree (HuffNode, n);


	for (i=0; i < n; i++)
	{
		cd.start = n-1;
		c = i;
		p = HuffNode[c].parent;
		while (p != -1)   /* 父结点存在 */
		{
			if (HuffNode[p].lchild == c)
				cd.bit[cd.start] = 0;
			else
				cd.bit[cd.start] = 1;
			cd.start--;        /* 求编码的低一位 */
			c=p;
			p=HuffNode[c].parent;    /* 设置下一循环条件 */
		} 

		/* 保存求出的每个叶结点的哈夫曼编码和编码的起始位 */
		for (j=cd.start+1; j<n; j++)
		{
			HuffCode[i].bit[j] = cd.bit[j];
		}
		HuffCode[i].start = cd.start;
	}

	/* 输出已保存好的所有存在编码的哈夫曼编码 */
	for (i=0; i<n; i++)
	{
		printf ("%c的huffman编码是: ", i+65);
		for (j=HuffCode[i].start+1; j < n; j++)
		{
			printf ("%d", HuffCode[i].bit[j]);
		}
		printf(" start:%d",HuffCode[i].start);

		printf ("\n");

	}

	printf("输入你想要的解码信息:\n");
	scanf("%s",&pp);
	decodeing(pp,HuffNode,n);
	getchar();
	return 0;
}

/* 构造一颗哈夫曼树 */
void HuffmanTree (HNodeType HuffNode[MAXNODE],int n)
{
	/*m1、m2：构造哈夫曼树不同过程中两个最小权值结点的权值，
	  x1、x2：构造哈夫曼树不同过程中两个最小权值结点在数组中的序号。*/
	int i, j, m1, m2, x1, x2;
	/* 初始化存放哈夫曼树数组 HuffNode[] 中的结点 */
	for (i=0; i<2*n-1; i++)
	{
		HuffNode[i].weight = 0;//权值
		HuffNode[i].parent =-1;
		HuffNode[i].lchild =-1;
		HuffNode[i].rchild =-1;
		HuffNode[i].value=i; //实际值，可根据情况替换为字母
	} 

	/* 输入 n 个叶子结点的权值 */
	for (i=0; i<n; i++)
	{
		printf ("请输入各个编码的权重(输入完一个按回车确认一次) \n%c: ", i+65);
		scanf ("%d", &HuffNode[i].weight);
	}

	/* 循环构造 Huffman 树 */
	for (i=0; i<n-1; i++)
	{
		m1=m2=MAXVALUE;     /* m1、m2中存放两个无父结点且结点权值最小的两个结点 */
		x1=x2=0;
		/* 找出所有结点中权值最小、无父结点的两个结点，并合并之为一颗二叉树 */
		for (j=0; j<n+i; j++)
		{
			if (HuffNode[j].weight < m1 && HuffNode[j].parent==-1)
			{
				m2=m1;
				x2=x1;
				m1=HuffNode[j].weight;
				x1=j;
			}
			else if (HuffNode[j].weight < m2 && HuffNode[j].parent==-1)
			{
				m2=HuffNode[j].weight;
				x2=j;
			}
		}
		/* 设置找到的两个子结点 x1、x2 的父结点信息 */
		HuffNode[x1].parent  = n+i;
		HuffNode[x2].parent  = n+i;
		HuffNode[n+i].weight = HuffNode[x1].weight + HuffNode[x2].weight;
		HuffNode[n+i].lchild = x1;
		HuffNode[n+i].rchild = x2;

		printf ("x1.weight and x2.weight in round %d: %d, %d\n", i+1, HuffNode[x1].weight, HuffNode[x2].weight);  /* 用于测试 */
		printf ("\n");
	}
} 

//解码
void decodeing(char string[],HNodeType Buf[],int Num)
{
	int i,tmp=0,code[1024];
	int m=2*Num-1;
	char *nump;
	char num[1024];
	for(i=0; i<strlen(string); i++)
	{
		if(string[i]=='0')
			num[i]=0;
		else
			num[i]=1;
	}
	i=0;
	nump=&num[0];

	while(nump<(&num[strlen(string)]))
	{
		tmp=m-1;
		while((Buf[tmp].lchild!=-1)&&(Buf[tmp].rchild!=-1))
		{

			if(*nump==0)
			{
				tmp=Buf[tmp].lchild ;
			}
			else tmp=Buf[tmp].rchild;
			nump++;

		}

		printf("%c",Buf[tmp].value + 65);
	}
}
