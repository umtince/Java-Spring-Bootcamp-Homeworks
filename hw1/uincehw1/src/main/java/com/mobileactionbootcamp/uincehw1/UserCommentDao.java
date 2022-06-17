package com.mobileactionbootcamp.uincehw1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentDao extends JpaRepository<UserComment, Long> {
}
