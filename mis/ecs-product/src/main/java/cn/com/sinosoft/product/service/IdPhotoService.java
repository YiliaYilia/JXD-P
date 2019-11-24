package cn.com.sinosoft.product.service;

import java.util.List;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.IdPhotoData;

public interface IdPhotoService {
	
	public abstract Page<IdPhotoData> findList(IdPhotoData idPhotoData,int pageNumber,int pageSizee);
	
	public abstract List<IdPhotoData> findAllIdPhoto(IdPhotoData idPhotoData);
}
