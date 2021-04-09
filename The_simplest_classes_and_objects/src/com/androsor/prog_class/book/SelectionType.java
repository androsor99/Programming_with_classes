package com.androsor.prog_class.book;

import java.util.function.Supplier;

public enum SelectionType {

    AUTHOR(1, SelectionOfBooksByAuthorImpl::new),
    PUBLISHER(2, SelectionOfBooksByPublisherImpl::new),
    RELEASE_DATE(3, SelectionOfBooksByReleasedImpl::new);

    private final int typeCode;
    private final Supplier<? extends SelectionOfBooks> selectionOfBooks;

    SelectionType(int typeCode, Supplier<? extends SelectionOfBooks> selectionOfBooks) {
        this.typeCode = typeCode;
        this.selectionOfBooks = selectionOfBooks;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public SelectionOfBooks getSelectionOfBooks() {
        return selectionOfBooks.get();
    }

    public static SelectionType getSelectionTypeByCode(int code) {
        for (SelectionType type : SelectionType.values()) {
            if (type.getTypeCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Нешта здарылася!");
    }
}
