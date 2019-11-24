package cn.com.sinosoft.web.domain;
/**
 * 单例类,作为唯一的单例类实现所有需要单例的对象
 * @author Administrator
 *
 */
public class SingleCap {
	
	private static SingleCap singleCap;
	
	private IIMSSession iIMSSession;
	
	private SingleCap(){
		init();
	}
	
	public static SingleCap getInstance(){
		if(singleCap == null){
			singleCap = new SingleCap();
		}
		return singleCap;
	}
	
	public void init(){
		iIMSSession = new IIMSSession();
	}

	public IIMSSession getIIMSSession(){
		return iIMSSession;
	}
}
