package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.UserService;
import com.gazfood.gazfoodspringboot.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.security.Principal;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class UploadFileController {
    @Autowired
    private UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${dishes.path}")
    private String dishesPath;

    @Value("${avatars.path}")
    private String avatarsPath;

    @Value("${cafeterias.path}")
    private String cafeteriasPath;


    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        String contentType = file.getContentType(); // Тип файла изображения
        String fileName = FileUtil.getFileName(file.getOriginalFilename()); // Имя изображения
        String filePath = dishesPath + "/";
        try {
            // Вызываем класс обработки файлов FileUtil для обработки файла и записи файла в указанное место
            FileUtil.uploadFile(file.getBytes(), filePath, fileName); // загружаем в /pathUpload/
            model.addAttribute("fileName", fileName);
            model.addAttribute("filePath", filePath);
            return "upload_success";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:upload";
        }

    }
}
