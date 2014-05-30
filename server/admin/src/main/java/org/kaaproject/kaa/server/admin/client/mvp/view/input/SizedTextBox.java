/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.admin.client.mvp.view.input;

import static org.kaaproject.kaa.server.admin.shared.util.Utils.isEmpty;

import org.kaaproject.kaa.server.admin.client.mvp.event.input.HasInputEventHandlers;
import org.kaaproject.kaa.server.admin.client.mvp.event.input.InputEvent;
import org.kaaproject.kaa.server.admin.client.mvp.event.input.InputEventHandler;
import org.kaaproject.kaa.server.admin.client.util.Utils;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SizedTextBox extends VerticalPanel implements HasValue<String>, HasInputEventHandlers {

    private ExtendedTextBox text;
    private HTML textLabel;
    private Label charactersLabel;
    private final int maxChars;
    private final boolean editable;

    public SizedTextBox(int maxChars) {
        this(maxChars, true, true);
    }
    public SizedTextBox(int maxChars, boolean editable) {
        this(maxChars, editable, true);
    }

    public SizedTextBox(int maxChars, boolean editable, boolean addNotes) {
        this.maxChars = maxChars;
        this.editable = editable;
        if (editable) {
            text = new ExtendedTextBox();
            add(text);
        }
        else {
            textLabel = new HTML("&nbsp;");
            textLabel.setHeight("100%");
            textLabel.setStyleName("secondary");
            add(textLabel);
        }
        if (editable && maxChars > -1) {
            charactersLabel = new Label();
            charactersLabel.setStyleName("b-app-field-notes");
            text.setMaxLength(maxChars);
            add(charactersLabel);
            updateCharactersLabel();
        }
        else if (addNotes) {
            add(new HTML("&nbsp;"));
        }
        addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                fireInputEvent();
            }
        });
        if (editable) {
            text.addKeyUpHandler(new KeyUpHandler() {
                @Override
                public void onKeyUp(KeyUpEvent  event) {
                    updateCharactersLabel();
                    fireInputEvent();
                }
            });
        }
    }

    private void updateCharactersLabel() {
        if (editable && maxChars > -1) {
            int currentLength = text.getText().length();
            charactersLabel.setText(Utils.messages.charactersLength(currentLength, maxChars));
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(
            ValueChangeHandler<String> handler) {
        if (editable) {
            return text.addValueChangeHandler(handler);
        }
        else {
            return null;
        }
    }

    @Override
    public String getValue() {
        if (editable) {
            return text.getValue();
        }
        else {
            if (textLabel.getHTML().equals("&nbsp;")) {
                return "";
            }
            else {
                return textLabel.getText();
            }
        }
    }

    @Override
    public void setValue(String value) {
        if (editable) {
            text.setValue(value);
        }
        else {
            if (isEmpty(value)) {
                textLabel.setHTML("&nbsp;");
            }
            else {
                textLabel.setText(value);
            }
        }
        updateCharactersLabel();
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        if (editable) {
            text.setValue(value, fireEvents);
        }
        else {
            textLabel.setText(value);
        }
    }

    public void setFocus(boolean focused) {
        if (editable) {
            text.setFocus(focused);
        }
    }

    public void setWidth(String width) {
        super.setWidth(width);
        if (editable) {
            text.setWidth(width);
        }
        else {
            textLabel.setWidth(width);
        }
    }

    public void setHeight(String height) {
        super.setHeight(height);
        if (editable) {
            text.setHeight(height);
        }
        else {
            textLabel.setHeight(height);
        }
    }

    public void setEnabled(boolean enabled) {
        if (editable) {
            text.setEnabled(enabled);
        }
    }

    public void setReadOnly(boolean readOnly) {
        if (editable) {
            text.setReadOnly(readOnly);
        }
    }

    private class ExtendedTextBox extends TextBox {

        public ExtendedTextBox() {
            super();
            sinkEvents(Event.ONPASTE);
        }

        @Override
        public void onBrowserEvent(Event event) {
            super.onBrowserEvent(event);
            switch (DOM.eventGetType(event)) {
                case Event.ONPASTE:
                    Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                        @Override
                        public void execute() {
                            ValueChangeEvent.fire(ExtendedTextBox.this, getText());
                        }
                    });
                    break;
            }
        }
    }

    private void fireInputEvent() {
        InputEvent event = new InputEvent(this);
        fireEvent(event);
    }

    @Override
    public HandlerRegistration addInputHandler(InputEventHandler handler) {
        return this.addHandler(handler, InputEvent.TYPE);
    }
}
