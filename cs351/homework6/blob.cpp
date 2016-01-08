//Sean Coady
//CS 451
//Homework 6 part 1
#include "stdafx.h"
#include<Windows.h>
#include<iostream> 
 
enum color {BACKGROUND, ABNORMAL, TEMPORARY};
const int ROW_SIZE = 7;
const int COL_SIZE = 7;
using namespace std;
void restore(color[ROW_SIZE][COL_SIZE], int, int);
int count_cells(color[ROW_SIZE][COL_SIZE], int, int);

int main(){
 color grid[ROW_SIZE][COL_SIZE]=
 {{BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {ABNORMAL, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {BACKGROUND, BACKGROUND, ABNORMAL, ABNORMAL, BACKGROUND, BACKGROUND, ABNORMAL},
 {BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, ABNORMAL, ABNORMAL, BACKGROUND},
 {BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {BACKGROUND, BACKGROUND, BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, BACKGROUND},
 {BACKGROUND, ABNORMAL, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL}};
 
 
 int row;
 std::cout<<"Enter row: "; std::cin>>row;
 int col;
 std::cout<<"Enter column:"; std::cin>>col;
 std::cout << count_cells(grid, row, col) << " Abnormal Cells Found\n";
 std::cout<<"Restoring Grid to all normal cells...\n";
 std::cout<< count_cells(grid,row,col)<< " Abnormal Cells Found\n";
 
 system("PAUSE");
}
 
 int count_cells(color grid[ROW_SIZE][COL_SIZE], int r, int c){
 	 if(r < 0 || r >= ROW_SIZE || c < 0 || c >= COL_SIZE){
 	 return 0;
 }
 else if (grid[r][c] != ABNORMAL){
 	 return 0;
 }
 else{
 	 grid[r][c] = TEMPORARY;
	 grid[r][c] = BACKGROUND;
 	 return 1
 	 	 +count_cells(grid, r - 1, c - 1) + count_cells(grid, r - 1, c)
 	 	 +count_cells(grid, r - 1, c + 1) + count_cells(grid, r, c + 1)
 	 	 +count_cells(grid, r + 1, c + 1) + count_cells(grid, r + 1, c)
 	 	 +count_cells(grid, r + 1, c - 1) + count_cells(grid, r, c - 1);
 }
 
}
