package cn.charlie166.learn.spring.cloud.consumer.redis.entity;

/**
* @ClassName: RedisModel 
* @Description: redis关联数据模型
* @company 
* @author liyang
* @Email yang.li@rato360.com
* @date 2017年9月13日 
*
 */
public class RedisRefModel {

	/**关联数据ID**/
	private String refid;
	/**关联集合**/
	private String ref;
	
	
	public String getRefid() {
		return refid;
	}
	public void setRefid(String refid) {
		this.refid = refid;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	
}