package com.demo.shanelee.contextinference.entity;

/**
 * Created by ShaneLee on 16/5/17.
 */
public enum Movement implements IAttributes{
    NOT_MOVING("not moving"),
    MOVING("moving"),
    MOVING_FAST("moving fast");

    private String name;

    @Override
    public String getName() {
        return name;
    }

    Movement(String name) {

        this.name = name;
    }
}
