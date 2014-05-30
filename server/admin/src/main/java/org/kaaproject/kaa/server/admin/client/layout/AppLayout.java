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

package org.kaaproject.kaa.server.admin.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLayout extends Composite {
        interface AppLayoutUiBinder extends UiBinder<Widget, AppLayout> { }
        private static AppLayoutUiBinder uiBinder = GWT.create(AppLayoutUiBinder.class);

        @UiField SimplePanel appHeader;
        @UiField SimplePanel navContent;
        @UiField SimpleWidgetPanel appContent;

        public AppLayout() {
                initWidget(uiBinder.createAndBindUi(this));
        }

        public SimplePanel getAppHeaderHolder() {
            return this.appHeader;
        }

        public SimplePanel getNavContentHolder() {
            return this.navContent;
        }

        public SimpleWidgetPanel getAppContentHolder() {
                return this.appContent;
        }

}


