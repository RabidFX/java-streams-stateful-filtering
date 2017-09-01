package com.nullpaperexception.test.java.streams.filtering.beans;

import java.util.Objects;

/**
 * Simple fruit POJO with low memory footprint, and easy equality and ordering.
 */
public class SimpleFruit implements Fruit {

    private final int size;
    private final FruitType type;

    public SimpleFruit(int size, FruitType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public FruitType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.size;
        hash = 29 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleFruit other = (SimpleFruit) obj;
        if (this.size != other.size) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fruit{" + type + '|' + size + '}';
    }

}
