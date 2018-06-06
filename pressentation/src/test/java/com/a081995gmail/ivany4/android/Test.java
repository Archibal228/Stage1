package com.a081995gmail.ivany4.android;

import junit.framework.Assert;

/**
 * Created by Archibal on 20.04.2018.
 */

public class Test {
@org.junit.Test
    public void test(){
        int a = plus(2,2);
    Assert.assertEquals(4,a);

    }

    private int plus(int a, int b){
        return a + b;
    }
}
