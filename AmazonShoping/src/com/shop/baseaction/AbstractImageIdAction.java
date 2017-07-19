package com.shop.baseaction;

import java.io.ByteArrayInputStream;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class AbstractImageIdAction extends ActionSupport
{
	// 图片id
	protected String id;
	// 图片流
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

	// 创建无效图片输入流
	protected ByteArrayInputStream createInvalidStream()
	{
		// 加载无效图片输入流
		// byte[]
		// data=(byte[])ActionContext.getContext().getApplication().get("invalidimage");
		byte[] data = new byte[0];
		System.out.println("无效图片！" + data.length);
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
