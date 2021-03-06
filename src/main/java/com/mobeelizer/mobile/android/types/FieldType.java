// 
// FieldType.java
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

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

import com.mobeelizer.mobile.android.MobeelizerErrorsImpl;

public enum FieldType {

    TEXT(new TextFieldTypeHelper()), INTEGER(new IntegerFieldTypeHelper()), BOOLEAN(new BooleanFieldTypeHelper()), DECIMAL(
            new DecimalFieldTypeHelper()), DATE(new DateFieldTypeHelper()), BELONGS_TO(new BelongsToFieldTypeHelper()), FILE(
            new FileFieldTypeHelper());

    private final FieldTypeHelper helper;

    private FieldType(final FieldTypeHelper helper) {
        this.helper = helper;
    }

    public Set<Class<?>> getAccessibleTypes() {
        return helper.getAccessibleTypes();
    }

    public <T> void setValueFromEntityToDatabase(final ContentValues values, final T entity, final Field field,
            final boolean required, final Map<String, String> options, final MobeelizerErrorsImpl errors) {
        helper.setValueFromEntityToDatabase(values, entity, field, required, options, errors);
    }

    public <T> void setValueFromDatabaseToEntity(final Cursor cursor, final T entity, final Field field,
            final Map<String, String> options) {
        helper.setValueFromDatabaseToEntity(cursor, entity, field, options);
    }

    public Object convertDefaultValue(final Field field, final String defaultValue, final Map<String, String> options) {
        return helper.convertDefaultValue(field, defaultValue, options);
    }

    public String[] getDefinition(final Field field, final boolean required, final Object defaultValue,
            final Map<String, String> options) {
        return helper.getDefinition(field, required, defaultValue, options);
    }

    public void setValueFromDatabaseToMap(final Cursor cursor, final Map<String, String> map, final Field field,
            final Map<String, String> options) {
        helper.setValueFromDatabaseToMap(cursor, map, field, options);
    }

    public void setValueFromMapToDatabase(final ContentValues values, final Map<String, String> map, final Field field,
            final boolean required, final Map<String, String> options, final MobeelizerErrorsImpl errors) {
        helper.setValueFromMapToDatabase(values, map, field, required, options, errors);
    }

}
