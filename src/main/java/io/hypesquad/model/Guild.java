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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "guilds")
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "guild_id")
    private String guildId;

    @NotNull
    @Column(name = "owner_id")
    private String ownerId;

    @NotNull
    private String name;

    @NotNull
    private String icon;

    @ManyToMany
    @JoinTable(name = "guild_has_channels",
            joinColumns = @JoinColumn(name = "guild_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "id"))
    private Set<Channel> hasChannels;
}
