package com.chu.designer.repository;

import com.chu.designer.domain.DesignerLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DesignerLikeRepository extends JpaRepository<DesignerLike, Integer> {

    Integer countByDesignerSeq(Integer designerSeq);

    DesignerLike findByCustomerSeqAndDesignerSeq(Integer customerSeq, Integer designerSeq);

    // 좋아요 상태 true 로 업데이트하기
    @Modifying
    @Query("UPDATE DesignerLike l SET l.likeStatus = true WHERE l.customer.seq = :customerSeq and l.designer.seq = :designerSeq")
    void updateStatusTrue(int customerSeq, int designerSeq);
}
