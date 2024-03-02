/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolverproject;

/**
 *
 * @author acely
 */
public class MazeSolverProject {

    public static void main(String[] args) {
        int grid = 5;
        int[][] maze = getMaze(grid);
        
        Stack <Coordinates> path = new Stack<>();
        Coordinates start = new Coordinates(1, 1);
        path.push(start);
        maze[1][1]=2;
        MazeUtility.plotMaze(maze); 
        
        while (!path.isEmpty()) {
            Coordinates current = path.getTop();
            int x = current.getX();
            int y = current.getY();

            if (x == 2 * grid - 1 && y == 2 * grid - 1) {
                System.out.println("Maze solved!");
                break;
            }
            
         
            if (isValid(x + 1, y, maze)) {
                path.push(new Coordinates(x + 1, y));
                maze[x + 1][y] = 2;
                maze[x][y] = 0;
            } else if (isValid(x, y + 1, maze)) {
                path.push(new Coordinates(x, y + 1));
                maze[x][y + 1] = 2;
                maze[x][y] = 0;
            } else if (isValid(x - 1, y, maze)) {
                path.push(new Coordinates(x - 1, y));
                maze[x - 1][y] = 2;
                maze[x][y] = 0;
            } else if (isValid(x, y - 1, maze)) {
                path.push(new Coordinates(x, y - 1));
                maze[x][y - 1] = 2;
                maze[x][y] = 0;
            } else {
                path.pop();
            }

            MazeUtility.plotMaze(maze);
        }
    }
                  public static boolean isValid(int x, int y, int[][] maze) {
                  return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }


        // To do: starting from the coordinates [1,1], use the path stack to navigate in the maze and 
        // find a way to [2*grid-1, 2*grid-1] coordinates
        // use the following code to print the maze at each step
        // MazeUtility.plotMaze(maze);  
        // DO NOT change any of the given code
        
        
    
    
    public static int[][] getMaze(int grid) {
        MazeGenerator maze = new MazeGenerator(grid);
        String str = maze.toString();
        
        int[][] maze2D = MazeUtility.Convert2D(str);    
        return maze2D;
    }   
}
