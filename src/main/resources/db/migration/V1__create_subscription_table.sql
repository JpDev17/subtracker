CREATE TABLE subscription (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    value NUMERIC(10, 2) NOT NULL CHECK (value > 0),
    billing_cycle VARCHAR(20) NOT NULL CHECK (billing_cycle IN ('MONTHLY', 'ANNUAL')),
    category VARCHAR(20) NOT NULL CHECK (category IN ('STREAMING', 'SOFTWARE', 'FITNESS', 'EDUCATION', 'OTHER')),
    start_date DATE NOT NULL,
    next_billing_date DATE NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    cancelled_at DATE
);

CREATE INDEX idx_subscription_next_billing_date ON subscription (next_billing_date) WHERE active = TRUE;

CREATE INDEX idx_subscription_category ON subscription (category) WHERE active = TRUE;
