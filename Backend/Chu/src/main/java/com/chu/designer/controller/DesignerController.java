package com.chu.designer.controller;
import com.chu.consulting.domain.ConsultingDto;
import com.chu.designer.domain.*;
import com.chu.designer.service.DesignerService;
import com.chu.global.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/designer")
@RequiredArgsConstructor
public class DesignerController {
    private final DesignerService designerService;

    // 회원 가입
    @PostMapping(value = "/sign-up")
    public ResponseEntity<ResponseDto> signUp(@RequestBody DesignerSignUpDto designerSignUpDto) {
        log.info(designerSignUpDto.toString());
        boolean isSuccess = designerService.signUp(designerSignUpDto);

        if (isSuccess) {
            DesignerLoginDetailDto designerLoginDetailDto = designerService.getLoginDesignerDetail(designerSignUpDto.getId());
            ResponseDto responseDto = new ResponseDto(200, designerLoginDetailDto);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    // 로그인
    @PostMapping(value = "/sign-in")
    public ResponseEntity<ResponseDto> signIn(@RequestBody SignInRequestDto signInRequestDto) {
        boolean isDesigner = true;

        isDesigner = designerService.signIn(signInRequestDto);

        // 로그인 성공
        if (isDesigner) {
            DesignerLoginDetailDto designerLoginDetailDto = designerService.getLoginDesignerDetail(signInRequestDto.getId());
            ResponseDto responseDto = new ResponseDto(200, designerLoginDetailDto);
            return ResponseEntity.ok(responseDto);
        }
        // 로그인 실패
        else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/find-id")
    public ResponseEntity<ResponseDto> findId(@RequestParam String name, @RequestParam String email) {

        FindIdRequestDto findIdRequestDto = new FindIdRequestDto();
        findIdRequestDto.setName(name);
        findIdRequestDto.setEmail(email);

        String id = designerService.findId(findIdRequestDto);

        if (id != null) {
            ResponseDto responseDto = new ResponseDto(200, id);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/find-pwd")
    public ResponseEntity<ResponseDto> findPwd(@RequestParam String id, @RequestParam String name, @RequestParam String email) {

        FindPwdRequestDto findPwdRequestDto = new FindPwdRequestDto();
        findPwdRequestDto.setName(name);
        findPwdRequestDto.setId(id);
        findPwdRequestDto.setEmail(email);

        int seq = designerService.isValidUser(findPwdRequestDto);

        // 존재하는 유저일 경우
        if (seq == 1) {
            ResponseDto responseDto = new ResponseDto(200, seq);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @PatchMapping("/change-pwd")
    public ResponseEntity<ResponseDto> changePwd(@RequestBody ChangePwdDto changePwdDto) {
        boolean isSuccess = designerService.changePwd(changePwdDto);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/date")
    public ResponseEntity<ResponseDto> getPossibleTimeOfDate(@PathVariable("designer_seq") int designerSeq, @RequestParam Date date) {
        ArrayList<TimeStateDto> timeStateDtoList = new ArrayList<>();

        timeStateDtoList = designerService.getTimeStateList(designerSeq, date);

        if (timeStateDtoList.size() != 0) {
            ResponseDto responseDto = new ResponseDto(200, timeStateDtoList);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("alert")
    public ResponseEntity<ResponseDto> getAlert(@PathVariable("designer_seq") int designerSeq) {
        ArrayList<AlertDesignerDto> AlertDesignerDtoList = designerService.getAlertList(designerSeq);

        if (AlertDesignerDtoList.size() != 0) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDto> getMyPageInfo(@PathVariable("designer_seq") int designerSeq) {
        DesignerMyPageDto designerMyPageDto = designerService.getMyPageInfo(designerSeq);

        if (designerMyPageDto != null) {
            ResponseDto responseDto = new ResponseDto(200, designerMyPageDto);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @PatchMapping("/introduction")
    public ResponseEntity<ResponseDto> patchIntroduction(@PathVariable("designer_seq") int designerSeq, @RequestParam String introduction) {

        boolean isSuccess = designerService.patchIntroduction(designerSeq, introduction);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, introduction);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @PatchMapping("/img")
    public ResponseEntity<ResponseDto> patchImg(@PathVariable("designer_seq") int designerSeq, @RequestParam String img) {

        boolean isSuccess = designerService.patchImg(designerSeq, img);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, img);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseDto> getDesignerDetailInfo(@PathVariable("designer_seq") int designerSeq) {
        DesignerMyPageUpdateShowDto designerMyPageUpdateShowDto = new DesignerMyPageUpdateShowDto();

        designerMyPageUpdateShowDto = designerService.getDesignerMyPageUpdateInfo(designerSeq);

        if (designerMyPageUpdateShowDto != null) {
            ResponseDto responseDto = new ResponseDto(200, designerMyPageUpdateShowDto);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @PutMapping("/detail")
    public ResponseEntity<ResponseDto> updateDesignerInfo(@PathVariable("designer_seq") int designerSeq, @RequestBody DesignerInfoUpdateDto designerInfoUpdateDto) {

        boolean isSuccess = designerService.updateDesignerInfo(designerSeq, designerInfoUpdateDto);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/time")
    public ResponseEntity<ResponseDto> getPossibleReservationTime(@PathVariable("designer-seq") int designerSeq, Date date) {

        ArrayList<TimeDto> possibleReservationTime = designerService.getPossibleReservationTime(designerSeq, date);

        if (possibleReservationTime.size() != 0) {
            ResponseDto responseDto = new ResponseDto(200, possibleReservationTime);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }

    }

    @PutMapping("/time")
    public ResponseEntity<ResponseDto> updatePossibleReservationTime(@PathVariable("designer-seq") int designerSeq, @RequestBody ReservationTimeDto reservationTimeDto) {

        boolean isSuccess = designerService.updatePossibleReservationTime(designerSeq, reservationTimeDto);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/reservation-list")
    public ResponseEntity<ResponseDto> getReservationList(@PathVariable("designer-seq") int designerSeq) {

        ArrayList<ConsultingDto> reservationList = designerService.getReservationList(designerSeq);

        if (reservationList.size() != 0) {
            ResponseDto responseDto = new ResponseDto(200, reservationList);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @GetMapping("/portfolio")
    public ResponseEntity<ResponseDto> getPortfolio(@PathVariable("designer-seq") int designerSeq) {

        ArrayList<ImageDto> portfolioList = designerService.getPortfolio(designerSeq);

        if (portfolioList.size() != 0) {
            ResponseDto responseDto = new ResponseDto(200, portfolioList);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @PostMapping("/portfolio")
    public ResponseEntity<ResponseDto> postPortfolio(@PathVariable("designer-seq") int designerSeq, @RequestParam String img) {

        boolean isSuccess = designerService.postPortfolioImage(designerSeq, img);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }

    @DeleteMapping("/portfolio")
    public ResponseEntity<ResponseDto> deletePortfolio(@PathVariable("designer-seq") int designerSeq, @RequestParam int imageSeq) {

        boolean isSuccess = designerService.deletePortfolioImage(designerSeq, imageSeq);

        if (isSuccess) {
            ResponseDto responseDto = new ResponseDto(200, null);
            return ResponseEntity.ok(responseDto);
        } else {
            ResponseDto responseDto = new ResponseDto(204, null);
            return ResponseEntity.ok(responseDto);
        }
    }
}
