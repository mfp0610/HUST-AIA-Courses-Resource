#include <stdio.h>
#define MAXE 100
#define MAXV 100

typedef struct
{
	int vex1;                     //边的起始顶点
	int vex2;                      //边的终止顶点
	int weight;                    //边的权值
} Edge;

void kruskal(Edge E[],int n,int e); 
int fun(Edge arr[],int low,int high);
void quick_sort(Edge arr[],int start,int end);

int main()
{
	Edge E[MAXE];
	int nume,numn,i;
	//freopen("1.txt","r",stdin);//文件输入
	printf("输入顶数和边数(空格隔开，回车确认):\n（以交叉正方形为例，4顶6边）\n");
	scanf("%d%d",&numn,&nume);
	for(i=0; i<nume; i++)
		scanf("%d%d%d",&E[i].vex1,&E[i].vex2,&E[i].weight);
	quick_sort(E,0,nume-1);//利用快速排序给边的权重排序
	kruskal(E,numn,nume);
	return 0;
}

void kruskal(Edge E[],int n,int e)
{
	int i,j,m1,m2,sn1,sn2,k,sum=0;
	int vset[n+1];//借用一个辅助数组vset[i]用来判断某边是否加入了最小生成树集合
	for(i=1; i<=n; i++)      //初始化辅助数组
		vset[i]=i;
	k=1;//表示当前构造最小生成树的第k条边，初值为1
	j=0;//E中边的下标，初值为0
	while(k<e)//生成的边数小于e时继续循环
	{
		m1=E[j].vex1;
		m2=E[j].vex2;//取一条边的两个邻接点
		sn1=vset[m1];
		sn2=vset[m2];
		//分别得到两个顶点所属的集合编号
		if(sn1!=sn2)//两顶点分属于不同的集合，该边是最小生成树的一条边
		{
			//防止出现闭合回路
			printf("V%d-V%d=%d\n",m1,m2,E[j].weight);
			sum+=E[j].weight;
			k++;                //生成边数增加
			if(k>=n)
				break;
			for(i=1; i<=n; i++)  //两个集合统一编号
				if (vset[i]==sn2)  //集合编号为sn2的改为sn1
					vset[i]=sn1;
		}
		j++;                  //扫描下一条边
	}
	printf("最小权值之和=%d\n",sum);
}

void quick_sort(Edge arr[],int start,int end)
{
	int pos;
	if(start<end)
	{
		pos=fun(arr,start,end);
		quick_sort(arr,start,pos-1);
		quick_sort(arr,pos+1,end);
	}
}

int fun(Edge arr[],int low,int high)
{
	int key;
	Edge lowx;
	lowx=arr[low];
	key=arr[low].weight;
	while(low<high)
	{
		while(low<high && arr[high].weight>=key)
			high--;
		if(low<high)
			arr[low++]=arr[high];

		while(low<high && arr[low].weight<=key)
			low++;
		if(low<high)
			arr[high--]=arr[low];
	}
	arr[low]=lowx;
	return low;
}
