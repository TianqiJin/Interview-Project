
public class Main {
	public static void main(String[] args){
		int[][] testArray = {{1,2,3},{0,0,1},{2,3,4}};
		setZero(testArray);
	}
	public static void setZero(int[][] array){
		boolean[][] position = new boolean[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(position[i][j] != true && array[i][j] != 0)
					position[i][j] = false;
				else if(array[i][j] == 0){
					for(int m = 0; m < 3; m++)
						position[i][m] = true;
					for(int m = 0; m < 3; m++)
						position[m][j] = true;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(position[i][j] == true)
					array[i][j] = 0;
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
