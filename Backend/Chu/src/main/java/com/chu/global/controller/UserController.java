package com.chu.global.controller;

import com.chu.customer.service.CustomerService;
import com.chu.designer.service.DesignerService;
import com.chu.global.domain.RequestAlertCreateDto;
import com.chu.global.domain.RequestAlertReadDto;
import com.chu.global.domain.HttpResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CustomerService customerService;
    private final DesignerService designerService;

    // 아이디 중복확인
    @GetMapping("/check-id")
    public ResponseEntity<HttpResponseDto> checkId(@RequestParam String id){
        log.info("id = {id}", id);

        // 존재하지 않으면 가능 -> true
        boolean existsCustomer = customerService.checkId(id);
        // 존재하지 않으면 가능 -> true
        boolean existsDesigner = designerService.checkId(id);

        // 두 테이블 모두 존재하지 않아야함
        if (existsCustomer && existsDesigner) {
            HttpResponseDto httpResponseDto = new HttpResponseDto(200, true);
            return ResponseEntity.ok(httpResponseDto);
        }
        else{
            HttpResponseDto httpResponseDto = new HttpResponseDto(204, false);
            return ResponseEntity.ok(httpResponseDto);
        }
    }

    // 이메일 중복확인
    @GetMapping("/check-email")
    public ResponseEntity<HttpResponseDto> checkEmail(@RequestParam String email){
        log.info("email = {email}", email);

        // 존재하지 않으면 가능 -> true
        boolean existsCustomer = customerService.checkEmail(email);
        // 존재하지 않으면 가능 -> true
        boolean existsDesigner = designerService.checkEmail(email);

        // 두 테이블 모두 존재하지 않아야함
        if (existsCustomer && existsDesigner) {
            HttpResponseDto httpResponseDto = new HttpResponseDto(200, true);
            return ResponseEntity.ok(httpResponseDto);
        }
        else{
            HttpResponseDto httpResponseDto = new HttpResponseDto(204, false);
            return ResponseEntity.ok(httpResponseDto);
        }
    }

    @PostMapping("/alert")
    public ResponseEntity<HttpResponseDto> creatAlert(@RequestBody RequestAlertCreateDto requestAlertCreateDto) {

        String userType = requestAlertCreateDto.getUserType();

        boolean customerSuccess = false;
        boolean designerSuccess = false;

        if(userType.equals("customer")){
            boolean isSuccess = customerService.createAlert(requestAlertCreateDto);
            if(isSuccess) customerSuccess = true;
        }
        else if(userType.equals("designer")){
            boolean isSuccess = designerService.createAlert(requestAlertCreateDto);
            if(isSuccess) designerSuccess = true;
        }

        if(customerSuccess || designerSuccess){
            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
            return ResponseEntity.ok(httpResponseDto);
        }
        else{
            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
            return ResponseEntity.ok(httpResponseDto);
        }
    }

    @PatchMapping("/alert")
    public ResponseEntity<HttpResponseDto> readAlert(@RequestBody RequestAlertReadDto requestAlertReadDto) {

        String userType = requestAlertReadDto.getUserType();

        boolean customerSuccess = false;
        boolean designerSuccess = false;

        if (userType.equals("customer")) {
            boolean isSuccess = customerService.readAlert(requestAlertReadDto);
            if (isSuccess) customerSuccess = true;
        } else if (userType.equals("designer")) {
            boolean isSuccess = designerService.readAlert(requestAlertReadDto);
            if (isSuccess) designerSuccess = true;
        }

        if (customerSuccess || designerSuccess) {
            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
            return ResponseEntity.ok(httpResponseDto);
        } else {
            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
            return ResponseEntity.ok(httpResponseDto);
        }
    }
}
