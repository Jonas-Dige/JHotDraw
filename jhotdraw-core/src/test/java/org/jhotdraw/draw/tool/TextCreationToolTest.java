package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.TextHolderFigure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockMakers;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TextCreationToolTest {
    private TextCreationTool tool;
    private DrawingEditor editor;
    private TextHolderFigure figure;
    DrawingView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        // Mockito cannot mock this under JDK 25 for whatever reason without this.
        figure = mock(TextHolderFigure.class, withSettings().mockMaker(MockMakers.SUBCLASS));
        tool = new TextCreationTool(figure);
        view = mock(DrawingView.class, withSettings().mockMaker(MockMakers.SUBCLASS));
        editor = mock(DrawingEditor.class);
        when(editor.getActiveView()).thenReturn(view);
    }

    @Test
    public void testImplementsNecessaryContracts() {
        // If this is not true, something has gone terribly wrong.
        assertTrue(tool instanceof MouseListener);
        assertTrue(tool instanceof KeyListener);
        assertFalse(tool instanceof MouseMotionListener);
    }

    @Test
    public void testHandleMouseClicks() {
        tool.activate(editor);

        MouseEvent event = mock(MouseEvent.class, withSettings().mockMaker(MockMakers.SUBCLASS));

        tool.mouseClicked(event);

        verify(editor, atLeastOnce()).getActiveView();
    }

    @Test
    public void testCreatesNewInstanceEachTime() {
        tool.activate(editor);
        MouseEvent click1 = new MouseEvent(realView, MouseEvent.MOUSE_CLICKED, ...);
        tool.mouseClicked(click1);

        Figure firstFigure = realDrawing.getChild(0);
        assertNotSame("The created figure should be a clone, not the prototype", figure, firstFigure);
    }

    @After
    public void tearDown() throws Exception {
    }
}