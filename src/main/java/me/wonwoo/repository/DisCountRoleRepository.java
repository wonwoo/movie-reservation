package me.wonwoo.repository;


import me.wonwoo.domain.DisCountRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisCountRoleRepository extends JpaRepository<DisCountRule, Long> {

}
