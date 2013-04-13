package com.jenkins.plugins.rally.connector;

public enum RallyAttributes {
	
	TaskIndex("TI:", "TI :", "TI:", "TI :"),
	TaskID("TID:", "TID :", "TId:", "TId :"),
	ToDo("TODO:", "TODO :", "TODO:", "TODO :"),
	Actuals("ACTUALS:", "ACTUALS :", "ACTUAL:", "ACTUAL :"),
	Estimates("ESTIMATES:", "ESTIMATES :", "ESTIMATE:", "ESTIMATE :"),
	Status("STATUS:", "STATUS :", "STATUS:", "STATUS :");
	
	private final String type1;
	private final String type2;
	private final String type3;
	private final String type4;
	
	RallyAttributes(String type1, String type2, String type3, String type4) {
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public String getType3() {
		return type3;
	}

	public String getType4() {
		return type4;
	}
	
}
