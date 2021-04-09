package com.androsor.task1;

import java.util.Objects;

public abstract class TextElement<T> {

    protected T textElement;

    public TextElement() {
    }

    public TextElement(T textElement) {
        this.textElement = textElement;
    }

    public T getTextElement() {
        return textElement;
    }

    public void setTextElement(T textElement) {
        this.textElement = textElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextElement<?> that = (TextElement<?>) o;
        return Objects.equals(textElement, that.textElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textElement);
    }
}
