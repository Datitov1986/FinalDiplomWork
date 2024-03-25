package diplom.controllers;

import diplom.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/confirm-teacher-status/{userId}")
    public ResponseEntity<String> confirmTeacherStatus(@PathVariable Long userId) {
        adminService.confirmTeacherStatus(userId);
        return ResponseEntity.ok("Статус учителя подтвержден для пользователя с Id: " + userId);
    }
}
