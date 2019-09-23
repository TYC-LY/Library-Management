package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class BaseEntity {

	// 每个实体都的id和创建时间
	private long id;
	private String createTime;

	// 初始化实体
	public BaseEntity(long id) {
		this.id = id;
		SimpleDateFormat bjsdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		this.setCreateTime(bjsdf.format(new Date()));
	}

	// id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// createTIme
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}