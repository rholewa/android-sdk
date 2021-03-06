// 
// MobeelizerFieldCredentialsImpl.java
// 
// Copyright (C) 2012 Mobeelizer Ltd. All Rights Reserved.
//
// Mobeelizer SDK is free software; you can redistribute it and/or modify it 
// under the terms of the GNU Affero General Public License as published by 
// the Free Software Foundation; either version 3 of the License, or (at your
// option) any later version.
//
// This program is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
// FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
// for more details.
//
// You should have received a copy of the GNU Affero General Public License 
// along with this program; if not, write to the Free Software Foundation, Inc., 
// 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
// 

package com.mobeelizer.mobile.android.model;

import com.mobeelizer.mobile.android.api.MobeelizerCredential;
import com.mobeelizer.mobile.android.api.MobeelizerFieldCredentials;
import com.mobeelizer.mobile.android.definition.MobeelizerModelFieldCredentialsDefinition;

public class MobeelizerFieldCredentialsImpl implements MobeelizerFieldCredentials {

    private final MobeelizerCredential readAllowed;

    private final MobeelizerCredential updateAllowed;

    private final MobeelizerCredential createAllowed;

    public MobeelizerFieldCredentialsImpl(final MobeelizerModelFieldCredentialsDefinition credentials) {
        this.readAllowed = credentials.getReadAllowed();
        this.updateAllowed = credentials.getUpdateAllowed();
        this.createAllowed = credentials.getCreateAllowed();
    }

    @Override
    public MobeelizerCredential getReadAllowed() {
        return readAllowed;
    }

    @Override
    public MobeelizerCredential getUpdateAllowed() {
        return updateAllowed;
    }

    @Override
    public MobeelizerCredential getCreateAllowed() {
        return createAllowed;
    }

}
