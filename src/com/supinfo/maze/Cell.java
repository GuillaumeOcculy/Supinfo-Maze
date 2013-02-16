package com.supinfo.maze;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 15/02/13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class Cell implements Serializable {

    private String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
