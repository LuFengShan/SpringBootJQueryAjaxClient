package com.javasampleapproach.jqueryajax.message;

/**
 * 状态
 */
public enum ResultStatus {
	/** 请求成功  */
	SUCCESS(1),
	/** 请求失败  */
	FAIL(-1),
	/** 未登录  */
	NOLOG(0),
	/** 其它未知原因  */
	NO_PERMISSION(2);

	private int status;

	ResultStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
