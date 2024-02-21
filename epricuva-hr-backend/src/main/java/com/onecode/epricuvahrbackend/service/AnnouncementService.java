package com.onecode.epricuvahrbackend.service;
import com.onecode.epricuvahrbackend.domain.Announcement;
import com.onecode.epricuvahrbackend.exception.AnnouncementException;
import com.onecode.epricuvahrbackend.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final Validator validator;

    public AnnouncementService(AnnouncementRepository announcementRepository, Validator validator) {
        this.announcementRepository = announcementRepository;
        this.validator = validator;
    }

    public List<Announcement> getAnnouncementsByBuildingId(Long buildingId) throws AnnouncementException {
        if(buildingId == null) {
            throw new AnnouncementException("Building id is required");
        } else {
            return announcementRepository.getAnnouncementsByBuildingId(buildingId);
        }
    }

    public Announcement saveAnnouncement(Announcement announcement) throws AnnouncementException {
        validateAnnouncement(announcement);
        return announcementRepository.save(announcement);
    }

    public Announcement updateAnnouncement(Announcement announcement) throws AnnouncementException {
        validateAnnouncement(announcement);
        return announcementRepository.save(announcement);
    }

    public void deleteAnnouncement(Long id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        else if(!announcementRepository.existsById(id)) {
            throw new IllegalArgumentException("Announcement with id " + id + " does not exist");
        }
            announcementRepository.deleteById(id);
    }

    public Announcement getAnnouncementById(Long id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        else if(!announcementRepository.existsById(id)) {
            throw new IllegalArgumentException("Announcement with id " + id + " does not exist");
        }
        return announcementRepository.findById(id).orElse(null);
    }

    public List<Announcement> getAllAnnouncements() throws AnnouncementException {
        if(announcementRepository.findAll().isEmpty()) {
            throw new AnnouncementException("No announcements found");
        }
        return announcementRepository.findAll();
    }

    private void validateAnnouncement(Announcement announcement) throws AnnouncementException {
        BindingResult result = new BeanPropertyBindingResult(announcement, "announcement");
        validator.validate(announcement, result);
        if (result.hasErrors()) {
            throw new AnnouncementException("Invalid Announcement: " + result.getAllErrors());
        }
    }
}
