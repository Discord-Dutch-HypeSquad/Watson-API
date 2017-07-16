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

package io.hypesquad.watsonapi.model;

import io.hypesquad.watsonapi.model.event.TextChannelEvent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "text_channel_statistics")
public class TextChannelStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "channel_id")
    private Long channelId;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(columnDefinition = "enum('create', 'update', 'delete', 'pin'")
    @Convert(converter = TextChannelEvent.class)
    private TextChannelEvent action;

    @Column(name = "datetime")
    @NotNull
    private Date dateTime;
}
