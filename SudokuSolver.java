
public class SudokuSolver {
	public static void main(String[] args) {
		int[][] puzzle = {  {8, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 3, 6, 0, 0, 0, 0, 0},
							{0, 7, 0, 0, 9, 0, 2, 0, 0},
							{0, 5, 0, 0, 0, 7, 0, 0, 0},
							{0, 0, 0, 0, 4, 5, 7, 0, 0},
							{0, 0, 0, 1, 0, 0, 0, 3, 0},
							{0, 0, 1, 0, 0, 0, 0, 6, 8},
							{0, 0, 8, 5, 0, 0, 0, 1, 0},
							{0, 9, 0, 0, 0, 0, 4, 0, 0}  };
		
		long start = System.currentTimeMillis();
		
		print(puzzle);
		solve(puzzle);
		print(puzzle);
		
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start);
		
		}
	
	public static void print(int[][] grid) {
		for(int i = 0; i < 9; i++) {
			System.out.println();
			for(int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	public static boolean possible(int[][] grid, int x, int y, int n) {
		if(grid[y][x] != 0) {
			return false;
		}
		for(int i = 0; i < 9; i++) {
			int j = x;
			if(grid[i][j] == n) {
				return false;
			}
		}
		for(int j = 0; j < 9; j++) {
			int i = y;
			if(grid[i][j] == n) {
				return false;
			}			
		}
		
		int startj = (x/3) * 3;
		int starti = (y/3) * 3;
		for(int i = starti; i < starti+3; i++) {
			for(int j = startj; j < startj+3; j++) {
				if(grid[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solve(int[][] grid) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(grid[i][j] == 0) {
					for(int n = 1; n <= 9; n++) {
						if(possible(grid, j, i, n)) {
							grid[i][j] = n;
							if(solve(grid)) {
								return true;
							}
							else {
								grid[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
}
