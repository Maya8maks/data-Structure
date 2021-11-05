package com.borshcheva.datastructure;


public class TestVo {
    boolean isCreatedWithDefaultConstructor;
    boolean isCreatedWithIntConstructor;

    public TestVo() {
        isCreatedWithDefaultConstructor = true;
    }

    public TestVo(int value) {
        isCreatedWithIntConstructor = true;
    }

    public void getTe(){
        System.out.println("hjhg");
    }
    public final void printReport(){
        System.out.println("Report");
    }
    private final void printReporlot(){
        System.out.println("Report");
    }
}
