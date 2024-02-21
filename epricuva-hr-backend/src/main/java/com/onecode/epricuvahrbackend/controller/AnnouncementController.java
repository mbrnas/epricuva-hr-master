package com.onecode.epricuvahrbackend.controller;

import com.onecode.epricuvahrbackend.domain.Announcement;
import com.onecode.epricuvahrbackend.exception.AnnouncementException;
import com.onecode.epricuvahrbackend.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() throws AnnouncementException {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/building/{buildingId}")
    public ResponseEntity<List<Announcement>> getAnnouncementsByBuildingId(@PathVariable Long buildingId) throws AnnouncementException {
        if(buildingId == null || buildingId <= 0) {
            throw new AnnouncementException("Building id is required");
        }
        List<Announcement> announcements = announcementService.getAnnouncementsByBuildingId(buildingId);
        return ResponseEntity.ok(announcements);
    }




}
