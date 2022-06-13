class Solution {
    static class Vertex {
        int x;
        int y;
        Vertex(int x, int y) {this.x = x; this.y = y;}
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        Vertex TL = new Vertex(0, 0);
        Vertex BR = new Vertex(matrix[0].length-1, matrix.length-1);
        List<Integer> res = new ArrayList<>();

        while(TL.x <= BR.x && TL.y <= BR.y) {
            getEdges(res, matrix, TL, BR);
            TL.x++;
            BR.x--;
            TL.y++;
            BR.y--;
        }

        return res;
    }

    private void getEdges(List<Integer> res, int[][] matrix, Vertex TL, Vertex BR) {
        Vertex curr = new Vertex(TL.x, TL.y);

        if(TL.y == BR.y) {
            while(curr.x <= BR.x) {
                res.add(matrix[curr.y][curr.x]);
                curr.x++;
            }
        }
        else if(TL.x == BR.x) {
            while(curr.y <= BR.y) {
                res.add(matrix[curr.y][curr.x]);
                curr.y++;
            }
        }
        else {
            while (curr.x < BR.x) {
                res.add(matrix[curr.y][curr.x]);
                curr.x++;
            }
            while (curr.y < BR.y) {
                res.add(matrix[curr.y][curr.x]);
                curr.y++;
            }
            while (curr.x > TL.x) {
                res.add(matrix[curr.y][curr.x]);
                curr.x--;
            }
            while (curr.y > TL.y) {
                res.add(matrix[curr.y][curr.x]);
                curr.y--;
            }
        }
    }
}