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

package io.hypesquad.rest;

import io.hypesquad.model.VoiceChannelStats;
import io.hypesquad.repository.VoiceChannelStatsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VoiceChannelStatsResource {

    private final VoiceChannelStatsRepository voiceChannelStatsRepository;

    public VoiceChannelStatsResource(VoiceChannelStatsRepository voiceChannelStatsRepository) {
        this.voiceChannelStatsRepository = voiceChannelStatsRepository;
    }

    @GetMapping("/stats/channels/voice")
    public List<VoiceChannelStats> getAllStats() {
        return voiceChannelStatsRepository.findAll();
    }
}
