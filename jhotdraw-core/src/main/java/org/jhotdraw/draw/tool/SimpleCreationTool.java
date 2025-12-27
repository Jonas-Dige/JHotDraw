package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.figure.Figure;

import java.awt.event.MouseEvent;
import java.util.Map;

public class SimpleCreationTool extends AbstractCreationTool {

    public SimpleCreationTool(Figure prototype) {
        super(prototype);
    }

    public SimpleCreationTool(Figure prototype, Map<AttributeKey<?>, Object> attributes, String name) {
        super(prototype, attributes, name);
    }

    public SimpleCreationTool(Figure prototype, Map<AttributeKey<?>, Object> attributes) {
        super(prototype, attributes);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        super.mouseReleased(event);
        if (getCreatedFigure() != null) {
            creationFinished(getCreatedFigure());
        }
        if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }
}
