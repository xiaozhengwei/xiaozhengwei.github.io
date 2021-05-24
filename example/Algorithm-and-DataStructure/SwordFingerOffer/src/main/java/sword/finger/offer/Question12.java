package sword.finger.offer;

public class Question12 {

    private static boolean hasPath() {


        return false;
    }

    private static boolean hasPath(char[][] matrix, char[] str) {
        boolean hasPath = false;

        // 记录是否被访问;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (hasPath()) {
                    hasPath = true;
                }
            }
        }


        return hasPath;
    }

    public static void main(String[] args) {
        /*
         * a b t g
         * c f c s
         * j d e h
         */
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        char[] str1 = {'b', 'f', 'c', 'e'};
        char[] str2 = {'a', 'b', 'f', 'b'};
        System.out.println(hasPath(matrix, str1));
        System.out.println(hasPath(matrix, str2));
    }

}
