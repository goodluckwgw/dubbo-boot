package com.github.bootapi.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class IceResponse<T>
{

	@XmlElement
    private T result;

	@XmlElement
	private String code;

    public IceResponse()
    {
        super();
    }

    public IceResponse(T result, String code)
    {
        super();
        this.result = result;
        this.code = code;
    }

    public Object getResult()
    {
		return result;
	}

    public void setResult(T result)
    {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
