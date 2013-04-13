package com.jenkins.plugins.rally.scm;

import hudson.model.AbstractBuild;
import hudson.scm.ChangeLogSet;

import java.util.LinkedList;
import java.util.List;

public class ChangeInformation {

	private String buildTimeStamp;
	private String buildNumber;
	private ChangeLogSet changeLogSet;
	private AbstractBuild build;
	
	public String getBuildTimeStamp() {
		return buildTimeStamp;
	}
	public void setBuildTimeStamp(String buildTimeStamp) {
		this.buildTimeStamp = buildTimeStamp;
	}
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	public ChangeLogSet getChangeLogSet() {
		return changeLogSet;
	}
	public void setChangeLogSet(ChangeLogSet changeLogSet) {
		this.changeLogSet = changeLogSet;
	}
	public AbstractBuild getBuild() {
		return build;
	}
	public void setBuild(AbstractBuild build) {
		this.build = build;
	}	
		
}
