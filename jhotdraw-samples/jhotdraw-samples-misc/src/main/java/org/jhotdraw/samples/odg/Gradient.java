/*
 * @(#)Gradient.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.odg;

import org.jhotdraw.draw.figure.Figure;
import java.awt.*;
import java.awt.geom.AffineTransform;
import org.jhotdraw.draw.*;

/**
 * Represents an SVG Gradient.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public interface Gradient extends Cloneable {

    Paint getPaint(Figure f, double opacity);

    boolean isRelativeToFigureBounds();

    void transform(AffineTransform tx);

    Object clone();

    void makeRelativeToFigureBounds(Figure f);
}
