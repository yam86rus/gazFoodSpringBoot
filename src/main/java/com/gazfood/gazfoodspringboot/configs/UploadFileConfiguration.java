package com.gazfood.gazfoodspringboot.configs;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * Конфигурация загрузки файла
 * @author lrd
 * @date 2018/10/22
 * @param * @param null
 * @return  null
 */
public class UploadFileConfiguration {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // Устанавливаем лимит размера файла. Превышение страницы настройки вызовет сообщение об исключении.
        factory.setMaxFileSize(DataSize.parse("256KB"));
        // Установить общий размер загружаемого файла
        factory.setMaxRequestSize(DataSize.parse("512KB"));
        return factory.createMultipartConfig();
    }
}
