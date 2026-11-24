package com.orderflow.Identity_Service.entities;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table (
    name = "user_roles",
    uniqueConstraints = {
        @UniqueConstraint (
            name = "uk_user_roles_user_role",
            columnNames = {"user_id", "role_id"}
        )
    }
)
public class UserRole {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @CreationTimestamp
    @Column (name = "assigned_at", nullable = false, updatable = false)
    private Instant assignedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_by_user_id")
    private UserEntity assignedBy;

    protected UserRole() {
    }

    public UserRole(UserEntity user, Role role, UserEntity assignedBy) {
        this.user = user;
        this.role = role;
        this.assignedBy = assignedBy;
    }

    public UUID getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public Instant getAssignedAt() {
        return assignedAt;
    }

    public UserEntity getAssignedBy() {
        return assignedBy;
    }
}
