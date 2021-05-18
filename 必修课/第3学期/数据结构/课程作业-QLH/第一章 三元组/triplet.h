#ifndef _TRIPLET_H
#define _TRIPLET_H

#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2

typedef int elemtype;//数据元素种类不一定要是int，可在此处直接修改
typedef elemtype* triplet;//triplet定义为一个指针即可，具体几元由malloc决定

int init_triplet(triplet &T,elemtype v1,elemtype v2,elemtype v3);
//构造三元组

int destory_triplet(triplet &T);
//摧毁三元组

int get(triplet T,int i,elemtype e);
//用e返回T的第i个元素的值

int put(triplet &T,int i,elemtype e);
//将T的第i个元素的值改变为e

int is_ascending(triplet T);
//如果是按照升序排列则返回1，反之返回0

int is_descending(triplet T);
//降序排列return 1，否则0
 
int max(triplet T,elemtype &e);
//用e返回max

int min(triplet T,elemtype &e);
//用e返回min

int print_triplet(triplet T);

#endif
