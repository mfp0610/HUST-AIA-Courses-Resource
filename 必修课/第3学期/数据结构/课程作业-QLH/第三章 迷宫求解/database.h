#ifndef _DATABASE_H
#define _DATABASE_H

typedef struct
{
    int i;//当前方块行号
    int j;//当前方块列号
    int di;//下一个可走的相邻方块的方位号
}Box;//定义方块类型

typedef struct
{
    Box data[100];//10*10的迷宫，所以设置100个box
    int top;//栈顶指针
}StType;//定义顺序栈类型
#endif
