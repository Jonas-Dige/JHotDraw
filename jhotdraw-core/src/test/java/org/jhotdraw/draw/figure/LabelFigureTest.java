package org.jhotdraw.draw.figure;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LabelFigureTest {
    private LabelFigure figure;
    private TextHolderFigure mockTarget;

    @Before
    public void setUp() throws Exception {
        figure =  new LabelFigure();
        mockTarget = mock(TextHolderFigure.class);
        figure.setLabelFor(figure);
    }

    @After
    public void tearDown() throws Exception {
    }
}