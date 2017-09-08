package cn.charlie166.learn.spring.cloud.dto;

public class TestModel {

	private String val;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "val:" + this.val;
	}
	
}