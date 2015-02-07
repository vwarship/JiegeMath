package com.zaoqibu.jiegemath;

/**
 * Created by vwarship on 2015/1/26.
 */
abstract public class Problem {
    protected int x;
    protected int y;

    public Problem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    abstract public int result();

}
