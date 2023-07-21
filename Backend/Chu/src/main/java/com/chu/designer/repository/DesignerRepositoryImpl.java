package com.chu.designer.repository;

import com.chu.consulting.domain.ConsultingDto;
import com.chu.designer.domain.*;
import com.chu.global.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

@Slf4j
@Repository
@Transactional
public class DesignerRepositoryImpl implements DesignerRepository {

    // db connect

    @Override
    public boolean checkId(String id) {
        // 로직

        // 존재하지 않으면 가능 -> true
        // 이미 존재하면 불가능 -> false
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public boolean signUp(RequestDesignerSignUpDto requestDesignerSignUpDto) {
        // 로직

        // 로그인 되는지
        return true;
    }

    @Override
    public boolean signIn(RequestSignInDto requestSignInDto) {
        // 로직

        return false;
    }

    @Override
    public DesignerDto getDesignerInfo(String id) {
        DesignerDto designerDto = new DesignerDto();
        // 로직

        // 디자이너 테이블에서 정보 조회
        return designerDto;
    }


    @Override
    public String findId(RequestFindIdDto requestFindIdDto) {
        // 로직

        // 이름, 이메일로 아이디 찾기
        return null;
    }

    @Override
    public int isValidUser(RequestFindPwdDto requestFindPwdDto) {
        // 로직
        // 이름, 아이디, 이메일로 존재하는 유저인지 확인
        return 0;
    }

    @Override
    public boolean changePwd(RequestChangePwdDto requestChangePwdDto) {
        // 로직
        // 디자이너 시퀀스넘버, 바꿀 비밀번호
        return false;
    }

    @Override
    public ArrayList<ResponseTimeStateDto> getTimeStateList(int designerSeq, Date date) {
        ArrayList<ResponseTimeStateDto> result = new ArrayList<>();

        // 디자이너 번호, 시간으로 가능 날짜 조회

        // 상담 가능 시간에서 P, R 조회
        // 아니라면 I 겠지!

        return result;
    }

    @Override
    public ArrayList<ResponseAlertDesignerDto> getAlertList(int designerSeq) {
        ArrayList<ResponseAlertDesignerDto> alertList = new ArrayList<>();

        // 로직
        // 디자이너 번호로 알림 조회

        return alertList;
    }

    @Override
    public boolean createAlert(RequestAlertCreateDto requestAlertCreateDto) {
        boolean isSuccess = true;

        // 로직

        return isSuccess;
    }

    @Override
    public boolean readAlert(RequestAlertReadDto requestAlertReadDto) {
        boolean isSuccess = true;

        // 알림 읽기

        return isSuccess;
    }

    @Override
    public boolean patchIntroduction(int designerSeq, String introduction) {
        boolean isSuccess = true;

        // 로직
        // 디자이너 한줄 소개 변경
        
        return isSuccess;
    }

    @Override
    public boolean patchImg(int designerSeq, String img) {
        boolean isSuccess = true;

        // 로직

        // 디자이너 대표 사진 변경

        return isSuccess;
    }

    @Override
    public DesignerMyPageUpdateShowDto getDesignerMyPageUpdateInfo(int designerSeq) {
        DesignerMyPageUpdateShowDto designerMyPageUpdateShowDto = new DesignerMyPageUpdateShowDto();

        // 로직

        // 디자이너 정보 삽입

        // 디자이너 지역 정보 삽입

        // 컷 정보 삽입

        // 펌 정보 삽입

        // 디자이너가 잘하는 컷 정보 삽입

        // 디자이너가 잘하는 펌 정보 삽입

        return designerMyPageUpdateShowDto;
    }

    @Override
    public boolean updateDesignerInfo(int designerSeq, DesignerInfoUpdateDto designerInfoUpdateDto) {
        boolean isSuccess = true;

        // 로직

        // 디자이너 정보 수정
        
        // 디자이너 지역 정보 수정

        // 디자이너가 잘하는 컷, 펌 삽입

        return isSuccess;
    }

    @Override
    public ArrayList<TimeDto> getPossibleReservationTime(int designerSeq, Date date) {
        ArrayList<TimeDto> possibleReservationTimeList = new ArrayList<>();

        // 디자이너 해당 날짜 가능 시간 조회

        return possibleReservationTimeList;
    }

    @Override
    public boolean updatePossibleReservationTime(int designerSeq, ReservationTimeDto reservationTimeDto) {
        boolean isSuccess = true;

        // 로직
        
        // 해당 미용사의 예약 가능 시간 변경

        return isSuccess;
    }

    @Override
    public ArrayList<ConsultingDto> getReservationList(int designerSeq) {
        ArrayList<ConsultingDto> reservationList = new ArrayList<>();

        // 로직

        // 디자이너 seq로 현재 시점 이후 예약 날짜 혹은 시간 상담들 조회

        return reservationList;
    }

    @Override
    public ArrayList<ImageDto> getPortfolio(int designerSeq) {
        ArrayList<ImageDto> portfolioList = new ArrayList<>();

        // 로직

        // 디자이너 번호로 포트폴리오 다 가져오기

        return portfolioList;
    }

    @Override
    public boolean deletePortfolioImage(int designerSeq, int imageSeq) {
        
        boolean isSuccess = true;

        // 로직
        
        // 해당 디자이너의 이미지 하나 삭제
        
        return isSuccess;
    }

    @Override
    public boolean postPortfolioImage(int designerSeq, String img) {
        
        boolean isSuccess = true;

        // 로직
        
        // 해당 디자이너 번호에 해당 이미지 삽입
        
        return isSuccess;
    }

    @Override
    public ArrayList<BestDesignerDto> getBestDesigners() {
        ArrayList<BestDesignerDto> bestDesignerInfoList = new ArrayList<>();

        // 베스트 디자이너들 정보 얻어오기
        // 디자이너 평점 limit 6
        // 초기에 값이 없을 수도 있음 null 조심, 미리 dump 파일로 어느정도 데이터 삽입해놓기

        return bestDesignerInfoList;
    }
}
