package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.jhotdraw.draw.stages.GivenDrawingCanvas;
import org.jhotdraw.draw.stages.ThenDrawingState;
import org.jhotdraw.draw.tool.stages.WhenUserActs;
import org.junit.Before;

public class TextToolScenarioTest  extends ScenarioTest<GivenDrawingCanvas, WhenUserActs, ThenDrawingState> {
    
    private FrameFixture window;
    private Robot robot;
    
    @Before
    public void setup() {
        
        robot = BasicRobot.robotWithNewAwtHierarchy();
        GuiActionRunner.execute(() -> org.jhotdraw.samples.svg.Main.main(new String[]{}));
        
    }
    
}
