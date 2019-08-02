package com.javasampleapproach.jqueryajax.message;

import lombok.Data;

/**
 * 封装统一的接口，返回状态，接口说明及数据
 * <p>状态参考：{@link ResultStatus}</p>
 *
 * @param <T>
 */
@Data
public class ResultBean<T> {
	/**
	 * 接口返回状态
	 */
	private int code = ResultStatus.SUCCESS.getStatus();
	/**
	 * 接口说明
	 */
	private String msg = "此接口没有说明，请提醒开发人员增加说明";
	/**
	 * 接口封装的数据
	 */
	private T data;

	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
	}

	public ResultBean(Throwable e, ResultStatus responseStatus) {
		super();
		this.msg = e.toString();
		this.code = responseStatus.getStatus();
	}
}
