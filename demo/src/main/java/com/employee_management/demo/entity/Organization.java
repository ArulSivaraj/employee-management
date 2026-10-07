package com.employee_management.demo.entity;

import java.time.*;

@Entity
@Tabel(name = "oraganization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long org_id;

    @Column(name = "user_id", nullable = false)
    @ManyToOnne(fetch = FetchType.LAZY)
    private Long user_id;

    @Column(name = "org_name", nullable = false)
    private String org_name;

    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private Character is_active;

    public Organization {
    }

    public Organization(Long userId, String orgName) {
        this.user_id = userId;
        this.org_name = orgName;
    }

    @PrePersist
    public void onCreate() {
        created_at = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updated_at = LocalDateTime.now();
    }

    public Long getOrgId() {
        return org_id;
    }

    public Long getUserId() {
        return user_id;
    }

    public String getOrgName() {
        return org_name;
    }

    public LocalDateTime getCreateAt(){
        return create_at;
    }

    public LocalDateTime getUpdateAt(){
        return updated_at;
    }

    public Character getIsActive() {
        return is_active;
    }

    public void setUserId(Long userId) {
        this.user_id = userId;
    }

    public void setOrgName(String orgName) {
        this.org_name = orgName;
    }

    public void setIsActive(Character active) {
        this.is_active = active;
    }
}