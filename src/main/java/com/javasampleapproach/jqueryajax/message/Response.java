package com.javasampleapproach.jqueryajax.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应消息
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 数据
	 */
	private Object data;
}
