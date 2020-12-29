package com.calm.minioerrordemo.controller;

import com.calm.minioerrordemo.service.UploadService;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test upload controller.
 *
 * @author calm on 2020-12-29
 * @since 1.0.0
 **/
@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @GetMapping("/upload")
    public ResponseEntity<String> upload() {
        String msg = uploadService.upload();
        return ResponseEntity.ok(msg);
    }

}
