package com.epam.logicClasses;

public abstract class AbstractLogicStaff implements LogicStaff{
	protected String result;
	protected boolean status;
	
	@Override
	public String getPerformedWorkStatus() {
		if (status)
			return "successful";
		else
			return "NOT successful";
	}
}
