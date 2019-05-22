import java.util.*;

public class sudoku
{
	public static int N = 9;
	public static int flag=1;
	public static void main(String args[])
	{
		int[][] matrix = {{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			                {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			                {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			                {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			                {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			                {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			                {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			                {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			                {0, 0, 5, 2, 0, 6, 3, 0, 0}}; 
		
		if(sudoku(matrix,0,0))
		{
			
			System.out.println("true");
			for(int i=0;i<N;i++)
			{System.out.println();
				for(int j=0;j<N;j++)
				{
					System.out.print("  "+matrix[i][j]);
				}
			}
		}
		else
		{
			System.out.println("can't do with the matrix");
		}
				
	}
	
	
	
	
	public static boolean sudoku(int matrix[][],int row,int col)
	{
		
		boolean isEmpty = true; 
		for(int t=row;t<N;t++)
		{
			for(int i=0;i<N;i++)
			{
				if(matrix[t][i]==0)
				{	row = t;
					col = i;
					isEmpty = false;  
	                break; 
				}
			}
			if (!isEmpty) 
	        { 
	            break; 
	        } 
		}
		
		if (isEmpty)  
	    { 
	        return true; 
	    } 
		
		for(int j=1;j<10;j++)
		{
			if((checkmatrix(matrix,row,col,j))&&(checkrow(matrix,row,col,j))&&(checkcol(matrix,row,col,j))  )
			{
				
				matrix[row][col]=j;
				
				if(!sudoku(matrix,row,col))
				{
					
					matrix[row][col]=0;
				}
				else
				{
					return true;
				}
				
			}		
		}
		
		return false;
	}
	
	
	public static boolean checkmatrix(int matrix[][],int row,int col,int target)
	{	

		int rowN=0,colN=0,rowS=0,colS=0;
		for(int i =2;i<N;)
		{
			if(col<=i)
			{
				colN = i; 
				break;
			}
			i=i+3;
		}
		
		for(int i =2;i<N;)
		{
			if(row<=i)
			{
				rowN = i; 
				break;
			}
			i=i+3;
		}
		rowS = rowN - 2;
		colS = colN - 2;
		
		
		
		for(int i=rowS;i<=rowN;i++)
		{
			for(int j=colS;j<=colN;j++)
			{
				if(matrix[i][j] == target)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	public static boolean checkrow(int matrix[][],int row,int  col,int target)
	{
		
		for(int j=0;j<N;j++)
		{
			if(matrix[j][col] == target)
			{
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	public static boolean checkcol(int matrix[][],int row,int col,int target)
	{
		for(int j=0;j<N;j++)
		{
			if(matrix[row][j] == target)
			{
				return false;
			}
		}
		return true;
	}
}
