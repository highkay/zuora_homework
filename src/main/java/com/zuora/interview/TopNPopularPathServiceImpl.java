package com.zuora.interview;

import java.util.*;
import java.util.stream.Collectors;

/*
    Use JDK 8 stream api to transform and count path from source data.
 */
public class TopNPopularPathServiceImpl implements TopNPopularPathService {

    public static final int PATH_LENGTH = 3;
    private List<String> paths;

    private void extractPathsFromSourceData(String[][] data) {
        Objects.requireNonNull(data);
        // Transform the source data into a map, the key is user identify and the value are pages.
        Map<String, List<String>> pagesByUser = Arrays.stream(data).collect(Collectors.groupingBy(c -> c[0], Collectors.mapping(
                c -> c[1],
                Collectors.toList())));
        // Calc and join the path with pages.
        // here is not an elegant way, may replace with 3rd util lib later.
        paths = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        pagesByUser.entrySet().stream().map(Map.Entry::getValue).forEach(list -> {
            int i, j, size;
            size = list.size() - PATH_LENGTH;
            for (i = 0; i < size; i++) {
                for (j = 0; j < PATH_LENGTH; j++) {
                    sb.append(list.get(i + j));
                    if (j == PATH_LENGTH - 1) {
                        paths.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.append("->");
                    }
                }
            }
        });
    }

    public void setup(String[][] data) {
        Objects.requireNonNull(data);
        extractPathsFromSourceData(data);
    }

    public String[] getTopNPopularPaths(int n) {
        Objects.requireNonNull(paths);
        // map with path and count, transform to the print string style.
        return paths.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(n).map(e -> e.getKey() + ":" + e.getValue()).toArray(String[]::new);
    }
}
