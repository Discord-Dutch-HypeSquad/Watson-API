/*
 * This file is part of Watson-API.
 *
 * Watson-API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Watson-API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Watson-API. If not, see <http://www.gnu.org/licenses/>.
 */

package io.hypesquad.watsonapi.util;

import io.hypesquad.watsonapi.model.event.ChannelType;

import javax.persistence.AttributeConverter;

public class ChannelTypeConverter implements AttributeConverter<ChannelType, String> {

    @Override
    public String convertToDatabaseColumn(ChannelType attribute) {
        return attribute.getType();
    }

    @Override
    public ChannelType convertToEntityAttribute(String dbData) {
        for (ChannelType type : ChannelType.values()) {
            if (type.getType().equalsIgnoreCase(dbData)) {
                return type;
            }
        }
        return null;
    }
}
