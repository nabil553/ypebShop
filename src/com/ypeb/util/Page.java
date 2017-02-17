package com.ypeb.util;

public class Page {
    //当前页数
    private int currentPage = 1;
    //每页显示数量
    private int everyPage = 21;
    //总页数
    private int totalPage;
    //总数量
    private int totalCount;

    //可以将dwz传过来的pageNum、numPerPage进行初始化
    public Page(int pageNum, int numPerPage) {
        this.currentPage = pageNum;
        this.everyPage = numPerPage;
    }

    
    public Page(int pagNum) {
        this.currentPage = pagNum;
    }
    
    public Page() {
    }

    public int getTotalPage() {
        return totalPage;
    }

    public Page setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    //设置总数量的同时，设置总页数
    public Page setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        int temp = 0;
        if(totalCount==0)
        	totalCount=1;
      
        if (totalCount % this.everyPage != 0) {
            temp++;
           
        }
        
        this.totalPage = totalCount / this.everyPage + temp;
        return this;
    }

    public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getCurrentPage() {
        return currentPage;
    }

    public int getEveryPage() {
        return everyPage;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
