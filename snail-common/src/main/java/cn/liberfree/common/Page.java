package cn.liberfree.common;

import java.util.*;

/**
 * @author: zhangchao
 * @time: 2018-08-20 17:42
 **/
public class Page<T> implements List<T> {

    private int pageIndex = 1;
    private int pageSize = 15;
    private long totalCount = 0L;
    private List<T> rows;
    public Page() {
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalPage() {
        long residue = this.totalCount % (long)this.pageSize;
        return residue == 0L ? this.totalCount / (long)this.pageSize : this.totalCount / (long)this.pageSize + 1L;
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int size() {
        return this.rows.size();
    }

    public boolean isEmpty() {
        return this.rows.isEmpty();
    }

    public boolean contains(Object o) {
        return this.rows.contains(o);
    }

    public Iterator<T> iterator() {
        return this.rows.iterator();
    }

    public Object[] toArray() {
        return this.rows.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.rows.toArray(a);
    }
    public boolean add(T t) {
        return this.rows.add(t);
    }

    public boolean remove(Object o) {
        return this.rows.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.rows.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return this.rows.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return this.rows.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return this.rows.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.rows.retainAll(c);
    }

    public void clear() {
        this.rows.clear();
    }

    public T get(int index) {
        return this.rows.get(index);
    }

    public T set(int index, T element) {
        return this.rows.set(index, element);
    }

    public void add(int index, T element) {
        this.rows.add(index, element);
    }

    public T remove(int index) {
        return this.rows.remove(index);
    }

    public int indexOf(Object o) {
        return this.rows.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return this.rows.lastIndexOf(o);
    }

    public ListIterator<T> listIterator() {
        return this.rows.listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return this.rows.listIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return this.rows.subList(fromIndex, toIndex);
    }
}
