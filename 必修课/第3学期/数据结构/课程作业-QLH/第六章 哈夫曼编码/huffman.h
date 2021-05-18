#ifndef _HUFFMAN_H
#define _HUFFMAN_H

#define MAXBIT      100
#define MAXVALUE  10000
#define MAXLEAF     30
#define MAXNODE    MAXLEAF*2 -1

void HuffmanTree (HNodeType HuffNode[MAXNODE],int n);

void decodeing(char string[],HNodeType Buf[],int Num);

#endif
