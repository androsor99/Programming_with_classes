package com.androsor.prog_class.counter;

class CounterDecimal {

    private int value;
    private int valueMin;
    private int valueMax;

    public CounterDecimal() {
       this.value = 20;
       this.valueMin = 0;
       this.valueMax = 100;
    }

    public CounterDecimal(int value, int valueMin, int valueMax) {
        this.valueMin = valueMin;
        this.valueMax = valueMax;
        this.value = value;
        if (this.valueMax < this.valueMin) {
            int temp = this.valueMax;
            this.valueMax = this.valueMin;
            this.valueMin = temp;
        }
        if (this.value < this.valueMin) {
            int temp = this.value;
            this.value = this.valueMin;
            this.valueMin = temp;
        }
        if (this.value > this.valueMax) {
            int temp = this.value;
            this.value = this.valueMax;
            this.valueMax = temp;
        }
    }

    public CounterDecimal(int valueMin, int valueMax) {
        this(valueMin, valueMax, valueMin);
        this.value = valueMin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValueMin() {
        return valueMin;
    }

    public void setValueMin(int valueMin) {
        this.valueMin = valueMin;
    }

    public int getValueMax() {
        return valueMax;
    }

    public void setValueMax(int valueMax) {
        this.valueMax = valueMax;
    }

    public void increase() {
        if (this.value <= this.valueMax) {
            this.value++;
        } else {
            this.value = this.valueMin;
            throw new IllegalArgumentException("Внимание! Достигнута нижняя граница дипазона!");
        }
    }

    public void decrease() {
        if (this.value >= this.valueMin) {
            this.value--;
        } else {
            this.value = this.valueMax;
            throw new IllegalArgumentException("Внимание. Произошло переполнение счетчика!");
        }
    }

    @Override
    public String toString() {
        return "CounterDecimal{" +
                "value=" + value +
                ", valueMin=" + valueMin +
                ", valueMax=" + valueMax +
                '}';
    }
}
