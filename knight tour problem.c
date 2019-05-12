#include<stdio.h>
#include<stdlib.h>
int knight(int matrix[8][8],int xarray[],int yarray[],int x,int y,int count);
int check(int x,int y,int matrix[8][8]);
int main()
{
	int x=8,y=8,i=0,j=0;
	int matrix[x][y];
	int xarray[] = {  2, 1, -1, -2, -2, -1,  1,  2 }; 
	int yarray[] = {  1, 2,  2,  1, -1, -2, -2, -1 }; 
	for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				matrix[i][j]=0;
			}
		}
	matrix[0][0] = 1;
	int count=2;
	x = 0;
	y=0;
	if(!knight(matrix,xarray,yarray,x,y,count))
	{
		printf("knight cant travel all the square");
	}
	
}
int knight(int matrix[8][8],int xarray[],int yarray[],int x,int y,int count)
{
	int i,j,temp1,temp2;
	
	if(count==8*8+1)
	{
		return 1;		
	}
		
		for(i=0;i<8;i++)
		{
			temp1 = x+xarray[i];
			temp2 = y+yarray[i];
			if(check(temp1,temp2,matrix))
			{
				matrix[temp1][temp2] = count;
				if(knight(matrix,xarray,yarray,temp1,temp2,count+1))
				{
					for(i=0;i<8;i++)
					{printf("\n");
						for(j=0;j<8;j++)
						{
							printf("%d      ",matrix[i][j]);
						}
					}
					exit(0);
				}
				else
				{
					matrix[temp1][temp2] = 0;
				}
			}	
		}
		return 0;
		
}
int check(int x,int y,int matrix[8][8])
{	
	if((x<8)&&(x>=0)&&(y<8)&&(y>=0)&&(matrix[x][y]==0))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
