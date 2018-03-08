package com.zuora.interview;

public interface TopNPopularPathService {

    void setup(String[][] data);

    String[] getTopNPopularPaths(int n);
}
