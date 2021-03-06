// 
// MobeelizerNotRestritionImplTest.java
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

package com.mobeelizer.mobile.android.search;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MobeelizerNotRestritionImplTest {

    @Test
    public void shouldAddToQuery() throws Exception {
        // given
        MobeelizerInternalCriterion criterion = mock(MobeelizerInternalCriterion.class);
        MobeelizerNotRestritionImpl restrition = new MobeelizerNotRestritionImpl(criterion);
        List<String> selectionArgs = new ArrayList<String>();

        when(criterion.addToQuery(selectionArgs)).thenReturn("c1");

        // when
        String query = restrition.addToQuery(selectionArgs);

        // then
        assertEquals(0, selectionArgs.size());
        assertEquals("not (c1)", query);
    }

}
