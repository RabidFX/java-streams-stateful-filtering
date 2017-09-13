package com.nullpaperexception.test.java.streams.filtering.beans;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Complex Fruit with much heavier equals.
 */
public class ComplexFruit implements Fruit {
    
    private final Integer size;
    private final FruitType type;

    public ComplexFruit(Integer size, FruitType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public Integer getSize() {
        try {
            Thread.sleep(0, 100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComplexFruit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
    }

    @Override
    public FruitType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.size);
        hash = 59 * hash + Objects.hashCode(this.type);
        try {
            Thread.sleep(0, 100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComplexFruit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexFruit other = (ComplexFruit) obj;
        try {
            Thread.sleep(0, 100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComplexFruit.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    
}
