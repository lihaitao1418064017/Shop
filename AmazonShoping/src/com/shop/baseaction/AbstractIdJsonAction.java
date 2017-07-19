package com.shop.baseaction;

@SuppressWarnings("serial")
public abstract class AbstractIdJsonAction extends AbstractJsonAction
{
	protected int id;

	public int getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = (int)id;
	}
	
	
}
