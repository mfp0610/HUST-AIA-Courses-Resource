/*****************
问题描述：设计一个迷宫求解路径程序
基本要求：给出迷宫入口和终点，输出路径
		  走不通时报错；
		  不要求最短路径
数据结构：普通结构体表示迷宫中的每个小方格，用顺序栈来储存路径
******************/

#include <stdio.h>
#include<stdlib.h>
#include"database.h"
#include"maze.h"

#define M 8//行数
#define N 8//列数

int mg[10][10]= {
	{1,1,1,1,1,1,1,1,1,1},
	{1,0,0,1,0,0,0,1,0,1},
	{1,0,0,1,0,0,0,1,0,1},
	{1,0,0,0,0,1,1,0,0,1},
	{1,0,1,1,0,0,0,0,1,1},
	{1,1,0,1,1,0,0,1,0,1},
	{1,0,1,0,0,0,1,0,0,1},
	{1,0,1,0,1,0,1,1,0,1},
	{1,1,0,1,0,0,0,0,0,1},
	{1,1,1,1,1,1,1,1,1,1}
};//地图
	
int main()
{
	if(mgpath(1,1,M,N) == 0)
		printf("无解");
	return 0;
}

int mgpath(int xi,int yi,int xe,int ye)//求解路径为：(xi,yi)->(xe,ye)
{
	int i,j,k,di,find;
	StType st;//定义栈st
	st.top=-1;//初始化栈顶指针
	st.top++;//初始方块进栈，top指针加1
	st.data[st.top].i=xi;
	st.data[st.top].j=yi;
	st.data[st.top].di=-1;//di初始化为-1，表示还没有开始找下一个可走的方块
	mg[xi][yi]=-1;//起点不能重复到达
	while(st.top>-1)//栈不为空时循环
	{
		i=st.data[st.top].i;
		j=st.data[st.top].j;
		di=st.data[st.top].di;//取栈顶方块
		if(i==xe&&j==ye)//找到出口，输出路径
		{
			printf("迷宫路径如下：\n");
			for(k=0; k<=st.top; k++)
			{
				printf("\t(%d,%d)",st.data[k].i,st.data[k].j);
				if((k+1)%6==0)
					printf("\n");
			}
			printf("\n");
			return 1;
		}
		find=0;//还没找到下一个可走方块
		while(di<4&&find==0)//找下一个可走方块
		{
			di++;
			switch(di)
			{
				/*显然这种算法只在终点在起点的左下方时为最小路径，其他情况时则不是
				因为每次都从左边先开始找，对于右下方的终点来说必然会绕弯子*/
				case 0://左
					i=st.data[st.top].i-1;
					j=st.data[st.top].j;
					break;
				case 1://下
					i=st.data[st.top].i;
					j=st.data[st.top].j+1;
					break;
				case 2://右
					i=st.data[st.top].i+1;
					j=st.data[st.top].j;
					break;
				case 3://上
					i=st.data[st.top].i;
					j=st.data[st.top].j-1;
					break;
			}
			if(mg[i][j]==0)
				find=1;//找下一个可走相邻方块
		}
		if(find==1)//找到了下一个可走方块
		{
			st.data[st.top].di=di;//修改原栈顶元素的di值
			st.top++;//下一个可走方块进栈
			st.data[st.top].i=i;
			st.data[st.top].j=j;
			st.data[st.top].di=-1;
			mg[i][j]=-1;//避免重复走到该方块
		}
		else//没有路径可走则退栈
		{
			mg[st.data[st.top].i][st.data[st.top].j]=0;//让该位置变为其他路径可走方块
			st.top--;//将该方块退栈
		}
	}
	return 0;
}
