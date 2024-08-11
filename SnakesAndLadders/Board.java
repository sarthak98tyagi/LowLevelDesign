package SnakesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private int m;
    private int n;
    private Cell[][] cells;
    private int snakeCount;
    private int ladderCount;

    public Board(int m, int n, int snakeCount, int ladderCount){
        this.m = m;
        this.n = n;
        cells = new Cell[m][n];
        initBoard();
        this.snakeCount = snakeCount;
        this.ladderCount = ladderCount;
        addSnakes();
        addLadders();
    }

    private void initBoard(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakes(){
        int snakesAdded  = 0;
        while (snakesAdded<snakeCount){
            int snakeTail = ThreadLocalRandom.current().nextInt(0,m*n-n);
            int snakeHead = ThreadLocalRandom.current().nextInt(snakeTail+n,m*n);
            if(cells[snakeHead/n][snakeHead%n].getJump()!=null)
                continue;
            Jump snake = new Snake(snakeHead,snakeTail);
            System.out.println("Snake added with head at "+snakeHead+" and tail at "+snakeTail);
            cells[snakeHead/n][snakeHead%n].setJump(snake);
            snakesAdded++;
        }
    }

    private void addLadders(){
        int laddersAdded = 0;
        while (laddersAdded < ladderCount){
            int ladderTail = ThreadLocalRandom.current().nextInt(0,(m*n-n));
            int ladderHead = ThreadLocalRandom.current().nextInt(ladderTail+n,m*n);
            if(cells[ladderTail/n][ladderTail%n].getJump()!=null)
                continue;
            Jump ladder = new Ladder(ladderTail,ladderHead);
            System.out.println("ladder added with head at "+ladderHead+" and tail at "+ladderTail);
            cells[ladderTail/n][ladderTail%n].setJump(ladder);
            laddersAdded++;
        }
    }

    public int checkJumps(int newPosition){
        int x = newPosition/n, y = newPosition%n;
        if(cells[x][y].getJump()!=null){
            Jump jump = cells[x][y].getJump();
            int jumpStart = jump.getStart();
            int jumpEnd = jump.getEnd();
            if(jumpStart<jumpEnd){
                System.out.println("Wohooo, you just climbed a ladder from "+jumpStart+" to "+jumpEnd);
                newPosition = jumpEnd;
            }
            else{
                System.out.println("Awwww, you just got bitten by a python in java, falling from "+jumpStart+" to "+jumpEnd);
                newPosition = jumpEnd;
            }
        }
        return newPosition;

    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSnakeCount() {
        return snakeCount;
    }

    public void setSnakeCount(int snakeCount) {
        this.snakeCount = snakeCount;
    }

    public int getLadderCount() {
        return ladderCount;
    }

    public void setLadderCount(int ladderCount) {
        this.ladderCount = ladderCount;
    }
}
