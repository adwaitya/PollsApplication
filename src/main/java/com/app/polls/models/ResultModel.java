package com.app.polls.models;

import com.app.polls.exception.ErrorHolder;
import com.app.polls.models.ResultModel;

public class ResultModel<T> {
	private T obj;
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	private ErrorHolder errorHolder;
	private Boolean isError;
	 public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public static <T> ResultModel<T> Create(T obj) {
	        ResultModel<T> result = new ResultModel<>();
	        result.obj = obj;
	        result.errorHolder = null;
	        result.isError = false;
	        return result;
	    }

	    public ErrorHolder getErrorHolder() {
		return errorHolder;
	}

	public void setErrorHolder(ErrorHolder errorHolder) {
		this.errorHolder = errorHolder;
	}

		public static <T> ResultModel<T> CreateErrorObj(ErrorHolder errorHolder) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = errorHolder;
	        result.isError = true;
	        return result;
	    }

	    public static <T> ResultModel<T> CreateErrorObj(Exception ex) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = new ErrorHolder(ex);
	        result.isError = true;
	        return result;
	    }


	    public static <T> ResultModel<T> CreateErrorObj(String externalMessage) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = new ErrorHolder(externalMessage, externalMessage);
	        result.isError = true;
	        return result;
	    }

	    public static <T> ResultModel<T> CreateErrorObj(String externalMessage, String internalMessage) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = new ErrorHolder(externalMessage, internalMessage);
	        result.isError = true;
	        return result;
	    }

	    public static <T> ResultModel<T> CreateErrorObj(String externalMessage, String internalMessage, Exception exception) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = new ErrorHolder(externalMessage, internalMessage, exception);
	        result.isError = true;
	        return result;
	    }

	    public static <T> ResultModel<T> CreateErrorObj(String externalMessage, Exception exception) {
	        ResultModel<T> result = new ResultModel<>();
	        result.errorHolder = new ErrorHolder(externalMessage, exception);
	        result.isError = true;
	        return result;
	    }
}
