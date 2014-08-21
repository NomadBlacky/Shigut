package jp.ac.chibafjb.teclabo.summer.annotetion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    public int order();
}