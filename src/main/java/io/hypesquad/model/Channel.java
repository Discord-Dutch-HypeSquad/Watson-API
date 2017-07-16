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

package io.hypesquad.model;

import io.hypesquad.model.event.ChannelType;
import io.hypesquad.util.ChannelTypeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "channels")
public class Channel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "channel_id")
    private String channelId;

    @NotNull
    private String name;

    @NotNull
    @Column(columnDefinition = "enum('text', 'voice')")
    @Convert(converter = ChannelTypeConverter.class)
    private ChannelType type;

    public Long getId() {
        return id;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getName() {
        return name;
    }

    public ChannelType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        if (channel.id == null || id == null) {
            return false;
        }

        return Objects.equals(id, channel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
