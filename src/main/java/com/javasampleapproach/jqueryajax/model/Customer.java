package com.javasampleapproach.jqueryajax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消费者
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	/**
	 * 名字
	 */
	private String firstname;
	/**
	 * 姓氏
	 */
	private String lastname;
}