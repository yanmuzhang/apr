package cn.liberfree.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-23 16:05
 **/
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 4539530863625437099L;
    private int pageIndex = 1;
    private int pageSize = 15;
    private long totalCount = 0L;
    private List<T> rows;

    public PageResult(int pageIndex, int pageSize, long totalCount, List<T> rows) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public PageResult(Page page) {
        this.pageIndex = page.getPageIndex();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        this.rows = page.getRows();
    }

    public PageResult() {
    }

    public static PageResult build(Page page){
        return new PageResult(page);
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
