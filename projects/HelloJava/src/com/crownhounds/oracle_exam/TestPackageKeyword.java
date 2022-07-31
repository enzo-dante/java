package com.crownhounds.oracle_exam;

public class TestPackageKeyword {

    // CONSTANTS
    private static final String PACKAGE_NAME = TestPackageKeyword.class.getPackageName();
    private static final String CLASS_NAME = TestPackageKeyword.class.getSimpleName();

    public static void main(String[] args) {
        getName();
    }

    public static void getName() {
        System.out.println(CLASS_NAME + " CLASS\n" +
                "from PACKAGE " + PACKAGE_NAME);
    }
}