package com.zaoqibu.jiegemath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vwarship on 2015/1/26.
 */
public class TestPaper {
    private List<Problem> problems = new ArrayList<>();

    public void add(Problem problem) {
        problems.add(problem);
    }

    public int count() {
        return  problems.size();
    }

    public Problem get(int index) {
        return problems.get(index);
    }
}
