package com.example.demo.repository;

import com.example.demo.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groups,Long> {
}
