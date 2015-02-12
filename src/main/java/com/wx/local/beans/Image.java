package com.wx.local.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "mediaId" })
@XmlRootElement(name = "Image")
@Data
public class Image {

	@XmlElement(name = "MediaId", required = true)
	protected String mediaId;
}
