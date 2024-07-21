package com.example.demo.user;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    @Column(nullable = false)
	private String firstName;
    @Column(nullable = false)
	private String lastName;
    @Column(nullable = false)
	private String email;
    @Column(nullable = false)
	private String password;
    @CreationTimestamp
	private LocalDateTime createdAt;
    @UpdateTimestamp
	private LocalDateTime upatedAt;
    
    private String roles;
}
