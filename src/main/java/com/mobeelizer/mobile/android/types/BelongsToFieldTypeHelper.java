// 
// BelongsToFieldTypeHelper.java
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

package com.mobeelizer.mobile.android.types;

import static com.mobeelizer.mobile.android.model.MobeelizerReflectionUtil.setValue;

import java.lang.reflect.Field;
import java.util.Map;

import android.content.ContentValues;
import android.database.Cursor;

import com.mobeelizer.mobile.android.Mobeelizer;
import com.mobeelizer.mobile.android.MobeelizerErrorsImpl;
import com.mobeelizer.mobile.android.api.MobeelizerErrors;

public class BelongsToFieldTypeHelper extends FieldTypeHelper {

    public BelongsToFieldTypeHelper() {
        super(String.class); // TODO V3 auto proxy on belongsTo fields - Object.class
    }

    @Override
    protected void setNotNullValueFromEntityToDatabase(final ContentValues values, final Object value, final Field field,
            final Map<String, String> options, final MobeelizerErrorsImpl errors) {
        Class<?> clazz = Mobeelizer.getDatabase().getModel(options.get("model")).getMappingClass();

        if (!Mobeelizer.getDatabase().exists(clazz, (String) value)) {
            errors.addFieldMissingReferenceError(field.getName(), (String) value);
            return;
        }

        values.put(field.getName(), (String) value);
    }

    @Override
    protected void setNullValueFromEntityToDatabase(final ContentValues values, final Field field,
            final Map<String, String> options, final MobeelizerErrors errors) {
        values.put(field.getName(), (String) null);
    }

    @Override
    protected <T> void setNotNullValueFromDatabaseToEntity(final Cursor cursor, final int columnIndex, final T entity,
            final Field field, final Map<String, String> options) {
        setValue(field, entity, cursor.getString(columnIndex));
    }

    @Override
    protected String[] getTypeDefinition(final Field field, final boolean required, final Object defaultValue,
            final Map<String, String> options) {
        return new String[] { getSingleDefinition(field.getName(), "TEXT(36)", required, null, false) + " REFERENCES "
                + options.get("model") + "(guid)" };
    }

    @Override
    protected Object convertTypeDefaultValue(final Field field, final String defaultValue, final Map<String, String> options) {
        return null;
    }

    @Override
    protected void setNotNullValueFromDatabaseToMap(final Cursor cursor, final int columnIndex, final Map<String, String> values,
            final Field field, final Map<String, String> options) {
        values.put(field.getName(), cursor.getString(columnIndex));
    }

    @Override
    protected void setNullValueFromDatabaseToMap(final Cursor cursor, final int columnIndex, final Map<String, String> values,
            final Field field, final Map<String, String> options) {
        values.put(field.getName(), null);
    }

    @Override
    protected void setNotNullValueFromMapToDatabase(final ContentValues values, final String value, final Field field,
            final Map<String, String> options, final MobeelizerErrors errors) {
        values.put(field.getName(), value);
    }

    @Override
    protected void setNullValueFromMapToDatabase(final ContentValues values, final Field field,
            final Map<String, String> options, final MobeelizerErrors errors) {
        values.put(field.getName(), (String) null);
    }

}
