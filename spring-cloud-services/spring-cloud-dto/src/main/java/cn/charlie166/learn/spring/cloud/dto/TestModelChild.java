package cn.charlie166.learn.spring.cloud.dto;

import java.util.List;

public class TestModelChild extends TestModel{

	private Integer sort;
	
	private String child;
	
	private String description;
	
	private List<String> list;

	public String getChild() {
		return child;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setChild(String child) {
		this.child = child;
	}
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "val:" + this.getVal() + "----child:" + this.child + "--sort:" + this.sort;
	}
	
}