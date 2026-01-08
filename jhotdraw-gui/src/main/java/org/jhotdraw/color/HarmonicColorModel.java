/**
 * @(#)HarmonicColorModel.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.beans.PropertyChangeListener;
import javax.swing.ListModel;

/**
 * HarmonicColorModel.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public interface HarmonicColorModel extends ListModel {

    String COLOR_SPACE_PROPERTY = "colorSpace";

    void setBase(int newValue);

    int getBase();

    void addRule(HarmonicRule rule);

    void removeAllRules();

    void applyRules();

    ColorSpace getColorSpace();

    void setColorSpace(ColorSpace newValue);

    void setSize(int newValue);

    int size();

    boolean isAdjusting();

    boolean add(Color c);

    void set(int index, Color color);

    Color get(int index);

    float[] RGBtoComponent(int rgb, float[] hsb);

    int componentToRGB(float h, float s, float b);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
