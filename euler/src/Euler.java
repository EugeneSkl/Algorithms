public class Euler {
    private String[] city;

    public Euler(String[] city) {
        this.city = city;
    }

    public static void main(String[] arr){
        String[] string = {"Караганда", "Воронеж", "Киев", "Жданов", "Витебск", "Архангельск"};
        //String[] string = {"Караганда", "Воронеж", "Киев", "Жданов", "Витебск", "Архангельск", "Минск"};
        for (int i = 0; i<string.length; i++){
            System.out.print(string[i] + " ");
        }System.out.println();
        Euler euler = new Euler(string);
        boolean result = euler.eulerianСycle();
        if (result == true){
            System.out.println("Да, можно");
        }
        else{
            System.out.println("Нет, нельзя");
        }
    }
    public boolean eulerianСycle(){
        int[][] adjacencyMatrix = adjacencyMatrix(city);
        int line = 0;
        int column = 0;
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++){
            for (int j = 0; j < adjacencyMatrix.length; j++){
                line += adjacencyMatrix[i][j];
            }
            for (int j = 0; j < adjacencyMatrix.length; j++){
                column += adjacencyMatrix[j][i];
            }
            if (line == column){
                count++;
            }
        }
        if (count == adjacencyMatrix.length){
            return true;
        }
        return false;
    }


    public static int[][] adjacencyMatrix(String[] city){
        int[][] matrix = new int[32][32];
        for (int i = 0; i < city.length; i++){
            int start = (int)city[i].charAt(0);
            int end = (int)city[i].charAt(city[i].length() - 1);
            matrix[start - 1040][end - 1072] = 1;
        }
        //print(matrix);
        return matrix;
    }

    public static void print(int[][] matrix){
        //System.out.println("а б в г д е ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
