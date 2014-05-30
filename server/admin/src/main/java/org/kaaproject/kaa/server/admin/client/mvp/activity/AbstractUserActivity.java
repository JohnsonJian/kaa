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

package org.kaaproject.kaa.server.admin.client.mvp.activity;

import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.ClientFactory;
import org.kaaproject.kaa.server.admin.client.mvp.place.UserPlace;
import org.kaaproject.kaa.server.admin.client.mvp.view.UserView;
import org.kaaproject.kaa.server.admin.client.util.Utils;
import org.kaaproject.kaa.server.admin.shared.dto.ResultCode;
import org.kaaproject.kaa.server.admin.shared.dto.UserDto;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AbstractUserActivity<T extends UserDto, V extends UserView, P extends UserPlace> extends
        AbstractDetailsActivity<T, V, P> {



    public AbstractUserActivity(P place, ClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    protected String getEntityId(P place) {
        return place.getUserId();
    }

    @Override
    protected void onEntityRetrieved() {
        detailsView.getUserName().setValue(entity.getUsername());
        detailsView.getEmail().setValue(entity.getMail());
    }

    @Override
    protected void onSave() {
        entity.setUsername(detailsView.getUserName().getValue());
        entity.setMail(detailsView.getEmail().getValue());
    }

    @Override
    protected void doSave(final EventBus eventBus) {
        onSave();

        detailsView.clearError();

        if (create) {
            KaaAdmin.getAuthService().checkUserNameOccupied(entity.getUsername(), null, new AsyncCallback<ResultCode>() {
                @Override
                public void onFailure(Throwable caught) {
                    detailsView.setErrorMessage(Utils.getErrorMessage(caught));
                }

                @Override
                public void onSuccess(ResultCode result) {
                    if (result != ResultCode.OK) {
                        detailsView.setErrorMessage(Utils.constants.getString(result.getResourceKey()));
                    }
                    else {
                        checkEmail();
                    }
                }
            });
        }
        else {
            checkEmail();
        }
    }

    private void checkEmail() {
        final Long userId = !create ? Long.valueOf(entity.getExternalUid()) : null;
        KaaAdmin.getAuthService().checkEmailOccupied(entity.getMail(), userId,new AsyncCallback<ResultCode>() {
            @Override
            public void onFailure(Throwable caught) {
                detailsView.setErrorMessage(Utils.getErrorMessage(caught));
            }

            @Override
            public void onSuccess(ResultCode result) {
                if (result != ResultCode.OK) {
                    detailsView.setErrorMessage(Utils.constants.getString(result.getResourceKey()));
                }
                else {
                    performSave();
                }
            }
        });
    }

    private void performSave() {
        editEntity(entity,
                new AsyncCallback<T>() {
                    public void onSuccess(T result) {
                        goTo(place.getPreviousPlace());
                    }

                    public void onFailure(Throwable caught) {
                        detailsView.setErrorMessage(Utils.getErrorMessage(caught));
                    }
        });
    }

}
