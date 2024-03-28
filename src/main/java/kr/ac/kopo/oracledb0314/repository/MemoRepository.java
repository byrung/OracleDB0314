package kr.ac.kopo.oracledb0314.repository;

import kr.ac.kopo.oracledb0314.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {

    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteMemoByMno(Long mno);

    void deleteMemoByMnoLessThan(Long mno);

    void deleteMemoByMnoLessThanEqual(Long mno);

    @Query(value = "select * from tbl_memo where mno > 70", nativeQuery = true)
    List<Memo> getNativeResult();

    @Query(value = "select * from tbl_memo where mno > 80", nativeQuery = true)
    List<Object[]> getNativeResult2();
}
