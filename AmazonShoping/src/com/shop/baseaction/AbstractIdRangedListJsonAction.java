package com.shop.baseaction;

@SuppressWarnings("serial")
public abstract class AbstractIdRangedListJsonAction extends AbstractRangedListJsonAction
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
