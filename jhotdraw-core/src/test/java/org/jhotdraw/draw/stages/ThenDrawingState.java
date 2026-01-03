package org.jhotdraw.draw.stages;


import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.TextFigure;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenDrawingState extends JHotDrawStage<ThenDrawingState> {

    public ThenDrawingState a_new_text_figure_should_exist() {
        Drawing drawing = drawingView.getDrawing();
        assertThat(drawing.getChildCount())
                .as("Check that at least one figure exists on the canvas")
                .isGreaterThan(0);
        return self();
    }

    public ThenDrawingState the_figure_at_index_should_have_text(int index, String expectedText) {
        TextFigure figure = (TextFigure) drawingView.getDrawing().getChild(index);

        assertThat(figure.getText())
                .as("Verify content of figure")
                .isEqualTo(expectedText);
        return self();
    }

    public ThenDrawingState the_canvas_should_be_empty() {
        assertThat(drawingView.getDrawing().getChildCount())
                .as("Check that no figures exist")
                .isEqualTo(0);
        return self();
    }

    public ThenDrawingState the_figure_should_be_selected() {
        List<Figure> figures = new ArrayList<>(drawingView.getDrawing().getChildren());
        Figure newestFigure = figures.get(figures.size() - 1);

        assertThat(drawingView.getSelectedFigures())
                .as("Check that there's only a text figure selected")
                .hasSize(1)
                .allMatch(f -> f instanceof TextFigure, "Should be a TextFigure");

        return self();
    }


}
