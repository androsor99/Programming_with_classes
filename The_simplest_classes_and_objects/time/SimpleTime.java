package com.androsor.prog_class.time;

import java.util.Objects;

public class SimpleTime implements Cloneable {

    private int hour;
    private int minute;
    private int second;

    public SimpleTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            this.minute = 0;
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            this.second = 0;
        } else {
            this.second = second;
        }
    }

    public void replaceHour(int hour) {
        this.hour = (this.hour + hour) % 24;
        if (this.hour < 0) {
            this.hour += 24;
        }
    }

    public void replaceMinute(int minute) {
        if ((this.minute + minute) < 0) {
            replaceHour(minute / 60 - 1);
            this.minute = 60 + ((this.minute + minute) % 60);
        } else {
            replaceHour((this.minute + minute) / 60);
            this.minute = (this.minute + minute) % 60;
        }
    }

    public void replaceSecond(int second) {
        if ((this.second + second) < 0) {
            replaceMinute(second / 60 - 1);
            this.second = 60 + ((this.second + second) % 60);
        } else {
            replaceMinute((this.second + second) / 60);
            this.second = (this.second + second) % 60;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTime timeClass = (SimpleTime) o;
        return hour == timeClass.hour &&
                minute == timeClass.minute &&
                second == timeClass.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
