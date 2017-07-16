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

package io.hypesquad.util;

import io.hypesquad.model.event.TextChannelEvent;

import javax.persistence.AttributeConverter;

public class TextChannelEventConverter implements AttributeConverter<TextChannelEvent, String> {

    @Override
    public String convertToDatabaseColumn(TextChannelEvent attribute) {
        return attribute.getEvent();
    }

    @Override
    public TextChannelEvent convertToEntityAttribute(String dbData) {
        for (TextChannelEvent event : TextChannelEvent.values()) {
            if (event.getEvent().equalsIgnoreCase(dbData)) {
                return event;
            }
        }
        return null;
    }
}
