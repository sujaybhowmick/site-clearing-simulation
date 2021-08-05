package com.sujay.simulator;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.Orientation;
import com.sujay.simulator.sitemap.SiteMap;

public class BullDozer {
    private final SiteMap siteMap;
    private Coordinate currentPosition = new Coordinate(0, 0);
    private Orientation orientation = Orientation.EAST;

    public BullDozer(SiteMap siteMap) {
        this.siteMap = siteMap;
    }

    public void advance(Command command) {
        command.execute();
    }

    public void turnLeft(Command command){
        command.execute();
    }

    public void turnRight(Command command) {
        command.execute();
    }

    public Coordinate getCurrentPosition() {
        return currentPosition;
    }

    public SiteMap getSiteMap() {
        return siteMap;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void updateCurrentPosition(Coordinate currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void updateOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
