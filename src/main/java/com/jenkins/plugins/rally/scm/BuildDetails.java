package com.jenkins.plugins.rally.scm;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import hudson.model.Result;
import hudson.model.AbstractBuild;
import hudson.model.Run;

public class BuildDetails {
	
	public static Changes getChangesSinceLastSuccessfulBuild(AbstractBuild build) {
        Run run = build.getPreviousBuild();
        while (run != null && (run.getResult() == null || run.getResult().isWorseThan(Result.SUCCESS)))
            run = run.getPreviousBuild();
        
        return new Changes(build, run != null ? run.getNumber() + 1 : build.getNumber());
    }
	
	public static Changes getChangesSinceLastBuild(AbstractBuild build) {
        Run run = build.getPreviousBuild();
        return new Changes(build, run != null ? run.getNumber() + 1 : build.getNumber());
    }
	
	public static Changes getSince(String startDate, String endDate, AbstractBuild build) throws ParseException {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").parse(startDate));        
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").parse(endDate));
        Run r = build;
        Run startBuild = build;
        int startBuildNumber = Integer.MAX_VALUE;        
        while (r != null && r.getTimestamp().getTimeInMillis() >= startCal.getTimeInMillis()) {
        	startBuildNumber = r.getNumber();
        	startBuild = r;
            r = r.getPreviousBuild();
        }
        
       	r = startBuild;
        
        int endBuildNumber = Integer.MAX_VALUE;
        while (r != null && r.getTimestamp().getTimeInMillis() <= endCal.getTimeInMillis()) {
        	endBuildNumber = r.getNumber();
            r = r.getNextBuild();
        }
        
        return new Changes((AbstractBuild)startBuild, startBuildNumber, endBuildNumber);
    }
}
