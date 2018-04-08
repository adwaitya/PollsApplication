package com.app.polls.models;

import java.util.List;

import com.app.polls.exception.ErrorHolder;



public class ResultListModel<T> {

	private List<T> obj;
	private long totalCount;
	private ErrorHolder holder;
	private Boolean isError;

	public static <T> ResultListModel<T> Create(List<T> obj) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(obj);
		result.setHolder(null);
		result.setTotalCount(obj.size());
		result.isError = false;
		return result;
	}

	public static <T> ResultListModel<T> Create(List<T> obj, long totalCount) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(obj);
		result.setHolder(null);
		result.setTotalCount(totalCount);
		result.isError = false;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(ErrorHolder errorHolder) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		result.setHolder(errorHolder);
		result.isError = true;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(Exception ex) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		ErrorHolder errorHolder = new ErrorHolder(ex);
		result.setHolder(errorHolder);
		result.isError = true;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(String externalMessage) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		result.setHolder(new ErrorHolder(externalMessage, externalMessage));
		result.isError = true;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(String externalMessage, String internalMessage) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		result.setHolder(new ErrorHolder(externalMessage, internalMessage));
		result.isError = true;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(String externalMessage, String internalMessage,
			Exception exception) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		result.setHolder(new ErrorHolder(externalMessage, internalMessage, exception));
		result.isError = true;
		return result;
	}

	public static <T> ResultListModel<T> CreateErrorObj(String externalMessage, Exception exception) {
		ResultListModel<T> result = new ResultListModel<>();
		result.setObj(null);
		result.setHolder(new ErrorHolder(externalMessage, exception));
		result.isError = true;
		return result;
	}

	public List<T> getObj() {
		return obj;
	}

	public void setObj(List<T> obj) {
		this.obj = obj;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public ErrorHolder getHolder() {
		return holder;
	}

	public void setHolder(ErrorHolder holder) {
		this.holder = holder;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
}

