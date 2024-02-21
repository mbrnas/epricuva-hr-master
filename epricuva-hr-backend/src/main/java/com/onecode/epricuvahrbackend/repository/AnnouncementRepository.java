package com.onecode.epricuvahrbackend.repository;

import com.onecode.epricuvahrbackend.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> getAnnouncementsByBuildingId(Long buildingId);
}
