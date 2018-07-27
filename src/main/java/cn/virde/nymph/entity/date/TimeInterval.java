package cn.virde.nymph.entity.date;
//package com.huamer.spider.pojo.other;

import java.util.Date;

import org.bson.Document;

import cn.virde.nymph.Nym;

/**
 * 
 * @author Virde
 * @time 2018年1月25日 下午5:50:03
 */
public class TimeInterval {
	
	private Date startDate;
	private Date endDate;
	private long start;
	private long end ;
	
	public TimeInterval() {
		super();
	}
	public TimeInterval(Date startDate, Date endDate) {
		this.startDate = startDate ;
		this.endDate = endDate ;
		this.start = startDate.getTime() ;
		this.end  = endDate.getTime() ;
	}
	public TimeInterval(long start , long end ) {
		this.startDate = Nym.time.toDate(start);
		this.endDate = Nym.time.toDate(end);
		this.start = start ;
		this.end  = end ;
	}
	
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getUnixStart() {
		return startDate.getTime() / 1000 ;
	}
	public long getUnixEnd() {
		return endDate.getTime() / 1000 ;
	}
	/**
	 * 制造查询条件
	 * @author Virde
	 * @time 2018年1月18日 下午4:28:33
	 * @param time
	 * @return
	 */
	public Document makeQuery() {
		Document condition = new Document();
		Document query = new Document();
		
		if(start != 0) condition.put("$gte", getUnixStart());
		if(end != 0) condition.put("$lte", getUnixEnd());
		
		if(condition.size() > 0 ) {
			query.append("payTime", condition);
		}
		return query;
	}
	public boolean isNull() {
		return start == 0 && end == 0 ;
	}
}
