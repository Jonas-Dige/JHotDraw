package org.jhotdraw.undo;

import org.junit.jupiter.api.Test;
import javax.swing.Action;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UndoRedoManagerTest {

    @Test
    void constructor_initializesActions() {
        UndoRedoManager mgr = new UndoRedoManager();

        Action undo = mgr.getUndoAction();
        Action redo = mgr.getRedoAction();

        assertNotNull(undo, "Undo action should be initialized by constructor via initActions()");
        assertNotNull(redo, "Redo action should be initialized by constructor via initActions()");


        assertFalse(undo.isEnabled(), "Undo action should start disabled");
        assertFalse(redo.isEnabled(), "Redo action should start disabled");


        assertNotNull(undo.getValue(Action.NAME), "Undo action should have a NAME");
        assertNotNull(redo.getValue(Action.NAME), "Redo action should have a NAME");
    }

    @Test
    void deserialization_callsReadObject_andReinitializesTransientActions() throws Exception {
        UndoRedoManager original = new UndoRedoManager();

        byte[] bytes;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(original);
            oos.flush();
            bytes = bos.toByteArray();
        }


        UndoRedoManager restored;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            restored = (UndoRedoManager) ois.readObject();
        }

        assertNotNull(restored.getUndoAction(),
                "Undo action should be re-initialized after deserialization (readObject -> initActions)");
        assertNotNull(restored.getRedoAction(),
                "Redo action should be re-initialized after deserialization (readObject -> initActions)");


        assertFalse(restored.getUndoAction().isEnabled(), "Undo action should be disabled after restore");
        assertFalse(restored.getRedoAction().isEnabled(), "Redo action should be disabled after restore");

        assertNotNull(restored.getUndoAction().getValue(Action.NAME), "Undo action should have a NAME after restore");
        assertNotNull(restored.getRedoAction().getValue(Action.NAME), "Redo action should have a NAME after restore");
    }
}
