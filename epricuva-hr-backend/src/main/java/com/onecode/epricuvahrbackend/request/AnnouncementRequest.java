package com.onecode.epricuvahrbackend.request;

import com.onecode.epricuvahrbackend.domain.Building;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class AnnouncementRequest {
    private String title;
    private String content;
    private LocalDate date;
    private Long buildingId;
}
