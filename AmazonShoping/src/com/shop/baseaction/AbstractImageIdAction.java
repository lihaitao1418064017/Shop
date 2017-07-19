package com.shop.baseaction;

import java.io.ByteArrayInputStream;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class AbstractImageIdAction extends ActionSupport
{
	// ͼƬid
	protected String id;
	// ͼƬ��
	private ByteArrayInputStream imageStream;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public ByteArrayInputStream getImageStream()
	{
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream)
	{
		this.imageStream = imageStream;
	}

	protected abstract ByteArrayInputStream createStream();

	// ������ЧͼƬ������
	protected ByteArrayInputStream createInvalidStream()
	{
		// ������ЧͼƬ������
		// byte[]
		// data=(byte[])ActionContext.getContext().getApplication().get("invalidimage");
		byte[] data = new byte[0];
		System.out.println("��ЧͼƬ��" + data.length);
		return new ByteArrayInputStream(data);
	}

	@Override
	public String execute() throws Exception
	{
		try
		{
			imageStream = createStream();
			return "image";
		} catch (Exception e)
		{
			imageStream = createInvalidStream();
			return "image";
		}

	}
}
