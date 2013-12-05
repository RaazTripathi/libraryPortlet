/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.service.service.ClpSerializer;
import com.service.service.LMSBookLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laitkor
 */
public class LMSBookClp extends BaseModelImpl<LMSBook> implements LMSBook {
	public LMSBookClp() {
	}

	public Class<?> getModelClass() {
		return LMSBook.class;
	}

	public String getModelClassName() {
		return LMSBook.class.getName();
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bookId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("bookTitle", getBookTitle());
		attributes.put("author", getAuthor());
		attributes.put("dateAdded", getDateAdded());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String bookTitle = (String)attributes.get("bookTitle");

		if (bookTitle != null) {
			setBookTitle(bookTitle);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;

		if (_lmsBookRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBookRemoteModel.getClass();

				Method method = clazz.getMethod("setBookId", long.class);

				method.invoke(_lmsBookRemoteModel, bookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBookTitle() {
		return _bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		_bookTitle = bookTitle;

		if (_lmsBookRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBookRemoteModel.getClass();

				Method method = clazz.getMethod("setBookTitle", String.class);

				method.invoke(_lmsBookRemoteModel, bookTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;

		if (_lmsBookRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBookRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_lmsBookRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;

		if (_lmsBookRemoteModel != null) {
			try {
				Class<?> clazz = _lmsBookRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_lmsBookRemoteModel, dateAdded);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLMSBookRemoteModel() {
		return _lmsBookRemoteModel;
	}

	public void setLMSBookRemoteModel(BaseModel<?> lmsBookRemoteModel) {
		_lmsBookRemoteModel = lmsBookRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _lmsBookRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_lmsBookRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSBookLocalServiceUtil.addLMSBook(this);
		}
		else {
			LMSBookLocalServiceUtil.updateLMSBook(this);
		}
	}

	@Override
	public LMSBook toEscapedModel() {
		return (LMSBook)ProxyUtil.newProxyInstance(LMSBook.class.getClassLoader(),
			new Class[] { LMSBook.class }, new AutoEscapeBeanHandler(this));
	}

	public LMSBook toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		LMSBookClp clone = new LMSBookClp();

		clone.setBookId(getBookId());
		clone.setBookTitle(getBookTitle());
		clone.setAuthor(getAuthor());
		clone.setDateAdded(getDateAdded());

		return clone;
	}

	public int compareTo(LMSBook lmsBook) {
		long primaryKey = lmsBook.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LMSBookClp)) {
			return false;
		}

		LMSBookClp lmsBook = (LMSBookClp)obj;

		long primaryKey = lmsBook.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{bookId=");
		sb.append(getBookId());
		sb.append(", bookTitle=");
		sb.append(getBookTitle());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.service.model.LMSBook");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookTitle</column-name><column-value><![CDATA[");
		sb.append(getBookTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookId;
	private String _bookTitle;
	private String _author;
	private Date _dateAdded;
	private BaseModel<?> _lmsBookRemoteModel;
}