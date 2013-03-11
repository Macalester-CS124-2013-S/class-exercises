package edu.macalester.cs124;

import acm.graphics.GScalable;

public class Pulser {
    private double t = 0, prevScale = 1, speed;
    private GScalable objectToPulse;
    
    public Pulser(GScalable objectToPulse, double speed) {
        this.objectToPulse = objectToPulse;
        this.speed = speed;
    }
    
    public void animate() {
        double newScale = Math.sin(t) * 0.8 + 1;
        objectToPulse.scale(newScale / prevScale);
        prevScale = newScale;
        
        t += speed;
        
        // Prevent floating point overflow:
        if(t > Math.PI * 2)
            t -= Math.PI * 2;
    }
}
