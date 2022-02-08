package com.demo.countdownlibrary;

public class TimeEntity {
    private String tag; // tag，避免添加重复
    private int currentTime = 0; // 当前走的时间，s
    private int time; // 时间，s
    private TimeCallback callback;

    public TimeEntity(String tag, int time, TimeCallback callback) {
        this.tag = tag;
        this.time = time;
        this.callback = callback;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public TimeCallback getCallback() {
        return callback;
    }

    public void setCallback(TimeCallback callback) {
        this.callback = callback;
    }
}
