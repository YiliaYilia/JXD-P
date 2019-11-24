package cn.com.sinosoft.common;

import java.util.Set;


public class ChildObject {
	private static ChildObject childObject = new ChildObject();
	private ChildObject(){}
	public static ChildObject getInstance(){
    	return childObject;
    }
	public Set<String> getChildSet() {
		return childSet;
	}
	public void setChildSet(Set<String> childSet) {
		this.childSet = childSet;
	}
	private Set<String> childSet;
}
