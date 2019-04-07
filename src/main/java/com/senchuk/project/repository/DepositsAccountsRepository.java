package com.senchuk.project.repository;

import com.senchuk.project.model.DepositsAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositsAccountsRepository extends JpaRepository<DepositsAccounts, Long> {

    @Query("select account.master_account_balance from DepositsAccounts as account where account.profile_id=:id")
    String getBalanceOfClientAccount(@Param("id") long profile_id);

}
