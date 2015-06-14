package com.ns.spring.exception;

public class NSException extends Exception {

	private static final long serialVersionUID = -1L;

	String messageId = null;
	Object[] params = null;
	int recourdCount = 0;

	public NSException(String messageId, Object... params) {
		super(messageId);
		this.messageId = messageId;
		this.params = params;
	}

	public NSException(int recourdCount, String messageId, Object... params) {
		super(messageId);
		this.recourdCount = recourdCount;
		this.messageId = messageId;
		this.params = params;
	}

	public NSException(String message) {
		super(message);
	}

	public NSException(Throwable cause) {
		super(cause);
	}

	public NSException(String message, Throwable cause) {
		super(message, cause);
	}

	public NSException(int recourdCount, String message) {
		super(message);
		this.recourdCount = recourdCount;
	}

	public NSException(int recourdCount, Throwable cause) {
		super(cause);
		this.recourdCount = recourdCount;
	}

	public String getMessageId() {
		return messageId;
	}

	public Object[] getParameters() {
		return params;
	}

	public int getRecordCount() {
		return recourdCount;
	}

	public void setRecordCount(int recourdCount) {
		this.recourdCount = recourdCount;
	}
}
