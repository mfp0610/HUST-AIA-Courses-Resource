#include<stdio.h>

#define MAX 100
#define MAXCOST 0x7fffffff  //最大的int值

int graph[MAX][MAX];

void prim(int graph[][MAX], int n);

int main()
{
	int i, j, k, m, n;
	int x, y, cost;
	//freopen("1.txt","r",stdin);//文件输入
	printf("请输入结点个数和边的数量，用空格隔开\n");
	scanf("%d%d",&m,&n);//m=顶点的个数，n=边的个数
	printf("请用邻接表输入结点和边的信息，用空格隔开\n");
	for (i = 1; i <= m; i++)//初始化图
	{
		for (j = 1; j <= m; j++)
		{
			graph[i][j] = MAXCOST;//默认初始权重为无穷大
		}
	}
	for (k = 1; k <= n; k++)
	{
		scanf("%d%d%d",&i,&j,&cost);
		graph[i][j] = cost;
		graph[j][i] = cost;
	}

	prim(graph, m);
	return 0;
}

void prim(int graph[][MAX], int n)
{
	int lowcost[MAX];//lowcost[i]:表示以i为终点的边的最小权值,当lowcost[i]=0表示i点加入了MST
	int mst[MAX];//mst[i]:表示对应lowcost[i]的起点，当mst[i]=0表示起点i加入MST
	int i, j, min, minid, sum = 0;
	for (i = 2; i <= n; i++)
	{
		lowcost[i] = graph[1][i];//lowcost存放顶点1可达点的路径长度
		mst[i] = 1;//初始化以1位起始点
	}
	mst[1] = 0;
	for (i = 2; i <= n; i++)
	{
		min = MAXCOST;
		minid = 0;

		for (j = 2; j <= n; j++)//找出权值最短的路径长度以及最小的ID
		{
			if (lowcost[j] < min && lowcost[j] != 0)
			{
				min = lowcost[j];
				minid = j; 
			}
		}

		printf("V%d-V%d=%d\n",mst[minid],minid,min);
		sum += min;//求和
		lowcost[minid] = 0;//该处最短路径置为0

		for (j = 2; j <= n; j++)//用类似于Dijkstra的思想进行距离的“松弛”
		{
			if (graph[minid][j] < lowcost[j])//对这一点直达的顶点进行路径更新
			{
				lowcost[j] = graph[minid][j];
				mst[j] = minid;
			}
		}

	}
	printf("最小权值之和=%d\n",sum);
}
