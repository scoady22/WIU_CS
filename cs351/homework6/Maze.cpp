//Sean Coady
//CS 487
//Maze.cpp

/* interfaces with the findmaxgpa java application - plots differentiated results to a graph*/

#include"stdafx.h"
#include<Windows.h>
#include<iostream> 

enum color {BACKGROUND, ABNORMAL, TEMPORARY, ROUTE};
const int ROW_SIZE = 7;
const int COL_SIZE = 7;
 

bool find_maze_path(color[ROW_SIZE][COL_SIZE]);
bool find_maze_path(color[ROW_SIZE][COL_SIZE], int, int);
 
int main(){
 color grid[ROW_SIZE][COL_SIZE] =
 {{BACKGROUND, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {BACKGROUND, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {BACKGROUND, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, ABNORMAL},
 {BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, ABNORMAL, ABNORMAL, BACKGROUND},
 {BACKGROUND, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND},
 {BACKGROUND, ABNORMAL, BACKGROUND, BACKGROUND, BACKGROUND, ABNORMAL, BACKGROUND},
 {BACKGROUND, ABNORMAL, ABNORMAL, ABNORMAL, BACKGROUND, ABNORMAL, BACKGROUND}};
 
std::cout << std::boolalpha << "Path exists for maze: "<<find_maze_path(grid) << "\n";
std::cout << "I couldn't figure out how to output the path of the maze.\n";
system("PAUSE");
}
 
bool find_maze_path(color grid[ROW_SIZE][COL_SIZE]){
 return find_maze_path(grid, 0, 0);
}
 
bool find_maze_path(color grid[ROW_SIZE][COL_SIZE], int r, int c){
 if ( r < 0 || c < 0 || r >= ROW_SIZE || c >= COL_SIZE)
 	 return false;
 else if (grid[r][c] != BACKGROUND)
 	 return false;
 else if (r == ROW_SIZE - 1 && c == COL_SIZE - 1){
 	 grid[r][c] = ROUTE;
 	 return true;
 }
 else {
 	 grid[r][c] = ROUTE;
 	 if(find_maze_path(grid, r - 1, c)
 	 	 || find_maze_path(grid, r + 1, c)
 	 	 || find_maze_path(grid, r, c - 1)
 	 	 || find_maze_path(grid, r, c + 1)){ 
 	 	 	 return true;
 	 }
 	 else{
 	 	 grid[r][c] = TEMPORARY;
 	 	 return false;
 	 }
 }
}
