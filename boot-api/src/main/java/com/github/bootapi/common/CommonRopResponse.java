package com.github.bootapi.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 *
 * @author <a href="mailto:gengcai.xie@skyroam.com">Xie Gengcai</a>
 * @version 1.0
 * @date Jan 6, 2015
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class CommonRopResponse {
	@XmlAttribute
	private boolean successful = false;

	public static final CommonRopResponse SUCCESSFUL_RESPONSE = new CommonRopResponse(true);
	public static final CommonRopResponse FAILURE_RESPONSE = new CommonRopResponse(false);

	public CommonRopResponse() {
	}

	private CommonRopResponse(boolean successful) {
		this.successful = successful;
	}

	public boolean isSuccessful() {
		return successful;
	}
}
