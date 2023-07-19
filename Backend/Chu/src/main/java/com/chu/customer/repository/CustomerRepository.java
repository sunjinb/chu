package com.chu.customer.repository;

import com.chu.customer.domain.CustomerDetailDto;
import com.chu.customer.domain.CustomerDto;
import com.chu.global.domain.ChangePwdDto;
import com.chu.global.domain.FindIdDto;
import com.chu.global.domain.FindPwdDto;
import com.chu.global.domain.SignInDto;

public interface CustomerRepository {

    boolean checkId(String id);
    boolean checkEmail(String email);
    int signUp(CustomerDto customerDto);

    boolean signIn(SignInDto signInDto);

    CustomerDetailDto getCustomerDetail(String id);

    String findId(FindIdDto findIdDto);

    int isValidUser(FindPwdDto findPwdDto);

    boolean changePwd(ChangePwdDto changePwdDto);
}
