package com.mooc.common;

import java.util.List;

/**
 * 
* @Title: PagenableBean.java 
* @Description: 用来存放可分页对象的BEAN 
* @author widthdrawnm 
* @date 2016年4月13日 上午11:14:56 
* @version V1.0
 */
public class PagenableBean {

	

	public <T> PagenableBean(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = (List<T>)rows;
	}

	/**
	 * 分页总记录数
	 */
	private Long total;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}


	/**
	 * 该页的所有记录
	 */
	private List<?> rows;
	
	
	

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	
	
}
