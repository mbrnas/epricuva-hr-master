package com.onecode.epricuvahrbackend.controller;

import com.onecode.epricuvahrbackend.domain.Announcement;
import com.onecode.epricuvahrbackend.exception.AnnouncementException;
import com.onecode.epricuvahrbackend.service.AnnouncementService;
import jakarta.validation.Valid;
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

    @PostMapping("/save")
    public ResponseEntity<Announcement> saveAnnouncement(@Valid @RequestBody Announcement announcement) throws AnnouncementException {
        Announcement savedAnnouncement = announcementService.saveAnnouncement(announcement);
        return ResponseEntity.ok(savedAnnouncement);
    }

    @PutMapping("/update")
    public ResponseEntity<Announcement> updateAnnouncement(@Valid @RequestBody Announcement announcement) throws AnnouncementException {
        Announcement updatedAnnouncement = announcementService.updateAnnouncement(announcement);
        return ResponseEntity.ok(updatedAnnouncement);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable Long id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.ok("Announcement with id " + id + " has been deleted");
    }


}
