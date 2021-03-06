// 
// MobeelizerDatabase.java
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

package com.mobeelizer.mobile.android.api;

import java.util.List;

import com.mobeelizer.mobile.android.Mobeelizer;

/**
 * Representation of the database.
 * 
 * @see Mobeelizer#getDatabase()
 * @since 1.0
 */
public interface MobeelizerDatabase {

    /**
     * Get the definition of model for the given class.
     * 
     * @param name
     *            name
     * @return definition of model
     * @since 1.0
     */
    MobeelizerModelDefinition getModel(final String name);

    /**
     * Prepare the query builder for the given class.
     * 
     * @param clazz
     *            class
     * @return criteria builder
     * @since 1.0
     */
    <T> MobeelizerCriteriaBuilder<T> find(final Class<T> clazz);

    /**
     * Get all entities for the given class from the database.
     * 
     * @param clazz
     *            class
     * @return list of entities
     * @since 1.0
     */
    <T> List<T> list(final Class<T> clazz);

    /**
     * Delete all entities for the given class from the database.
     * 
     * @param clazz
     *            class
     * @since 1.0
     */
    <T> void deleteAll(final Class<T> clazz);

    /**
     * Delete the entities for the given class and guids from the database.
     * 
     * @param clazz
     *            class
     * @param guids
     *            guids
     * @since 1.0
     */
    <T> void delete(final Class<T> clazz, final String... guids);

    /**
     * Delete the given entities from the database.
     * 
     * @param entity
     *            entity
     * @param otherEntities
     *            other entities
     * @since 1.0
     */
    <T> void delete(final T entity, final T... otherEntities);

    /**
     * Check whether the entity for the given class and guid exist.
     * 
     * @param clazz
     *            class
     * @param guid
     *            guid
     * @return true if exists
     * @since 1.0
     */
    <T> boolean exists(final Class<T> clazz, final String guid);

    /**
     * Get an entity for the given class and guid. If not found return null.
     * 
     * @param clazz
     *            class
     * @param guid
     *            guid
     * @return entity or null if not exists
     * @since 1.0
     */
    <T> T get(final Class<T> clazz, final String guid);

    /**
     * Return the count of the entities of the given class.
     * 
     * @param clazz
     *            class
     * @return count
     * @since 1.0
     */
    <T> long count(final Class<T> clazz);

    /**
     * Save the given entity in the database and return validation errors.
     * 
     * @param entity
     *            entity
     * @return errors
     * @since 1.0
     */
    <T> MobeelizerErrors save(final T entity);

}
