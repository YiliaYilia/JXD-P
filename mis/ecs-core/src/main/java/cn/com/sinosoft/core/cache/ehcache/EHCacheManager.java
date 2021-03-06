/**
 * File Name:EHCacheManager.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2014年1月10日上午11:22:32
 */
package cn.com.sinosoft.core.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

/**
 * 描述：EHcache管理类<br>
 * 作者：honghui <br>
 * 修改日期：2014年1月10日上午11:22:32 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 * maxElementsInMemory=“10000” //Cache中最多允许保存的数据对象的数量 external=“false”
 * //缓存中对象是否为永久的，如果是，超时设置将被忽略，对象从不过期 timeToIdleSeconds=“30”
 * //缓存数据钝化时间(设置对象在它过期之前的空闲时间) timeToLiveSeconds=“30”
 * //缓存数据的生存时间(设置对象在它过期之前的生存时间) overflowToDisk=“false” /> //内存不足时，是否启用磁盘缓存
 * memoryStoreEvictionPolicy="LRU" //内存不足时数据对象的清除策略 ehcache中缓存的3种清空策略：
 * FIFO(first in first out):先进先出 LFU( Less Frequently
 * Used):一直以来最少被使用的。如上面所讲，缓存的元素有一个hit属性，hit值最小的将会被清出缓存。 LRU(Least Recently
 * Used):最近最少使用的，缓存的元素有一个时间戳，当缓存容量满了，而又需要腾出地方来缓存新的元素的时候，
 * 那么现有缓存元素中时间戳离当前时间最远的元素将被清出缓存。
 * 
 * 
 * 1、timeToLiveSeconds的定义是：以创建时间为基准开始计算的超时时长；
 * 
 * 2、timeToIdleSeconds的定义是：在创建时间和最近访问时间中取出离现在最近的时间作为基准计算的超时时长；
 * 
 * 3、如果仅设置了timeToLiveSeconds，则该对象的超时时间=创建时间+timeToLiveSeconds，假设为A；
 * 4、如果没设置timeToLiveSeconds，则该对象的超时时间=min(创建时间，最近访问时间)+timeToIdleSeconds，假设为B；
 * 
 * 5、如果两者都设置了，则取出A、B最少的值，即min(A,B)，表示只要有一个超时成立即算超时。
 */
public class EHCacheManager {
	public static CacheManager manager = CacheManager.getInstance();

	/**
	 * 方法名称: addCache<br>
	 * 描述：添加缓存 作者: honghui 修改日期：2014年1月10日上午11:42:39
	 * 
	 * @param cache
	 */
	public static void addCache(Cache cache) {
		if (!manager.cacheExists(cache.getName())) {
			manager.addCache(cache);
		}
	}

	public static Cache getCache(String cacheName) {
		Cache cache = manager.getCache(cacheName);
		if (cache == null) {
			cache = EHCacheManager.getInstanceDefaultCache(cacheName);
			addCache(cache);
		}
		return cache;
	}

	public static Cache getInstanceDefaultCache(String cacheName) {
		String name = cacheName;
		int maxElementsInMemory = Integer.MAX_VALUE;
		MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = MemoryStoreEvictionPolicy.LRU;
		boolean overflowToDisk = false;
		String diskStorePath = "";
		boolean eternal = true;
		int timeToLiveSeconds = Integer.MAX_VALUE;
		int timeToIdleSeconds = Integer.MAX_VALUE;
		Cache cache = new Cache(name, maxElementsInMemory, overflowToDisk,
				eternal, timeToLiveSeconds, timeToIdleSeconds);
		return cache;
	}

	public static void removeAllCache() {
			manager.removalAll();
		
	}
	public static void removeCache(String cacheName) {
		if(manager.cacheExists(cacheName)){
			manager.removeCache(cacheName);
		}
		
	}

}
