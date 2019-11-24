package cn.com.sinosoft.web.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.config.service.AreaService;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeArea;
import cn.com.sinosoft.dto.system.AreaTree;



/**描述：区域Action<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2013-12-20下午01:32:19 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */
public class AreaAction extends Struts2Action{
	private String prentId;
	private String createTime;
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPrentId() {
		return prentId;
	}

	public void setPrentId(String prentId) {
		this.prentId = prentId;
	}

	private GeArea geArea;
	@Autowired
	private AreaService areaService;
	
	public GeArea getGeArea() {
		return geArea;
	}

	public void setGeArea(GeArea geArea) {
		this.geArea = geArea;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}


	/**描述：处理区域信息页面<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-20下午07:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="area")
	public String jumpAreaPage(){
		return "page/main/area";
	}
	
	/**方法名称: jumpAddOrUpdateAreaPage<br>
	 * 描述：跳转至添加或修改页面
	 * 作者: dengjiaxing
	 * 修改日期：2013-12-30下午05:04:48
	 * @return
	 */
	@Action(value="jumpAddOrUpdateAreaPage")
	public String jumpAddOrUpdateAreaPage(){
		return "page/main/area-operate";
	}
	
	/**描述：获取根区域br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-26下午19:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="getGeAreaRoot")
	public String getGeAreaRoot(){
		List<GeArea> geAreas = areaService.getGeAreaRoot();
//		List<GeArea> geAreas = areaService.getGeAeraAll();
		List<AreaTree> areaTrees = new ArrayList<AreaTree>();
		for(GeArea geArea:geAreas){
			AreaTree tree = new AreaTree();
			tree.setId(geArea.getGid());//主Id
			tree.setParentId("0");//从Id
			tree.setText(geArea.getGname());
			String gid = geArea.getGid();
			if(geArea.getChilds().size()>0){
				tree.setState("closed"); 
			}else{
				tree.setState("open");
			}
			BeanUtils.copyProperties(geArea, tree);
			areaTrees.add(tree);
		}
		String trees = JSONArray.fromObject(areaTrees).toString();
		System.out.println(trees);
		super.render(trees, "text/json;charset=UTF-8");
		return null;
	}
	
	
	
	/**描述：获取子区域br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-26下午20:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="getGeAreaChild")
	public String getGeAreaChild(){
		List<GeArea> geAreas = areaService.getGeAreaChild(prentId);
		List<AreaTree> areaTrees = new ArrayList<AreaTree>();
		for(GeArea geArea:geAreas){
			AreaTree tree = new AreaTree();
			tree.setId(geArea.getGid());//主Id
			tree.setParentId(geArea.getParentArea().getGid());//从Id
			tree.setText(geArea.getGname());
			String gid = geArea.getGid();
			List<GeArea> childs = areaService.getGeAreaChild(gid);
			if(childs!=null&&childs.size()>0){
				tree.setState("closed"); 
			}else{
				tree.setState("open");
			}
			
			BeanUtils.copyProperties(geArea, tree,new String[]{"pgid","parentArea","childs"});
			tree.setParentId(geArea.getParentArea().getGid());
			tree.setPgid(geArea.getParentArea().getGid());
			areaTrees.add(tree);
		}
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		String trees = JSONArray.fromObject(areaTrees,jsonConfig).toString();
		super.render(trees, "text/json;charset=UTF-8");
		return null;
	}
	
	/**方法名称: existChildren<br>
	 * 描述：是否存在子区域
	 * 作者: dengjiaxing
	 * 修改日期：2013-12-27下午04:07:36
	 * @return
	 */
	@Action(value="existChildren")
	public String existChildren(){
		String gid = geArea.getGid();
		List<GeArea> childs = areaService.getGeAreaChild(gid);
		if(childs.size()>0&&childs!=null){
			renderText("EXIST"); 
		}
		return null;
	}
	
	/**描述：删除区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-20下午07:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="deleteArea")
	public void deleteArea(){
		areaService.deleteGeArea(geArea.getGid());
		renderText("DEL_SUCCESS"); 
	}
	
	
	/**描述：添加或修改区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-20下午07:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="addUpdateArea")
	public void addResource(){
		
			if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
				GeArea parentArea = areaService.getGeArea(geArea.getPgid());
				geArea.setParentArea(parentArea);
				geArea.setNote(geArea.getNote());//区域描述
	
				geArea.setCreateTime(new Date());//创建时间
				areaService.addGeArea(geArea);
				renderText("ADD_SUCCESS"); 
			}else{
				GeArea area = areaService.getGeArea(geArea.getGid());
				area.setGname(geArea.getGname());
				area.setNote(geArea.getNote());//区域描述
				area.setCreateTime(new Date());//创建时间
				areaService.updateGeArea(geArea);
				renderText("UPDATE_SUCCESS"); 
		}
	}
	
	/**描述：区域id是否存在<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-20下午07:41:01 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@Action(value="existArea")
	public void existAreaGid(){
		Map<String, String> result = new HashMap<String, String>();
		if("ADD".equals(getHttpServletRequest().getParameter("opeartype"))){
			String gid = geArea.getGid();
			boolean boo = areaService.existGeArea(gid);
			if(boo || "1".equals(gid)){ //存在  "1"为所有跟区域的父id
				result.put("error", "此编号已存在");
			}
			else{//不存在
				result.put("ok", "");
			}
		}
		else{
			result.put("ok", "");
		}
		renderText(JSONObject.fromObject(result).toString());
	}
}
