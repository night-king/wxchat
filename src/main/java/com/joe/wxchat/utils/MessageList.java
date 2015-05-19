package com.joe.wxchat.utils;

import java.util.ArrayList;

/**
 * Note:
 * Created by zhouwd on 15-5-17.
 */
public class MessageList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if (this.size() == 10) {
            remove(0);
        }
        return super.add(e);
    }

    public E getLast() {
        return this.get(this.size() - 1);
    }

}
