package com.esad.smartsl.dto.responseDto;

import java.io.Serializable;
import java.util.ArrayList;

import com.esad.smartsl.enums.ResponseMessage;

public class ResponseDto<T> extends BaseResponseDto implements Serializable {

	private static final long serialVersionUID = 5307281814713978611L;

	private ArrayList<T> lists;
	private T object;
	private ResponseMessage message;

	public ArrayList<T> getLists() {
		return lists;
	}

	public void setLists(ArrayList<T> lists) {
		this.lists = lists;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public ResponseMessage getMessage() {
		return message;
	}

	public void setMessage(ResponseMessage message) {
		this.message = message;
	}

}
