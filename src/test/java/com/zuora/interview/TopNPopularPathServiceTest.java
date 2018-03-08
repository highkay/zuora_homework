package com.zuora.interview;

import org.junit.Assert;
import org.junit.Test;

public class TopNPopularPathServiceTest {

    public static final String[][] DATASET = new String[][]{{"U1", "/"}, {"U1", "login"}, {"U1", "subscriber"}, {"U2", "/"}, {"U2", "login"}, {"U2", "subscriber"}, {"U1", "/"}, {"U1", "login"}, {"U1", "subscriber"}, {"U1", "/"}, {"U2", "login"}, {"U2", "login"}, {"U2", "subscriber"}, {"U1", "/"}, {"U1", "login"}, {"U1", "subscriber"}, {"U1", "/"}, {"U2", "login"}, {"U2", "login"}, {"U1", "subscriber"}, {"U2", "/"}, {"U2", "login"}, {"U1", "login"}, {"U1", "subscriber"}, {"U1", "/"}, {"U2", "login"}, {"U1", "login"}, {"U1", "subscriber"}, {"U1", "/"}, {"U2", "login"}, {"U2", "subscriber"}, {"U1", "/"}, {"U1", "subscriber"}, {"U1", "/"}, {"U2", "login"}, {"U1", "login"}, {"U1", "subscriber"}, {"U2", "login"}, {"U2", "subscriber"}, {"U1", "/"}};

    public static final String[] RESULTSET_10 = {
            "login->subscriber->/:3",
            "/->login->subscriber:3",
            "subscriber:1",
            "/->/->login:1",
            "/->subscriber->/:1",
            "login->login->login:1",
            "subscriber->/->subscriber:1",
            "login->login->subscriber:1",
            "subscriber->login->login:1",
            "login->login->/:1"};

    public static final String[] RESULTSET_3 = {
            "login->subscriber->/:3",
            "/->login->subscriber:3",
            "subscriber:1"};

    @Test
    public void testTop10() {
        TopNPopularPathServiceImpl topNPopularPathService = new TopNPopularPathServiceImpl();
        topNPopularPathService.setup(DATASET);
        String[] result = topNPopularPathService.getTopNPopularPaths(10);
        Assert.assertArrayEquals(result, RESULTSET_10);
    }

    @Test
    public void testTop3() {
        TopNPopularPathServiceImpl topNPopularPathService = new TopNPopularPathServiceImpl();
        topNPopularPathService.setup(DATASET);
        String[] result = topNPopularPathService.getTopNPopularPaths(3);
        Assert.assertArrayEquals(result, RESULTSET_3);
    }


}
