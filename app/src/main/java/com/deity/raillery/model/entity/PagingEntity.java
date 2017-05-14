package com.deity.raillery.model.entity;

/**
 * Created by Deity on 2017/5/15.
 */

public class PagingEntity {
    private DynamicEntity[] content;
    private boolean isLast;
    private int totalPages;
    private int totalElements;
    private String sort;
    private boolean isFirst;
    private int numberOfElements;
    private int size;
    private int number;

    public DynamicEntity[] getContent() {
        return content;
    }

    public void setContent(DynamicEntity[] content) {
        this.content = content;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
