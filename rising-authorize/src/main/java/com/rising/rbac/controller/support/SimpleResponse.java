/**
 *
 */
package com.rising.rbac.controller.support;

/**
 * @author 李启云
 *
 */
public class SimpleResponse {

	public SimpleResponse(Object content){
		this.content = content;
	}

	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
