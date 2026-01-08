/**
 * @(#)HarmonicRule.java
 *
 * Copyright (c) 2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.Color;

/**
 * HarmonicRule.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public interface HarmonicRule {

    void setBaseIndex();

    int getBaseIndex();

    void setDerivedIndices(int... indices);

    int[] getDerivedIndices();

    void apply(HarmonicColorModel model);

    void colorChanged(HarmonicColorModel model, int index, Color oldValue, Color newValue);
}
