package programmers.알고리즘고득점KIT.깊이너비우선탐색;

import java.util.ArrayList;
import java.util.List;

public class 퍼즐조각채우기 {

    public static void main(String[] args) {
        퍼즐조각채우기 problem = new 퍼즐조각채우기();

        int[][] game_board1 = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table1 = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println("problem = " + problem.solution(game_board1, table1));


        int[][] game_board2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] table2 = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};
        System.out.println("problem = " + problem.solution(game_board2, table2));
    }

    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> emptySpacesList = findEmptySpaces(game_board);
        List<List<int[]>> puzzleShapesList = findPuzzleShapes(table);

        int totalFilled = 0;

        for (List<int[]> puzzleList : puzzleShapesList) {
            for (int rotation = 0; rotation < 4; rotation++) {
                for (List<int[]> emptySpace : emptySpacesList) {
                    if (canPlace(game_board, emptySpace, puzzleList)) {
                        place(game_board, emptySpace, puzzleList);
                        totalFilled += puzzleList.size();
                        break;
                    }
                }

                puzzleList = rotate(puzzleList);
            }
        }

        return totalFilled;
    }

    // findEmptySpaces: 게임 보드에서 빈 공간을 탐색한다. DFS를 사용하여 빈 공간을 찾고, 이를 정규화하여 저장한다.
    private List<List<int[]>> findEmptySpaces(int[][] board) {
        List<List<int[]>> spacesList = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    List<int[]> spaceList = new ArrayList<>();
                    exploreSpace(board, visited, i, j, spaceList);
                    spacesList.add(normalize(spaceList));
                }
            }
        }

        return spacesList;
    }

    // exploreSpace: DFS를 통해 빈 공간을 탐색하는 헬퍼 함수이다.
    private void exploreSpace(int[][] board, boolean[][] visited, int x, int y, List<int[]> spaceList) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length || visited[x][y] || board[x][y] != 0) return;
        visited[x][y] = true;
        spaceList.add(new int[]{x, y});

        exploreSpace(board, visited, x - 1, y, spaceList);
        exploreSpace(board, visited, x + 1, y, spaceList);
        exploreSpace(board, visited, x, y - 1, spaceList);
        exploreSpace(board, visited, x, y + 1, spaceList);
    }

    // findPuzzleShapes: 테이블에서 퍼즐 조각을 탐색한다. DFS를 사용하여 조각을 찾고, 이를 정규화하여 저장한다.
    private List<List<int[]>> findPuzzleShapes(int[][] table) {
        List<List<int[]>> shapesList = new ArrayList<>();
        boolean[][] visited = new boolean[table.length][table.length];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    List<int[]> shapeList = new ArrayList<>();
                    exploreShape(table, visited, i, j, shapeList);
                    shapesList.add(normalize(shapeList));
                }
            }
        }

        return shapesList;
    }

    // exploreShape: DFS를 통해 퍼즐 조각을 탐색하는 헬퍼 함수이다.
    private void exploreShape(int[][] table, boolean[][] visited, int x, int y, List<int[]> shapeList) {
        if (x < 0 || x >= table.length || y < 0 || y >= table.length || visited[x][y] || table[x][y] != 1) return;
        visited[x][y] = true;
        shapeList.add(new int[]{x, y});

        exploreSpace(table, visited, x - 1, y, shapeList);
        exploreSpace(table, visited, x + 1, y, shapeList);
        exploreSpace(table, visited, x, y - 1, shapeList);
        exploreSpace(table, visited, x, y + 1, shapeList);
    }

    // normalize: 퍼즐 조각이나 빈 공간의 모양을 정규화하여 (0, 0) 기준으로 맞춘다.
    private List<int[]> normalize(List<int[]> shapeList) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] point : shapeList) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }

        List<int[]> normalizedList = new ArrayList<>();
        for (int[] point : shapeList) normalizedList.add(new int[]{point[0] - minX, point[1] - minY});

        return normalizedList;
    }

    // canPlace: 주어진 빈 공간에 퍼즐 조각을 놓을 수 있는지 확인한다.
    private boolean canPlace(int[][] board, List<int[]> emptySpaceList, List<int[]> puzzleList) {
        for (int[] point : puzzleList) {
            int x = emptySpaceList.get(0)[0] + point[0];
            int y = emptySpaceList.get(0)[1] + point[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board.length || board[x][y] != 0) return false;
        }

        return true;
    }

    // place: 퍼즐 조각을 빈 공간에 놓는다.
    private void place(int[][] board, List<int[]> emptySpaceList, List<int[]> puzzleList) {
        for (int[] point : puzzleList) {
            int x = emptySpaceList.get(0)[0] + point[0];
            int y = emptySpaceList.get(0)[1] + point[1];
            board[x][y] = 1;
        }
    }

    // rotate: 퍼즐 조각을 90도 회전시킨다.
    private List<int[]> rotate(List<int[]> shapeList) {
        List<int[]> rotatedList = new ArrayList<>();
        for (int[] point : shapeList) rotatedList.add(new int[]{-point[1], point[0]});
        return normalize(rotatedList);
    }
}
