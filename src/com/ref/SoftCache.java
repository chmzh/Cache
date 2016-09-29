package com.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SoftCache<V extends Cacheable> {
	//缓存
	private ConcurrentMap<Object, Entry> cache;
	//引用队列
	private ReferenceQueue<V> queue;
	
	
	
	public SoftCache(){
		cache = new ConcurrentHashMap<>();
		queue = new ReferenceQueue<>();
	}
	
	private class Entry extends SoftReference<V>{
		private String id;
		public Entry(V referent) {
			super(referent, queue);
			this.id=referent.getCacheKey();
		}
		public String getId() {
			return id;
		}		
	}
	
	public void add(V ref){
		Entry entry = new Entry(ref);
		cache.putIfAbsent(ref.getCacheKey(), entry);
	}
	
	
	private void cleanCache() {
		Entry entry = null;
		while ((entry = (Entry)queue.poll())!=null) {
			cache.remove(entry.getId());
		}

	}
}
