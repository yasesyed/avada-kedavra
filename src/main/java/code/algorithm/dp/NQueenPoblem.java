package code.algorithm.dp;

class NQueenPoblem {

    private static final int N = 4;

    private static class Position {
        int x;
        int y;
        int d1;
        int d2;

        public Position(int x, int y, int d1, int d2) {
            this.x = x;
            this.y = y;
            this.d1 = d1;
            this.d2 = d2;
        }
    }

    public Position[] solve() {
        Position[] positions = new Position[N];
        solve(positions, 0);
        return positions;
    }

    private boolean solve(Position[] positions, int i) {

        if (i >= N) {
            return true;
        }

        for (int j = 0; j < N; j++) {
            if (isValidPosition(positions, i, j)) {
                positions[i] = new Position(i, j, i - j, i + j);
                if (solve(positions, i + 1) == true) {
                    break;
                }
                positions[i] = null;
            }
        }
        return false;
    }


    private boolean isValidPosition(Position[] positions, int i, int j) {
        for (int q = 0; q < i; q++) {
            if (positions[q].x == i || positions[q].y == j || positions[q].d1 == i - j || positions[q].d2 == i + j) {
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        NQueenPoblem nQueenPoblem = new NQueenPoblem();

        //Position[] positions;
        //positions = nQueenPoblem.solve();

/*        for (int i = 0; i < positions.length; i++) {
            System.out.println("(" + positions[i].x + "," + positions[i].y + ")");
        }*/

        /*System.out.print(positions.length);
        System.out.println("(" + positions[0].x + "," + positions[0].y + ")");
        System.out.println("(" + positions[1].x + "," + positions[1].y + ")");
        System.out.println("(" + positions[2].x + "," + positions[2].y + ")");*/

    }

}
