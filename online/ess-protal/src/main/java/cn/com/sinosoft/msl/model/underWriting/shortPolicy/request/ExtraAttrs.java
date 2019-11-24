package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;

import java.util.List;

public class ExtraAttrs {
	private List<Entry> entry;

	public List<Entry> getEntry() {
		return entry;
	}

	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}
	
	public ExtraAttrs(List<Entry> entry) {
		super();
		this.entry = entry;
	}
	
	public ExtraAttrs(){
		super();
	}
}
