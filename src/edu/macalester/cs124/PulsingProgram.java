package edu.macalester.cs124;

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

public class PulsingProgram extends GraphicsProgram {
    public void run() {
        // Simple green oval
        
        GOval oval = new GOval(100, 100, 25, 37);
        oval.setColor(Color.GREEN);
        add(oval);
        
        // Face (guaranteed at least 37% non-creepy!)
        
        GCompound face = new GCompound();
        
        GCompound leftEye = makeEye();
        leftEye.setLocation(5, 5);
        face.add(leftEye);
        
        GCompound rightEye = makeEye();
        rightEye.setLocation(15, 5);
        face.add(rightEye);
        
        GArc smile = new GArc(10, 7, 0, -180);
        smile.setLocation(6.5, 10);
        
        face.add(smile);
        face.scale(10);
        face.setLocation(500, 300);
        add(face);
        
        // Badass ninja star thinger
        
        GPolygon poly = new GPolygon(350, 200);
        poly.setFilled(true);
        poly.setFillColor(Color.YELLOW);
        int sides = 30;
        for(int n = 0; n < sides; n++) {
            double r = 20 * ((n * 7) % 5),
                   theta = Math.PI * 2 * n / sides;
            poly.addVertex(
                Math.cos(theta) * r,
                Math.sin(theta) * r);
        }
        add(poly);
        
        // Now make them pulse!
        
        Pulser ovalPulse     = new Pulser(oval,     0.029),
               polyPulse     = new Pulser(poly,     0.013),
               facePulse     = new Pulser(face,     0.01),
               leftEyePulse  = new Pulser(leftEye,  0.017),
               rightEyePulse = new Pulser(rightEye, 0.019);
        while(true) {
            ovalPulse.animate();
            facePulse.animate();
            polyPulse.animate();
            leftEyePulse.animate();
            rightEyePulse.animate();
            pause(10);
        }
    }
    
    private GCompound makeEye() {
        GOval eyeOutline = new GOval(0, 0, 3, 3);
        
        GOval pupil = new GOval(1, 1, 1, 1);
        pupil.setFillColor(Color.BLUE);
        pupil.setFilled(true);
        
        GOval highlight = new GOval(1.55, 1.1, 0.3, 0.3);
        highlight.setFillColor(Color.WHITE);
        highlight.setFilled(true);
        highlight.setColor(Color.WHITE);
        
        GCompound eye = new GCompound();
        eye.add(eyeOutline);
        eye.add(pupil);
        eye.add(highlight);
        return eye;
    }
}













