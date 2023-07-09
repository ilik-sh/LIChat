package org.example.LiChat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
