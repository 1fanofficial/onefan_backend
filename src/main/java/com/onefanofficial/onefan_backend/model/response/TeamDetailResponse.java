package com.onefanofficial.onefan_backend.model.response;

import lombok.Data;

import java.util.UUID;

@Data
public class TeamDetailResponse {
    private UUID id;
    private String name;
    private String teamCode;
    private String teamColor;
    private String gradientOne;
    private String gradientTwo;
}
