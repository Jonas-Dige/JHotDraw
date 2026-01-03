package org.jhotdraw.draw.tool.stages;

import org.assertj.swing.core.MouseClickInfo;
import org.jhotdraw.draw.stages.JHotDrawStage;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.KeyEvent;

import static org.assertj.swing.core.KeyPressInfo.keyCode;

public class WhenUserActs extends JHotDrawStage<WhenUserActs> {

    public WhenUserActs the_user_clicks_on_the_canvas_at(int x, int y) {
        JPanel canvas = window.panel("drawingCanvas").target();
        window.robot().click(canvas, new Point(x,y));
        return self();
    }

    public WhenUserActs the_user_types(String text) {
        window.robot().enterText(text);
        return self();
    }

    public WhenUserActs the_user_presses_the_escape_key() {
        window.pressAndReleaseKey(keyCode(KeyEvent.VK_ESCAPE));
        return self();
    }

    public WhenUserActs the_user_clears_the_text_and_deselects() {
        window.robot().pressAndReleaseKey(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        window.robot().pressAndReleaseKey(KeyEvent.VK_BACK_SPACE);
        JPanel canvas = window.panel("drawingCanvas").target();
        window.robot().click(canvas, new Point(0,0));
        return self();
    }

    public WhenUserActs the_user_finishes_editing() {
        JPanel canvas = window.panel("drawingCanvas").target();
        window.robot().click(canvas, new Point(1,1));
        return self();
    }

}
