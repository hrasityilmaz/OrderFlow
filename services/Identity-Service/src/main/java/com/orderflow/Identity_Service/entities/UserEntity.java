package com.orderflow.Identity_Service.entities;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.orderflow.Identity_Service.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table (name = "users",
        indexes = {
            @Index (name = "idx_users_email", columnList = "email"),
            @Index(name = "idx_users_username", columnList = "username")
        }
    )
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (nullable = false, unique = true, length = 50)
    private String email;

    @Column (nullable = false, unique = true, length = 50)
    private String username;

    @Column (name = "password_hash", nullable = false)
    private String passwordHash;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name", length = 50)
    private String lastName;

    @Column (name = "phone_number", unique = true, length = 25)
    private String phoneNumber;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false, length = 30)
    private UserStatus Status = UserStatus.PENDING_VERIFICATION;

    @Column (nullable = false)
    private boolean emailVerified;

    @Column (nullable = false)
    private boolean phoneVerified;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public UserEntity(final String email, final String username, final String passwordHash) {
            this.email = email;
            this.username = username;
            this.passwordHash = passwordHash;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserStatus getStatus() {
		return Status;
	}

	public void setStatus(UserStatus status) {
		Status = status;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createAt) {
		this.createdAt = createAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
}
