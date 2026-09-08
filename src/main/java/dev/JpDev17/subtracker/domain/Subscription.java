package dev.JpDev17.subtracker.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal value;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingCycle billingCycle;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType category;

    @NotNull
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate nextBillingDate;

    @Column(nullable = false)
    private boolean active = true;

    private LocalDate cancelledAt;

    public Subscription() {
    }

    public Subscription(Long id, String name, BigDecimal value, BillingCycle billingCycle, CategoryType category, LocalDate startDate, LocalDate nextBillingDate, boolean active, LocalDate cancelledAt) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.billingCycle = billingCycle;
        this.category = category;
        this.startDate = startDate;
        this.nextBillingDate = nextBillingDate;
        this.active = active;
        this.cancelledAt = cancelledAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDate cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", billingCycle=" + billingCycle +
                ", category=" + category +
                ", startDate=" + startDate +
                ", nextBillingDate=" + nextBillingDate +
                ", active=" + active +
                ", cancelledAt=" + cancelledAt +
                '}';
    }
}
