/*
 * @(#)ActivityModel.java  1.3  2011-05-01
 *
 * Copyright (c) 2011 The authors and contributors of JHotDraw.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.api.gui;

import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
 * Describes the progress of a activity. An activity is typically
 * a long running background task which has been directly initiated or
 * scheduled by the user.
 * <p>
 * Every progress model should add itself to the {@link ActivityManager}
 * after it has been created.
 * </p>
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p>
 * <em>Framework</em><br>
 * The interfaces and classes listed below define a framework for progress
 * management.<br>
 * Contract: {@link ActivityManager}, {@link ActivityModel},
 * {@link JActivityWindow}, {@link JActivityIndicator}.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public interface ActivityModel extends BoundedRangeModel {

    String INDETERMINATE_PROPERTY = "indeterminate";
    String NOTE_PROPERTY = "note";
    String WARNING_PROPERTY = "warning";
    String ERROR_PROPERTY = "error";
    String CANCELABLE_PROPERTY = "cancelable";
    String CANCELED_PROPERTY = "canceled";
    String CLOSED_PROPERTY = "closed";

    /**
     * Gets the owner of the progress model. This is typically a {@link org.jhotdraw.api.app.View}
     * or a {@link org.jhotdraw.api.app.Application}.
     */
    Object getOwner();

    /**
     * Set cancelable to false if the operation can not be canceled.
     */
    void setCancelable(boolean b);

    /**
     * Returns true if the operation can be canceled.
     */
    boolean isCancelable();

    /**
     * The specified Runnable is executed when the user presses
     * the cancel button.
     */
    void setDoCancel(Runnable doCancel);

    /**
     * Sets the progress observer to indeterminate.
     */
    void setIndeterminate(boolean newValue);

    /**
     * Returns true if the progress observer is set to indeterminate.
     */
    boolean isIndeterminate();

    /**
     * Indicate that the operation is closed.
     * If the progress model added itself to the {@code ActivityManager}
     * it MUST remove itself now.
     */
    void close();

    /**
     * Returns true if the operation is completed.
     */
    boolean isClosed();

    /**
     * Cancels the operation.
     * This method must be invoked from the user event dispatch thread.
     */
    void cancel();

    /**
     * Returns true if the user has hit the Cancel button in the progress dialog.
     */
    boolean isCanceled();

    /**
     * Specifies the additional note that is displayed along with the
     * progress message. Used, for example, to show which file
     * is currently being copied during a multiple-file copy.
     * <p>
     * Only set a note if you have something important to tell.
     * Setting a note is a time consuming operation because the GUI components
     * ensure that the note is displayed on the screen before they let the
     * activity model continue.
     *
     * @param note a String specifying the note to display
     * @see #getNote
     */
    void setNote(String note);

    /**
     * Sets a formatted note.
     * <p>
     * Only set a note if you have something important to tell.
     * Setting a note is a time consuming operation because the GUI components
     * ensure that the note is displayed on the screen before they let the
     * activity model continue.
     */
    void printf(String format, Object... args);

    /**
     * Specifies the additional note that is displayed along with the
     * progress message.
     *
     * @return a String specifying the note to display
     * @see #setNote
     */
    String getNote();

    /**
     * Specifies the additional warning message that is displayed along with the
     * progress message. Used, for example, to show which files couldn't
     * be copied during a multiple-file copy.
     *
     * @param message a String specifying the message to display, or null
     * if there is no warning.
     * @see #getWarning
     */
    void setWarning(String message);

    /**
     * Specifies the warning message that is displayed along with the
     * progress message.
     *
     * @return a String specifying the message to display, or null if
     * there is no warning.
     */
    String getWarning();

    /**
     * Specifies the additional error message that is displayed along with the
     * progress message. Used, for example, to show which files couldn't
     * be copied during a multiple-file copy..
     *
     * @param message a String specifying the message to display, or null
     * if there is no error.
     * @see #getWarning
     */
    void setError(String message);

    /**
     * Specifies the error message that is displayed along with the
     * progress message.
     *
     * @return a String specifying the message to display, or null if
     * there is no error.
     */
    String getError();

    /**
     * Adds a property change listener.
     */
    void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * Removes a property change listener.
     */
    void removePropertyChangeListener(PropertyChangeListener listener);

    /**
     * Returns the title of the progress model.
     */
    String getTitle();
}
