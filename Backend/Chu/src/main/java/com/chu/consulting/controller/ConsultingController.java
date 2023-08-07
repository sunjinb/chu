package com.chu.consulting.controller;

import com.chu.consulting.domain.*;
import com.chu.consulting.service.ConsultingService;
import com.chu.global.domain.HttpResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/consulting")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor

public class ConsultingController {

    private final ConsultingService consultingService;
//
//    @GetMapping("/")
//    public ResponseEntity<HttpResponseDto> participantConsulting(@PathVariable("consulting_seq") int consultingSeq) {
//
//        String url = consultingService.participantConsulting(consultingSeq);
//
//        if (url != null) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, url);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
    // 상담 예약하기
    @PostMapping("")
    public ResponseEntity<HttpResponseDto> postConsulting(@RequestBody RequestConsultingDto requestConsultingDto){

        try{
            // requestConsultingDto -> entity 만들기
            Consulting consulting = requestConsultingDto.toConsultingEntity();
            consultingService.postConsulting(consulting);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new HttpResponseDto(HttpStatus.NO_CONTENT.value(), null));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(HttpStatus.OK.value(), null));
    }

    // 상담 취소하기
    @PutMapping("/{consultingSeq}")
    public ResponseEntity<HttpResponseDto> cancelConsulting(@PathVariable int consultingSeq){
        // requestbody로 userType 받기
        try{
            consultingService.cancelConsulting(consultingSeq);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new HttpResponseDto(HttpStatus.NO_CONTENT.value(), null));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(HttpStatus.OK.value(), null));
    }

//
//    @PatchMapping("/")
//    public ResponseEntity<HttpResponseDto> updateConsultingUrl(@PathVariable("consulting-seq") int consultingSeq, @RequestParam String url){
//
//        boolean isSuccess = consultingService.updateConsultingUrl(consultingSeq, url);
//
//        if (isSuccess) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<HttpResponseDto> deleteConsulting(@PathVariable("consulting-seq") int consultingSeq) {
//
//        boolean isSuccess = consultingService.deleteConsulting(consultingSeq);
//
//        if (isSuccess) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
//    @GetMapping("/result")
//    public ResponseEntity<HttpResponseDto> getConsultingResult(@PathVariable("consulting-seq") int consultingSeq) {
//
//        ResponseConsultingResultDto responseConsultingResultDto = consultingService.getConsultingResult(consultingSeq);
//
//        if (responseConsultingResultDto != null) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, responseConsultingResultDto);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
//    @PatchMapping("/result")
//    public ResponseEntity<HttpResponseDto> updateConsultingResult(@RequestBody RequestConsultingUpdateDto requestConsultingUpdateDto) {
//
//        boolean isSuccess = consultingService.updateConsultingResult(requestConsultingUpdateDto);
//
//        if (isSuccess) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
//    @PatchMapping("/review")
//    public ResponseEntity<HttpResponseDto> updateConsultingReview(@RequestBody RequestConsultingReviewDto requestConsultingReviewDto) {
//
//        boolean isSuccess = consultingService.updateConsultingReview(requestConsultingReviewDto);
//
//        if (isSuccess) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
//    @GetMapping("/result-element")
//    public ResponseEntity<HttpResponseDto> getConsultingResultDetailInfo(@RequestParam int consultingSeq){
//
//        ResponseConsultingReviewInfoDto responseConsultingReviewInfoDto = consultingService.getConsultingResultDetailInfo(consultingSeq);
//
//        if (responseConsultingReviewInfoDto != null) {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(200, responseConsultingReviewInfoDto);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//        else {
//            HttpResponseDto httpResponseDto = new HttpResponseDto(204, null);
//            return ResponseEntity.ok(httpResponseDto);
//        }
//    }
//
}
