package com.jenkins.plugins.rally.scm;

import hudson.model.AbstractBuild;
import hudson.model.Api;
import hudson.scm.ChangeLogSet;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

@ExportedBean
public class Changes {
    
    private List<ChangeInformation> changeInformation = new LinkedList<ChangeInformation>();

    private final AbstractBuild build;

    public Changes(AbstractBuild build, int buildNumber) {
        this.build = build; 
        AbstractBuild b = build;
        while (b != null && b.getNumber() >= buildNumber) {
            populateChangeInformation(b, b.getChangeSet());
            b = (AbstractBuild) b.getPreviousBuild();
        }
    }
    
    public Changes(AbstractBuild build, int startBuildNumber, int endBuildNumber) {
        this.build = build;
        AbstractBuild b = build;
        while (b != null && b.getNumber() >= startBuildNumber && b.getNumber() <= endBuildNumber) {
            populateChangeInformation(b, b.getChangeSet());
            b = (AbstractBuild) b.getNextBuild();            
        }
    }
    
    private void populateChangeInformation(AbstractBuild build, ChangeLogSet changeLogSet) {
    	ChangeInformation ci = new ChangeInformation();
    	ci.setBuildNumber(String.valueOf(build.getNumber()));
    	ci.setBuildTimeStamp(build.getTimestampString2());
    	ci.setChangeLogSet(changeLogSet);
    	ci.setBuild(build);
    	changeInformation.add(ci);
    }

    /**
     * Remote API access.
     */
    public final Api getApi() {
        return new Api(this);
    }

    public AbstractBuild getBuild() {
        return build;
    }

    @Exported
    public List<ChangeInformation> getChangeInformation() {
        return changeInformation;
    }
}
